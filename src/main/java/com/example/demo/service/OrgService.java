package com.example.demo.service;

import com.example.demo.dao.OrgJpaRespository;
import com.example.demo.entity.Organization;
import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

@Service
@Log
public class OrgService {

    @Autowired
    private OrgJpaRespository orgJpaRespository;

    public List<Organization> findAll(){
        return  orgJpaRespository.findAll();
    }
    public Organization save(Organization organization){
        return orgJpaRespository.save(organization);
    }
    public Organization getOne(String orgId){
        return orgJpaRespository.getOne(orgId);
    }
    public List<Organization> findByOrderBySecondCompanyIdDesc(){
        return orgJpaRespository.findByOrderBySecondCompanyIdDesc();
    }

    public String changeNameToFullName() {
        List<Organization> list
                = orgJpaRespository.findByParentId("20027001");
        AtomicInteger integer=new AtomicInteger(0);
        list.forEach(d->{
            String name= d.getName();
            d.setNameFull(name);
            name=name.replace("国家能源集团宁夏煤业有限责任公司","");
            name=name.replace("国家能源集团宁夏煤业","");
            name=name.replace("宁夏宁鲁煤电有限责任公司","");
            d.setName(name);
            orgJpaRespository.save(d);
            log.info("更新内容 简称="+d.getName()+", 全称="+d.getNameFull());
            log.info("已更新 "+integer+" 总共"+list.size());
            integer.getAndAdd(1);
        });
        return "succes";
    }
}
