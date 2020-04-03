package com.example.demo.dao;

import com.example.demo.entity.Operate;
import com.example.demo.entity.ProjectClassify;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface ProjectClassifyJpaRespository extends JpaRepository<ProjectClassify,String> {
    @Query(value="select * " +
            "from PX_PROJECT_CLASSIFY where " +
            "is_delete='N' and name=? and parent is null ",nativeQuery=true)
    ProjectClassify findOneByName(String name);
    @Query(value="select * " +
            "from PX_PROJECT_CLASSIFY where " +
            "is_delete='N' and name=? and parent =?  ",nativeQuery=true)
    ProjectClassify findByNameAndParent(String name,String parent);

    @Query(value="select t.* " +
            "from PX_PROJECT_CLASSIFY t " +
            "left join PX_PROJECT_CLASSIFY p on p.id=t.parent " +
            "where " +
            "t.is_delete='N' and t.is_month=? order by p.order_index,t.order_index  ",nativeQuery=true)
    List<ProjectClassify> findAllByIsMonth(String isMonth);
}
