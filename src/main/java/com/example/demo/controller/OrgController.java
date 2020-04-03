package com.example.demo.controller;

import com.example.demo.domain.ResponseBo;
import com.example.demo.entity.Organization;
import com.example.demo.service.OrgService;
import com.example.demo.util.FileUtil;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/org")
@Slf4j
public class OrgController {

    @Autowired
    private OrgService orgService;

    public static final String ORG_ROOT="20027001";
    @GetMapping("/getAll")
    public String orgChange(){
        List<Organization> list=orgService.findAll();
        for (int i = 0; i < list.size(); i++) {
           Organization organization= list.get(i);
           if(organization.getId().equals(ORG_ROOT))
               continue;
           if(organization.getParentId().equals(ORG_ROOT)){
                    organization.setSecondCompanyId(ORG_ROOT);
            }else {
                String secondCompanyId = getProid(organization.getParentId());
                organization.setSecondCompanyId(secondCompanyId);
                System.out.println("update "+organization.getName()+" p"+secondCompanyId);
            }
            orgService.save(organization);

        }
        return "success";
    }
    private   String getProid(String proid)
    {
        Organization parent=orgService.getOne(proid);
        String newproid=parent.getParentId();
        if(!newproid.equals(ORG_ROOT)){
            proid=getProid(newproid);
        }
        return proid;
    }

    @GetMapping("/excel")
    public ResponseBo logExcel(@RequestParam(value = "parentId",required = false)String parentId, HttpServletResponse response) {
        try {
            List<Organization> list = orgService.findByOrderBySecondCompanyIdDesc();
            Map<String, List<Organization>> groupById = list.stream().collect(Collectors.groupingBy(Organization::getId));
            list.stream().forEach(d->{
                if(StringUtils.isNotBlank(d.getParentId())) {
                    d.setParentName(groupById.get(d.getParentId()).get(0).getName());
                    d.setSecondCompanyName(groupById.get(d.getSecondCompanyId()).get(0).getName());
                }
            });
            return FileUtil.createExcelByPOIKit
                    ("系统组织结构", list, Organization.class,response);
        } catch (Exception e) {
            log.error("导出菜单Excel失败", e);
            return ResponseBo.error("导出Excel失败，请联系网站管理员！");
        }
    }

    @GetMapping("/changeNameToFullName")
    public ResponseBo changeNameToFullName(){
        String msg= orgService.changeNameToFullName();
        return ResponseBo.ok(msg);
    }
}
