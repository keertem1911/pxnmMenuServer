package com.example.demo.service;

import com.example.demo.dao.ProjectClassifyJpaRespository;
import com.example.demo.dao.ProjectJpaRespository;
import com.example.demo.entity.Project;
import com.example.demo.entity.ProjectClassify;
import lombok.extern.java.Log;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Log
public class ProjectClassifyService {

    @Autowired
    private ProjectClassifyJpaRespository projectClassifyJpaRespository;
    @Autowired
    private ProjectJpaRespository projectJpaRespository;
    public List<ProjectClassify> findAll(){
        return  projectClassifyJpaRespository.findAll();
    }
    public ProjectClassify save(ProjectClassify ProjectClassify){
        return projectClassifyJpaRespository.save(ProjectClassify);
    }
    public ProjectClassify getOne(String orgId){
        return projectClassifyJpaRespository.getOne(orgId);
    }

    @Transactional
    public void readExeclIntoMonth(List<List<Object>> list) {
        Map<String, List<List<Object>>>
                groupByParentMap = list.stream().collect(Collectors.groupingBy(d -> d.get(0) + "".trim()));
        int count=0;
        for (String parentName : groupByParentMap.keySet()) {
            List<List<Object>> children = groupByParentMap.get(parentName);

            if(StringUtils.isNotBlank(parentName)){
                count=0;
                ProjectClassify parentBean=
                        projectClassifyJpaRespository.findOneByName(parentName.trim());
                for (int i = 0; i < children.size(); i++) {
                    List<Object> bean = children.get(i);
                    String son=bean.get(1)+"".trim();


                    ProjectClassify sonBean = projectClassifyJpaRespository.findByNameAndParent(son,parentBean.getId());
                    boolean isSave=true;
                    if(sonBean==null){
                        sonBean=new ProjectClassify();
                        sonBean.setParent(parentBean.getId());
                        sonBean.setName(son);
                        sonBean.setIsMonth("Y");
                        count++;
                        sonBean.setOrderIndex(count+0.0);
                    }else if("Y".equals(sonBean.getIsMonth())) {
                        isSave=false;
                    }else{
                        log.info(count + "" + sonBean.toString());
                        sonBean.setIsMonth("Y");
                        count++;
                        sonBean.setOrderIndex(count+0.0);
                    }
                    sonBean.setRemark("月度导入分类");
                    if(isSave)
                        projectClassifyJpaRespository.save(sonBean);
                }

            }
        }

    }

    @Transactional
    public void readExeclIntoProject(List<List<Object>> list) {
        List<ProjectClassify> projectClassifies=projectClassifyJpaRespository.findAllByIsMonth("Y");
        Map<String, List<ProjectClassify>> groupByMap = projectClassifies.stream().collect(
                Collectors.groupingBy(ProjectClassify::getName)
        );
        for (int i=0;i<list.size();++i) {
            List<Object> project = list.get(i);
            String classify=""+project.get(1);
            String orderIndex= ""+project.get(2);
            String name = "" + project.get(3);
            if(StringUtils.isBlank(name))
                continue;
            String mapid=null,companyType=null,companyTypeName=null;
            if(project.size()>4) {
                mapid = "" + project.get(4);
                if (project.size() > 5) {
                    companyType = "" + project.get(5);
                    companyTypeName = "" + project.get(6);

                }
            }
            // 新增分类挂载点
            ProjectClassify handlerProjectClassify = groupByMap.get(classify).get(0);
            Project newProject = projectJpaRespository.findOneByNameAndClassifty(name, handlerProjectClassify.getId());
//            if(newProjectAdd!=null)
//                continue;

            if(StringUtils.isNotBlank(mapid)){
                Optional<Project> oldProject = projectJpaRespository.findById(mapid);
                if(oldProject.isPresent()){
                    Project p = oldProject.get();
                    if(name.equals(p.getName())&&handlerProjectClassify.getId().equals(p.getProjectClassifyId())){
                        if(newProject==null)
                        newProject=p;

                    }else {
                        String newId=null;
                        if(newProject!=null&&StringUtils.isNotBlank(newProject.getId()))
                            newId=newProject.getId();
                        else newProject=new Project();
                        BeanUtils.copyProperties(p, newProject);
                        newProject.setId(newId);
                    }
                }
            }
            if(newProject==null)newProject=new Project();
            if(StringUtils.isNotBlank(companyType)){
                newProject.setCompanyType(companyType);
                newProject.setCompanyTypeName(companyTypeName);
            }
            if(StringUtils.isBlank(newProject.getId())) {
                newProject.setProjectClassifyId(handlerProjectClassify.getId());
                newProject.setPxType("2");
                newProject.setProjectSource("1");
                newProject.setCreateUserId("admin");
                newProject.setCreateUserName("超级管理员");
                newProject.setName(name);
            }
                newProject.setIsMonth("Y");
                newProject.setOrderIndex(Double.parseDouble(orderIndex));
                log.info(newProject.toString());
                projectJpaRespository.save(newProject);
        }
    }

    /**
     * 合并需求单位类型
     * @param list
     */
    @Transactional
    public void readExeclCompanyType(List<List<Object>> list) {
        for (List<Object> objects : list) {
            String id=""+objects.get(0);
            String companyName=""+objects.get(7);
            String companyIds=""+objects.get(8);
            Project project = projectJpaRespository.getOne(id);
            project.setCompanyTypeName(companyName);
            project.setCompanyType(companyIds);
            projectJpaRespository.save(project);
            log.info(String.format("update id=%s,companyName=%s,companyIds=%s ", id,companyName,companyIds));
        }
    }
}
