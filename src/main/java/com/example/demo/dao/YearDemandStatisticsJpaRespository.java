package com.example.demo.dao;

import com.example.demo.entity.demand.YearDemandStatistics;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface YearDemandStatisticsJpaRespository extends JpaRepository<YearDemandStatistics,String> {

    @Query(value="select t.* from PX_YEAR_DEMAND_STATISTICS t " +
            " left join sys_organization o on o.id=t.second_company_id" +
            " where t.sum_type<>'4' and o.company_type=:companyType and t.project_id in (:spIds) ",nativeQuery=true)
    List<YearDemandStatistics> findAllByProjectIdAndType(@Param("companyType") int companyType,@Param("spIds")List<String> projectIds);
    @Query(value="select t.* from PX_YEAR_DEMAND_STATISTICS t " +
            " left join sys_organization o on o.id=t.sum_org" +
            " where t.sum_type='4' and o.company_type=:companyType and t.project_id in (:spIds) ",nativeQuery=true)
    List<YearDemandStatistics> findAllByProjectIdAndTypeSum(@Param("companyType") int companyType,@Param("spIds")List<String> projectIds);
    @Query(value="select t.* from PX_YEAR_DEMAND_STATISTICS t " +
            " left join sys_organization o on o.id=t.sum_org " +
            " where t.sum_type='4' and o.company_type<>:companyType and t.project_id in (:spIds) ",nativeQuery=true)
    List<YearDemandStatistics> findAllByProjectIdAndNotTypeSum(@Param("companyType") int companyType,@Param("spIds")List<String>  projectIds);
    @Query(value="select t.* from PX_YEAR_DEMAND_STATISTICS t " +
            " left join sys_organization o on o.id=t.second_company_id" +
            " where t.sum_type<>'4' and o.company_type<>:companyType and t.project_id in (:spIds) ",nativeQuery=true)
    List<YearDemandStatistics> findAllByProjectIdAndNotType(@Param("companyType") int companyType,@Param("spIds")List<String>  projectIds);
    @Query(value="select t.* from PX_YEAR_DEMAND_STATISTICS t " +
            " where  t.id in (:ids) ",nativeQuery=true)
    List<YearDemandStatistics> findByIds(@Param("ids")List<String> idsS);


//    YearDemandStatistics findOneByAccount(String account);



//    @Query(value="select id from v_sys_user_info where is_delete='N' and org_name like '%内部退养%' ",nativeQuery=true)
//    List<String> findUserTuiyangList();

}
