package com.example.demo.controller;

import com.example.demo.dao.MenuJpsRespository;
import com.example.demo.dao.OperateJpsRepository;
import com.example.demo.dto.OperateJson;
import com.example.demo.entity.Authz;
import com.example.demo.entity.Operate;
import com.example.demo.responseDto.ResponseData;
import com.example.demo.service.AuthzService;
import com.example.demo.service.MenuService;
import com.example.demo.service.OperateService;
import com.google.gson.Gson;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/operate")
public class OperateController {
    @Autowired
    private OperateService operateService;
    @Autowired
    private MenuService menuService;
    @Autowired
    private AuthzService authzService;

    private Gson gson;
    @PostMapping("/add")
    public ResponseData add(@RequestBody OperateJson operateJson){
        System.out.println(operateJson.getOrderIndex());
        Operate operate=addOne(operateJson);
        return ResponseData.success(operate);
    }
    private Operate addOne(OperateJson bean){
        if(!operateService.checkHasCode(bean.getCode())&&null!=menuService.getOne(bean.getPid())) {
            Operate operate = new Operate();

            BeanUtils.copyProperties(bean, operate);
            operate.setId(null);
            operate.setMenuId(bean.getPid());
            operate.setName(bean.getText());
            operate=operateService.addOperate(operate);
            Authz authz1=authzService.addAuthz("OPERATE");
            addAuthz2Operate(authz1.getId(),operate.getId());
            return operate;
        }
        return null;
    }
    @Autowired
    private JdbcTemplate jdbcTemplate;
    private void addAuthz2Operate(String authzId,String operateId){
        String insertSql="insert into SYS_AUTHZ_OPERATE(authz_id,operate_id) values('"+authzId+"','"+operateId+"')";
        jdbcTemplate.execute(insertSql);
    }

    @PostMapping("/adds")
    public ResponseData adds(@RequestBody List<OperateJson> operateJsons){
        System.out.println(operateJsons.size());
        List<Operate> list=new ArrayList<>(operateJsons.size());
        operateJsons.stream().forEach(d->list.add(addOne(d)));
        return ResponseData.success(list);
    }

}
