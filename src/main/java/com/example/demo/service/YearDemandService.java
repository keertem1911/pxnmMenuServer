package com.example.demo.service;

import com.example.demo.dao.*;
import com.example.demo.entity.Project;
import com.example.demo.entity.demand.*;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import lombok.extern.java.Log;
import org.apache.commons.beanutils.ConvertUtils;
import org.apache.commons.beanutils.converters.DateConverter;
import org.apache.commons.beanutils.converters.DoubleConverter;
import org.apache.commons.beanutils.converters.IntegerConverter;
import org.apache.commons.lang3.StringUtils;
import org.apache.logging.log4j.util.Strings;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.*;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Type;
import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

@Service
@Log
public class YearDemandService {

//    @Autowired
//     private YearDemandLogJpaRespository yearDemandLogJpaRespository;
    @Autowired
     private YearDemandProjectJpaRespository yearDemandProjectJpaRespository;
    @Autowired
     private YearDemandStatisticsJpaRespository yearDemandStatisticsJpaRespository;
    @Autowired
     private YearDemandWriteJpaRespository yearDemandWriteJpaRespository;
    @Autowired
     private YearPlanHrProjectJpaRespository yearPlanHrProjectJpaRespository;
    @Autowired
     private YearPlanProjectJpaRespository yearPlanProjectJpaRespository;
    @Autowired
    private YearDemandAdjustJpaRespository yearDemandAdjustJpaRespository;

    @Autowired
    private ProjectJpaRespository projectJpaRespository;

