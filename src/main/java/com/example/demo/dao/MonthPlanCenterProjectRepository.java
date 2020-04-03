package com.example.demo.dao;

import com.example.demo.entity.monthcenter.PxMonthPlanCenterProject;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @Description
 * @Author 王传鑫
 * @Date 2019/7/19
 */
@Repository
public interface MonthPlanCenterProjectRepository extends JpaRepository<PxMonthPlanCenterProject,String> {
    @Query(value = "select t.id from px_month_plan_center_project t " +
            "where px_time is not null and px_num is not null " +
            "and px_num>0 and  px_month_plan_center=? ",nativeQuery = true)
    List<String> getMonthPlanCenter( String pid);

}
