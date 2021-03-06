package com.example.demo.dao;

import com.example.demo.entity.monthcenter.MonthPlanCenterSchedule;
import com.example.demo.entity.monthcenter.PxMonthPlanCenter;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @Description
 * @Author 王传鑫
 * @Date 2019/7/19
 */
@Repository
public interface MonthPlanCenterScheduleRepository extends JpaRepository<MonthPlanCenterSchedule,String> {

    @Query(value="select t.* from PX_MONTH_PLAN_CENTER_schedule t " +
            " where  PX_MONTH_PLAN_CENTER_PROJECT=? ",nativeQuery=true)
    List<MonthPlanCenterSchedule> getPxYearAndPxMonth(String pid);
}
