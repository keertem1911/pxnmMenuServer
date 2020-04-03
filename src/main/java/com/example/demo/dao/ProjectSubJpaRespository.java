package com.example.demo.dao;

import com.example.demo.entity.ProjectSub;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface ProjectSubJpaRespository extends JpaRepository<ProjectSub,String> {

}
