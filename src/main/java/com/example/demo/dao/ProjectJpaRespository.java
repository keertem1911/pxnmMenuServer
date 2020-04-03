package com.example.demo.dao;

import com.example.demo.entity.Project;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface ProjectJpaRespository extends JpaRepository<Project,String> {
    @Query(value="select t.* " +
            "from PX_PROJECT t where " +
            "is_delete='N' and name=? and PROJECT_CLASSIFY_ID =?  and px_type='2' ",nativeQuery=true)
    Project findOneByNameAndClassifty(String name, String projectClassifyId);

    @Query(value="select t.* " +
            "from PX_PROJECT t where " +
            "is_delete='N' and name=?  and px_type='2' and is_month='Y' ",nativeQuery=true)
    Project findOneByName(String pname);
}
