package com.example.demo;

import com.example.demo.service.MonthPlanCenterService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;


/**
 * @author 王传鑫
 * @date 2020/2/1315:30
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class PxMonthPlanCenterTestd {


    @Autowired
    private MonthPlanCenterService monthPlanCenterService;

    @Test
    public void test(){
        monthPlanCenterService.handlerLastMonth("2020","2","3");
    }
}
