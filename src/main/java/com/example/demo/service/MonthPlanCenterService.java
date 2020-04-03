package com.example.demo.service;

import com.example.demo.dao.MonthPlanCenterProjectRepository;
import com.example.demo.dao.MonthPlanCenterRepository;
import com.example.demo.dao.MonthPlanCenterScheduleRepository;
import com.example.demo.entity.monthcenter.MonthPlanCenterSchedule;
import com.example.demo.entity.monthcenter.PxMonthPlanCenter;
import com.example.demo.entity.monthcenter.PxMonthPlanCenterProject;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

/**
 * @author 王传鑫
 * @date 2020/2/1315:25
 */
@Service
public class MonthPlanCenterService {
    @Autowired
    private MonthPlanCenterRepository monthPlanCenterRepository;
    @Autowired
    private MonthPlanCenterProjectRepository monthPlanCenterProjectRepository;

    @Autowired
    private MonthPlanCenterScheduleRepository monthPlanCenterScheduleRepository;

    public void getByMonth(String year,String month){
        List<PxMonthPlanCenter> list = monthPlanCenterRepository.getOneByPxYearAndPxMonth(year,month);
        System.out.println(list.size());
    }
    public void handlerLastMonth(String year,String fromMonth,String toMonth){

        List<PxMonthPlanCenter> fromMonthList = monthPlanCenterRepository.getOneByPxYearAndPxMonth(year, fromMonth);
        PxMonthPlanCenter monthPlanFrom = fromMonthList.get(0);
        List<String> lastMonthList = monthPlanCenterProjectRepository.getMonthPlanCenter(monthPlanFrom.getId());
        String toMonthPlanId = monthPlanCenterRepository.getOneByPxYearAndPxMonth(year, toMonth).get(0).getId();

//        List<PxMonthPlanCenterProject> ids=monthPlanCenterProjectRepository.getLastMonth(toMonthPlanId);
//        ids.stream().forEach(d->monthPlanCenterProjectRepository.delete(d));

        if(lastMonthList.size()>0){// 顺延班级
            Integer lastMonth=Integer.parseInt(toMonth)-1;
            String lastMonthStr=lastMonth+"月顺延";
            for (String lastId : lastMonthList) {
                PxMonthPlanCenterProject lastProject = monthPlanCenterProjectRepository.getOne(lastId);
                PxMonthPlanCenterProject newLastProject=new PxMonthPlanCenterProject();
                BeanUtils.copyProperties(lastProject,newLastProject);
                newLastProject.setLastMonthClass(lastMonthStr);
                if(StringUtils.isNotBlank(newLastProject.getRemark()))
                    newLastProject.setRemark(newLastProject.getRemark()+" "+lastMonthStr);
                else
                    newLastProject.setRemark(lastMonthStr);
                newLastProject.setId(null);
                newLastProject.setPxMonthPlanCenter(toMonthPlanId);
                newLastProject.setCreateTime(new Date());
                newLastProject.setCreateUserId("admin");
                PxMonthPlanCenterProject newAdd = monthPlanCenterProjectRepository.save(newLastProject);
                List<MonthPlanCenterSchedule> schedules=monthPlanCenterScheduleRepository.getPxYearAndPxMonth(lastId);
                for (MonthPlanCenterSchedule schedule : schedules) {
                    MonthPlanCenterSchedule newSchedule=new MonthPlanCenterSchedule();
                    BeanUtils.copyProperties(schedule,newSchedule);
                    newSchedule.setId(null);
                    newSchedule.setPxMonthPlanCenterProject(newAdd.getId());
                    monthPlanCenterScheduleRepository.save(newSchedule);
                }



            }

        }
    }

}