    @Transactional
    public void handlerDemand(){


//        List<YearDemandLog> logs = yearDemandLogJpaRespository.findAll();
        List<YearDemandProject> demandProjects = yearDemandProjectJpaRespository.findAll();
        List<YearDemandStatistics> statistics = yearDemandStatisticsJpaRespository.findAll();
        List<YearDemandWrite> writes = yearDemandWriteJpaRespository.findAll();
        List<YearPlanHrProject> projectHrs = yearPlanHrProjectJpaRespository.findAll();
        List<YearPlanProject> projects = yearPlanProjectJpaRespository.findAll();
        List<PxYearDemandAdjust> ajust = yearDemandAdjustJpaRespository.findAll();
        //同步下发项目字段信息
        projects.forEach(d->{
            log.info("培训项目id"+d.getProjectId());
            Project projectLib = projectJpaRespository.findById(d.getProjectId()).get();
            String id=d.getId();
            Date createTime=d.getCreateTime();
            ConvertUtils.register(new DoubleConverter(null), Double.class);
            ConvertUtils.register(new IntegerConverter(null), Integer.class);
            ConvertUtils.register(new DateConverter(null), java.util.Date.class);
            BeanUtils.copyProperties(projectLib,d);
            d.setId(id);
            d.setCreateTime(createTime);
//            d.setProjectId(projectLib.getId());
            yearPlanProjectJpaRespository.save(d);
        });


        Map<String,String> adjustMap=ajust.stream().collect(Collectors.toMap(PxYearDemandAdjust::getProjectIdOld
                , PxYearDemandAdjust::getProjectIdNew));
        log.info("人力资源需求下发的项目 将调整表里面--------------");
//         人力资源需求下发的项目 将调整表里面
        Map<String, List<YearPlanHrProject>> hrProjectGroupBy = projectHrs.stream().filter(d -> adjustMap.containsKey(d.getProjectId()))
                .collect(Collectors.groupingBy(d -> adjustMap.get(d.getProjectId())));
        for (String newProject : hrProjectGroupBy.keySet()) {
            List<YearPlanHrProject> hrList = hrProjectGroupBy.get(newProject);
            long sameProjectCount = hrList.stream().filter(d -> d.getProjectId().equals(newProject))
                    .count();
            if(sameProjectCount==0){// 无替换的项目
                YearPlanHrProject item = hrList.get(0);
                item.setProjectId(newProject);
                yearPlanHrProjectJpaRespository.save(item);
            }
            hrList.stream().filter(d -> !d.getProjectId().equals(newProject))
                    .collect(Collectors.toList())
                    .forEach(d->yearPlanHrProjectJpaRespository.delete(d));
        }
        log.info("个人填报 重复删除writes 级联删除--------------------");
        // 个人填报 重复删除writes 级联删除
        Map<String, List<YearDemandWrite>> writeYearGroup = writes.stream().filter(d -> adjustMap.containsKey(d.getProjectId()))
                .collect(Collectors.groupingBy(YearDemandWrite::getYearDemandId));
        for (String yearDemandWriteId : writeYearGroup.keySet()) {
            Map<String, List<YearDemandWrite>> yearPlanAdjustGroup = writeYearGroup.get(yearDemandWriteId).stream()
                    .filter(d -> adjustMap.containsKey(d.getProjectId()))
                    .collect(Collectors.groupingBy(d -> adjustMap.get(d.getProjectId())));
            // 调整的项目分类
            for (String newProject : yearPlanAdjustGroup.keySet()) {
                List<YearDemandWrite> projectList = yearPlanAdjustGroup.get(newProject);
                long sameProjectCount = projectList.stream().filter(d -> d.getProjectId().equals(newProject))
                        .count();
                if(sameProjectCount==0){// 无替换的项目
                    YearDemandWrite item = projectList.get(0);
                    item.setProjectId(newProject);
                    yearDemandWriteJpaRespository.save(item);
                }
                projectList.stream().filter(d -> !d.getProjectId().equals(newProject))
                        .collect(Collectors.toList())
                        .forEach(d->yearDemandWriteJpaRespository.delete(d));
            }
        }


        log.info("需求下发项目 px_year_demand_project-------------------------");
//        需求下发项目 px_year_demand_project
        Function<YearDemandProject,String> groupCondition=
                yearDemandProject->yearDemandProject.getPxYearDemand()+"-"+yearDemandProject.getType();

        Map<String, List<YearDemandProject>> demandProjectGroupMap = demandProjects.stream().filter(d -> adjustMap.containsKey(d.getProjectId()))
                .collect(Collectors.groupingBy(groupCondition));
        for (String yearDemandProjectId : demandProjectGroupMap.keySet()) {
            Map<String, List<YearDemandProject>> yearPlanAdjustGroup = demandProjectGroupMap.get(yearDemandProjectId).stream()
                    .collect(Collectors.groupingBy(d -> adjustMap.get(d.getProjectId())));
            // 调整的项目分类
            for (String newProject : yearPlanAdjustGroup.keySet()) {
                List<YearDemandProject> projectList = yearPlanAdjustGroup.get(newProject);
                long sameProjectCount = projectList.stream().filter(d -> d.getProjectId().equals(newProject))
                        .count();
                if(sameProjectCount==0){// 无替换的项目
                    YearDemandProject item = projectList.get(0);
                    item.setProjectId(newProject);
                    yearDemandProjectJpaRespository.save(item);
                }
                projectList.stream().filter(d -> !d.getProjectId().equals(newProject))
                        .collect(Collectors.toList())
                        .forEach(d->yearDemandProjectJpaRespository.delete(d));
            }
        }
        log.info(" 基层下发项目----------------------");
//         基层下发项目
        Map<String, List<YearPlanProject>> groupByYearPlan
                = projects.stream().collect(Collectors.groupingBy(YearPlanProject::getYearPlanId));
        for (String yearPlanId : groupByYearPlan.keySet()) {
            Map<String, List<YearPlanProject>> yearPlanAdjustGroup = groupByYearPlan.get(yearPlanId).stream()
                    .filter(d -> adjustMap.containsKey(d.getProjectId()))
                    .collect(Collectors.groupingBy(d -> adjustMap.get(d.getProjectId())));
            // 调整的项目分类
            for (final String newProject : yearPlanAdjustGroup.keySet()) {
                List<YearPlanProject> projectList = yearPlanAdjustGroup.get(newProject);
                long sameProjectCount = projectList.stream().filter(d -> d.getProjectId().equals(newProject))
                        .count();
                if(sameProjectCount==0){// 无替换的项目
                    YearPlanProject item = projectList.get(0);
                    YearPlanProject yearplanproject = yearPlanProjectJpaRespository.findByYearIdAndProjectId(item.getYearPlanId(), newProject);
                    if(yearplanproject==null){
                        item.setProjectId(newProject);
                        yearPlanProjectJpaRespository.save(item);
                    }
                }
                if(projectList.size()>1)
                projectList.stream().filter(d -> !d.getProjectId().equals(newProject))
                        .collect(Collectors.toList())
                        .forEach(d->yearPlanProjectJpaRespository.delete(d));
            }
        }
        log.info("需求汇总项目合并------------------------");
//         需求汇总项目合并
        Function<YearDemandStatistics,String> groupStaticsCondition=
                d->d.getYearDemandId()+"-"+d.getSumType();
        Map<String, List<YearDemandStatistics>> statisticsYearGroup =
                statistics.stream().filter(d -> adjustMap.containsKey(d.getProjectId()))
                .collect(Collectors.groupingBy(groupStaticsCondition));
        for (String statisticsId : statisticsYearGroup.keySet()) {
            Map<String, List<YearDemandStatistics>> yearPlanAdjustGroup = statisticsYearGroup.get(statisticsId)
                    .stream()
                    .collect(Collectors.groupingBy(d -> adjustMap.get(d.getProjectId())));
            // 调整的项目分类
            for (String newProject : yearPlanAdjustGroup.keySet()) {
                List<YearDemandStatistics> projectList = yearPlanAdjustGroup.get(newProject);
                List<YearDemandStatistics> sameProjectList = projectList.stream().filter(d -> d.getProjectId().equals(newProject))
                        .collect(Collectors.toList());
                YearDemandStatistics targetStatistics=null;
                    int index=0;
                if(sameProjectList!=null&&sameProjectList.size()>0){// 无替换的项目
                    for ( index = 0; index < projectList.size(); index++) {
                            if(projectList.get(index).getProjectId().equals(newProject))
                                break;
                    }

                }
                    targetStatistics = projectList.get(index);
                    projectList.remove(index);
                    targetStatistics.setProjectId(newProject);

//                    final YearDemandStatistics sumYearDemand=new YearDemandStatistics();
                // 合并信息
                if(projectList.size()>0){
                    for (YearDemandStatistics yearDemandStatistics : projectList) {
                        reflectStatisticsSum(yearDemandStatistics,targetStatistics);
                    }
                }
//                reflectStatisticsSum(sumYearDemand,targetStatistics,false);
//                addSumNoSourse(sumYearDemand,targetStatistics);
//                BeanUtils.copyProperties(sumYearDemand,targetStatistics);
                yearDemandStatisticsJpaRespository.save(targetStatistics);
//                if(projectList.size()>1)
                projectList
                        .forEach(d->yearDemandStatisticsJpaRespository.delete(d));
            }
        }


        log.info("finish !!!!");
     }

