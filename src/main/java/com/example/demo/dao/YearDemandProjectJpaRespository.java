package com.example.demo.dao;

import com.example.demo.entity.demand.YearDemandProject;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface YearDemandProjectJpaRespository extends JpaRepository<YearDemandProject,String> {


//    YearDemandProject findOneByAccount(String account);



//    @Query(value="select id from v_sys_user_info where is_delete='N' and org_name like '%内部退养%' ",nativeQuery=true)
//    List<String> findUserTuiyangList();

}
