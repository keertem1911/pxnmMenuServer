package com.example.demo.service;

import com.example.demo.dao.ProjectJpaRespository;
import com.example.demo.entity.Project;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProjectService {

    @Autowired
    private ProjectJpaRespository projectJpaRespository;

    public List<Project> findAll(){
        return  projectJpaRespository.findAll();
    }
    public Project save(Project Project){
        return projectJpaRespository.save(Project);
    }
    public Project getOne(String orgId){
        return projectJpaRespository.getOne(orgId);
    }

}