     private void reflectStatisticsSum(YearDemandStatistics oldStatistics
             , YearDemandStatistics targetStatistics){
         String filedNumebr[]= {
                        "Month1",
                         "Month2",
                         "Month3",
                         "Month4",
                         "Month5",
                         "Month6",
                         "Month7",
                         "Month8",
                         "Month9",
                         "Month10",
                         "Month11",
                         "Month12",
                         "NpTeaching",
                         "NpStay",
                         "NpLife",
                         "NpTraffic",
                         "WpTeachingPrimary",
                         "WpTeachingMiddle",
                         "WpTeachingSenior",
                         "WpTrainingPrimary",
                         "WpTrainingMiddle",
                         "WpTrainingSenior",
                         "WpPaper",
                         "WpQuestion",
                         "WpInvigilate",
                         "WpUnderground",
                         "WpGround",
                         "WpProvincial",
                         "WpProvincialOther",
                         "WpCarAllowance",
                         "WpMeal",
                         "WpMaster",
                         "WpOther",
                         "CostBudget",
                         "NpOther",
                         "WpMarking"};
         Class<YearDemandStatistics> claszz = YearDemandStatistics.class;
         for (String field : filedNumebr) {
             try {
                 Method getMethod = claszz.getDeclaredMethod("get" + field);
                 Method setMethod = claszz.getDeclaredMethod("set" + field, Double.class);

                 Object oldValueObj =  getMethod.invoke(oldStatistics);
                 Object targetValueObj =  getMethod.invoke(targetStatistics);
                 Double oldValue=0.0,targetValue=0.0;
                 if(oldValueObj!=null)oldValue=(Double)oldValueObj;
                 if(targetValueObj!=null)targetValue=(Double)targetValueObj;

                 targetValue=targetValue+oldValue;
                 setMethod.invoke(targetStatistics,targetValue);
             } catch (NoSuchMethodException e) {
                 e.printStackTrace();
             } catch (IllegalAccessException e) {
                 e.printStackTrace();
             } catch (InvocationTargetException e) {
                 e.printStackTrace();
             }
         }
    }

