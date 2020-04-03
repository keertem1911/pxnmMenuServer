package com.example.demo;

import com.example.demo.service.ProjectSubService;
import com.example.demo.service.YearDemandService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class YearDemandTests {

    @Autowired
    private YearDemandService yearDemandService;
    @Autowired
    private ProjectSubService projectSubService;
    @Test
    public void menuName(){
        yearDemandService.handlerDemand();
    }
    @Test
    public void menuNameA(){
        yearDemandService.handerSpescal();
    }

    @Test
    public void menuNameB(){
        yearDemandService.saveObj();
    }
    @Test
    public void menuNameC(){
        yearDemandService.readToYearDemand();
    }
     @Test
    public void copy(){
        projectSubService.copyFromPxProjectId();
    }


}
