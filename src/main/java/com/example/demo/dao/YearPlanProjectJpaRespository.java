package com.example.demo.dao;

import com.example.demo.entity.demand.YearPlanProject;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;


@Repository
public interface YearPlanProjectJpaRespository extends JpaRepository<YearPlanProject,String> {
    @Query(value="select * from px_year_Plan_project where year_Plan_id=? and project_id=? ",nativeQuery=true)
    YearPlanProject findByYearIdAndProjectId(String yearPlanId, String projectId);


//    YearPlanProject findOneByAccount(String account);



//    @Query(value="select id from v_sys_user_info where is_delete='N' and org_name like '%内部退养%' ",nativeQuery=true)
//    List<String> findUserTuiyangList();

}