    /**
     * 处理特种作业取证和换证
     * 煤化工和非煤
     * 新id			旧id	单位类型
     * 2c90808e6eb733ef016eb73478850005	特种作业人员操作证取证培训	特种作业取证	7364e351cafa471599196ae7a7c2650b	1,3,4
     * 2c90808e6eb733ef016eb73478850005	特种作业人员操作证取证培训	煤矿（非煤）特种作业资格培训	2cea22bc640843aa81e67c111b8d5029	1,3,4
     * 2c90808e6eb733ef016eb73478850005	特种作业人员操作证取证培训	煤矿（非煤）特种作业取证	b7931b70bc984cadb7880e39eba93bbc	1,3,4
     * 2c90808e6eb733ef016eb734789a0006	危化品安全作业取证培训	特种作业取证	7364e351cafa471599196ae7a7c2650b	2
     * 2c90808e6eb733ef016eb734789a0006	危化品安全作业取证培训	煤矿（非煤）特种作业资格培训	2cea22bc640843aa81e67c111b8d5029	2
     * 2c90808e6eb733ef016eb734789a0006	危化品安全作业取证培训	煤矿（非煤）特种作业取证	b7931b70bc984cadb7880e39eba93bbc	2
     * 2c90808e6eb733ef016eb73478c00008	危化品安全作业换证培训	特种作业复审	4dbb5ff93d3d4a38ac6c0088e3714335	2
     * 2c90808e6eb733ef016eb73478c00008	危化品安全作业换证培训	煤矿（非煤）特种作业资格复审换证培训	49627bf485794babbc13f75bccf7875a	2
     * 2c90808e6eb733ef016eb73478c00008	危化品安全作业换证培训	煤矿（非煤）特种作业复审	42fed86c4abb43a591e023872e6c4016	2
     * 2c90808e6eb733ef016eb73478d10009	特种作业人员操作证复训	特种作业复审	4dbb5ff93d3d4a38ac6c0088e3714335	1,3,4
     * 2c90808e6eb733ef016eb73478d10009	特种作业人员操作证复训	煤矿（非煤）特种作业资格复审换证培训	49627bf485794babbc13f75bccf7875a	1,3,4
     * 2c90808e6eb733ef016eb73478d10009	特种作业人员操作证复训	煤矿（非煤）特种作业复审	42fed86c4abb43a591e023872e6c4016	1,3,4
     */
    @Transactional
    public void handerSpescal(){
        String data[][]=
        {{"2c90808e6eb733ef016eb73478850005",	"7364e351cafa471599196ae7a7c2650b",	"1"},
        {"2c90808e6eb733ef016eb73478850005",	"2cea22bc640843aa81e67c111b8d5029",	"1"},
            {"2c90808e6eb733ef016eb73478850005",	"b7931b70bc984cadb7880e39eba93bbc",	"1"},
            {"2c90808e6eb733ef016eb734789a0006",	"7364e351cafa471599196ae7a7c2650b",	"2"},
            {"2c90808e6eb733ef016eb734789a0006",	"2cea22bc640843aa81e67c111b8d5029",	"2"},
            {"2c90808e6eb733ef016eb734789a0006",	"b7931b70bc984cadb7880e39eba93bbc",	"2"},
            {"2c90808e6eb733ef016eb73478c00008",	"4dbb5ff93d3d4a38ac6c0088e3714335",	"2"},
            {"2c90808e6eb733ef016eb73478c00008",	"49627bf485794babbc13f75bccf7875a",	"2"},
            {"2c90808e6eb733ef016eb73478c00008",	"42fed86c4abb43a591e023872e6c4016",	"2"},
            {"2c90808e6eb733ef016eb73478d10009",	"4dbb5ff93d3d4a38ac6c0088e3714335",	"1"},
            {"2c90808e6eb733ef016eb73478d10009",	"49627bf485794babbc13f75bccf7875a",	"1"},
            {"2c90808e6eb733ef016eb73478d10009",	"42fed86c4abb43a591e023872e6c4016",	"1"}};
        Map<String,List<String>> map=new HashMap<>();
        for (String[] datum : data) {
            List<String> ids=null;
            if(map.containsKey(datum[0])){
                ids= map.get(datum[0]);
            }else{
                ids=new ArrayList<>();
                map.put(datum[0],ids);
            }
                ids.add(datum[1]);
        }
        Function<YearDemandStatistics,String> groupStaticsCondition=
                d->d.getYearDemandId()+"-"+d.getSumType();
        for (String s : map.keySet()) {
            String num= s.substring(s.length()-1);
            Integer p=Integer.parseInt(num);
            List<String> ids = map.get(s);
            List<YearDemandStatistics>  demandStatistics=null;
            List<YearDemandStatistics>  demandStatistics1=null;
            if(p%2==0){
                demandStatistics =
                        yearDemandStatisticsJpaRespository.findAllByProjectIdAndType(2,ids);

                demandStatistics1 =
                        yearDemandStatisticsJpaRespository.findAllByProjectIdAndTypeSum(2,ids);

            }else{
               demandStatistics=
                        yearDemandStatisticsJpaRespository.findAllByProjectIdAndNotType(2,ids);
               demandStatistics1=
                        yearDemandStatisticsJpaRespository.findAllByProjectIdAndNotTypeSum(2,ids);
            }
            demandStatistics.addAll(demandStatistics1);

            Map<String, List<YearDemandStatistics>> statisticsYearGroup = demandStatistics.stream().collect(Collectors.groupingBy(groupStaticsCondition));
            for (String statisticsId : statisticsYearGroup.keySet()) {
                List<YearDemandStatistics> projectList = statisticsYearGroup.get(statisticsId);

                    YearDemandStatistics targetStatistics=projectList.get(0);;
                    targetStatistics.setProjectId(s);
                    final YearDemandStatistics sumYearDemand=new YearDemandStatistics();
                    // 合并信息
//                    projectList.forEach(d->{
//                        reflectStatisticsSum(d,sumYearDemand,true);
//                    });
//                    reflectStatisticsSum(sumYearDemand,targetStatistics,false);
                    yearDemandStatisticsJpaRespository.save(targetStatistics);

                    if(projectList.size()>1)
                        projectList.stream().filter(d -> !d.getProjectId().equals(s))
                                .collect(Collectors.toList())
                                .forEach(d->yearDemandStatisticsJpaRespository.delete(d));
            }


        }

    }

    public void saveObj() {
        String [] ids= {"1338b9be9b32400d8c9a58196b3fad06",
                "9648cccb87b142fb8be1e83f4180f1c3",
                "6c82d1372aab4395a9a03af709928513",
                "c8d2c6b41b554719b7ffeed324ec99e9",
                "9b73652bf687492cabbb00765dd84fb9",
                "8b5482fb68a34fe2b4a7ac08fe591268",
                "cabbe37055cb47a0a1ac502d2c292be0",
                "f2b9edad15b642eebe1e6f1778cb82e3",
                "1feb48d07cd8489a8b48cc4ecd9f1c78",
                "a3e9996cd6204d2e8edc0373f955210f",
                "895e858185a24777b9ec47e3987ce8d6",
                "854920e0ef0e470a9568083b4eec5eb3",
                "475cba4dc3b042d5a3cdf27785039ce5",
                "a46bc81d49b248fb803b9ff56b88d298",
                "22af03a4c27649018540cf94c916fce6",
                "37733ff052f04a98a31e389a16a26c00",
                "d69a4698463446c484a4b6fa9bd78cb4",
                "f380d97c9c39407b985f3f5d1870f81c",
                "9c32bf0b2ff8413fb2be581b9b2a34fb",
                "6b89e94b5a4e41949f0be5fb6617ee22",
                "862d74d06fcd40d2b51d1e25c873ba01",
                "0ae184b7e49a40169f6f3ec1d0af7c51",
                "efb620ca899743d9b8761a8643faab3d",
                "c3530d6df9d247b9b4e7da7e578262d7",
                "cb7f7524ea144b65a0ac87782088a39c",
                "60ff8c8df99d47a588f22f1cd23fa3d2",
                "fca7285f2129492585af3b25dd922e8a",
                "aecdf8cb6feb45b0b4606310622a8584",
                "69f0a0cb817e4c8f96f58aca3ae3d00c",
                "090c63d36b254349a21160455615081a",
                "5d6bcc4848c7466bbc86679a4671cccc",
                "17bded8435f24cbaac4d5a24db19958a",
                "108461b2b2eb4bb8877af7ba44b3eded",
                "932107795a3d4621bc60c70f6b662234",
                "fd7a52e2d51f40d2bf2414fb7f9968a2",
                "f05360a5bdc443129c19d7d3b1146fea",
                "c85a0d070b7b4593ab8b9d19dc6bfc42",
                "16aa798e4ed3432d89bcb076b7cb6557",
                "34c141e0469c4279a087fa20f71cc92c",
                "c108ea1544504011bcab7388c6f7523f",
                "01ad0c72c9574640abf569516b2828b6",
                "a86af0b2195448f49f7f48cb68eda774",
                "5c6c47c8e66248599300e26ccfcf0a88",
                "cdf6cae183fe4b2eb11441db1907c31b",
                "988f6144838c46248e16e64c0ba00c7d",
                "255a54998d0e4f7fb6ee53e902ca343d",
                "4c469453a45d4f4387c127513d50c0a3",
                "9afd584435954e489799509eedfc7531",
                "c4c3c566d3b349cca087bf1896f64182",
                "9b3f8b83a59a4dccb542bbfa8057226b",
                "707c49198de7462c80b1ced7e3654d36",
                "7c0b560328ca47d7a4652eccccc1a1bd",
                "70e08c0e49454a208dacbd1c792584a2",
                "a0287c59b9454b389089d5603cff3a98",
                "3fc845d72b4744ff88f471738faaa596",
                "db547c5027f049f5a6656db1fccf20c6",
                "d4b67b5f1be449d1ac95a9460d1e9e63",
                "6a845dbb67d04b8eae34b3f8ff635f93",
                "0f77eca8878b4ee18aa1529fb1d12e52",
                "2ecefd953fef4e96842d03dcd6b0254b",
                "dc8c2d74406645ac93281b714a1c3cb7",
                "afd89d9f5a794014bff39b1f2793bb99",
                "adf520e07f47426ebe6fe8d81d7acf9b",
                "d3273603879444a58643d573a34a1443",
                "a956fdd0f76843dca75f2bee2d70495b",
                "2025a9e4b8e24a378d49cd7c8b3db314",
                "fed0b49bbe254acd8d3509c389396329",
                "3dc5a69023fd41ffaccd5db3a9ffa61e",
                "07388fb98bb14b8aafbb7926ee40445c",
                "47fee11d0adb4bfeb63a2713608edf16",
                "d3084a00a1d1402e9c0d208fee61531b",
                "3955be2054e04d25b2fe3b2ef6a4d126",
                "6a2b3c19bfba48cd95073bc3785288ed",
                "8d28de48c3294b58a7d20ea6f02f00cd",
                "b4dc02b4415d42038d2a3563b2c9876e",
                "5b420b307c2142288b6d569ea83f3985",
                "b8d9addd1b8d4b93b731f272b318954d",
                "23de34db3401492e85f0d80a200720e4",
                "0302abb21b1043219f4f79e3e3293d7e",
                "3694f8cfcba049dabedcbaa95a420575",
                "6595bc69a5e64f81bded2369ce1c6c4d",
                "c871cf5024b1443ea1d6ad02a58c9a90",
                "a51501272ccb4709b7261ac1ab62adf9",
                "cba167d12f4744e5a9eb11e8d811cacf",
                "df12854471bc4143a9a68821207ba0d1",
                "491625a18d724a67929523f153082760",
                "51205c40f2d94e198ee366af12311993",
                "f485f23f194349aaa0787eefd889cfa9",
                "5e6f1b21e3e2405c8b188af4ede33779",
                "56ccf96fbe3f4f86b5e7550889b8cf1f",
                "40a7345abe9d4831b9718c1da2a42de0",
                "eab4d9ee68434360a6f8ee6e7224499c",
                "76211c0748174a97b267d631980d6172",
                "8f44a46042354a459419a73a2ec65da7",
                "a5d062199132419a839431491a89905f",
                "50bd873224b34f428c86122ca2a509ea",
                "b5b2e86fc5dc40b2adb12dfd70ac03b9",
                "2ba21b94629547a5b932a959a4d2df3d",
                "05a823e61d494eed8ab7b289b0d09b31",
                "2513828be23f4a1a99a607d0537d012d",
                "a49d8a6eb8c343b29ad9b8b4dc5112dc",
                "040e10dfa46c447dbf5fdf8272655d0f",
                "9223c5e390e4401ab47c10be8981f5b2",
                "57c662528a944d1ba99d18e2d29356e2",
                "43d0344d417449998580419ff738bd1c",
                "ee0564284a784456a661ee8a561d5f2b",
                "f88e7fd09b764208a570387359476410",
                "fc0fc337175f40889c1a9a0e5376b72d",
                "aaf8a078fb06412db1b35d0dff34ea99",
                "ccd026296bbb488d9fe45f77d786b9b1",
                "d998821516c04889979b9b9b3a263af5",
                "33e51325d0754f88a90290f872e51f58",
                "627bd956b9d94b7ea5766048a5da77e2",
                "814599221a7544ba9d3107658877c051",
                "ae15ef0523cb41b28e1fc40f278bcd8c",
                "9a133fb86c5c4ff5b9185d9f45d7fa61",
                "fe999f63073b4c8da5c10ac34a37bc47",
                "4ebeea2ba977458d9b29c49637c48c41",
                "1c4c64ad66a6411ba39c4f7574578fd2",
                "29f202e4e4fa46719ae49b36270c9950",
                "5a492ef364fa4873ba0b40b77e813ad5",
                "86b4bd91063d46e2a4db215774e0bc1e",
                "e694db4965a043a084b55cae9f307514",
                "b613ca8c16744f65b4b104ace583ff1d",
                "28fa40de1c934225bb40d56bc21c1372",
                "6ede440a453a46b0b48b45a07d059d14",
                "6a50d2a3b6b9449884ae9ba894711dc0",
                "18722c2867284052b7f92a7ad90b6653",
                "01a77b55bcee4bb4beb64e59d060488a",
                "77c131ddb5654961be7ffe93035db369",
                "324e4e15ba7042daab3bc99da1f27600",
                "9fcbcc42ed6244a597281062c5786438",
                "470dd0a2f4c247d6a63d6d392a2261cc",
                "1bfda1ec64604b9daf807d25c52be8ed",
                "0b67cce084784ed2aab0b7ee43dded79",
                "7c7d18a24e954232936c310ca5428ea7",
                "5d657e51a4e64da1ba0c656315a17e24",
                "4c645f5cc9bf4820a7b7c1a9b2b95e78",
                "bf8138c8f44746768726d7fd4b28d3e4",
                "46cd5642fff5470da913c4e92c07364d",
                "125179755dbb4c52bb30956fd37956d9",
                "cc8574d669104b9aa55b6437303dd2a0",
                "3ba40292facf49f0a0baa2e4ed8b733c",
                "1f16e873768c444ba8a73b1f1fb6c234",
                "1c8222c38c504e1cbc23c259e066936a",
                "adee0ffcef9a45e2b645d054a41ab387",
                "542f64cbe29a40a993a4a1e1a90c20e6",
                "ffe123118bae4276a35ea73b481d557b",
                "6bfa2617e8df40acba51cb576899173e",
                "0936ce87efa7470d81483587ef3cba8d",
                "d76955b2e19440b1aa399db5d3bad0c2",
                "e8948b799c904f2aa9540f90be47cd7c",
                "a8a07bfbd131447aba627181e7702dc6",
                "9ba2aa07301244d69504813eb4de284a",
                "e31caf5e31c448da8202003e5acb7786",
                "616595d6933e4597b937c5fabc2575b6",
                "7e26ab6da96041a2b9b644ccbb50fc9b",
                "feaaf626c7474ff79f0132ef8457d1fe",
                "c4281fed812f40c98fadf3e2b12fa883",
                "755423005dab4b28826a5cc941b0a0da",
                "82aa82c572e74ab39826025c1f7a9932",
                "69f40760ba854529b37412e43d5c5f0b",
                "afcba675fa9942d68085708c1a20b18d",
                "c34bb11e083f4279b1ad3ad144b2779e"};
        List<String> idsS = Arrays.asList(ids);
        List<YearDemandStatistics> list=
                yearDemandStatisticsJpaRespository.findByIds(idsS);
        log.info(list.size()+" ");
        Gson gson=new Gson();
        String json = gson.toJson(list);
        System.out.println(json);
        try {
            FileWriter writer=new FileWriter("e://d.txt");

            writer.write(json);
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    @Transactional
    public void readToYearDemand(){
        StringBuffer json=new StringBuffer();
        try {
            BufferedReader input = new BufferedReader(new InputStreamReader(new FileInputStream("e://d.txt")));
            String s=null;
            while ((s=input.readLine())!=null){
                json.append(s);
            }
            input.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }catch (Exception e){
            e.printStackTrace();
        }

        Gson gson=new Gson();
        Type type = new TypeToken<List<YearDemandStatistics>>() {
        }.getType();
        List<YearDemandStatistics> list=gson.fromJson(json.toString(),type);
        for (YearDemandStatistics yearDemandStatistics : list) {
            yearDemandStatisticsJpaRespository.save(yearDemandStatistics);
        }
    }
}
