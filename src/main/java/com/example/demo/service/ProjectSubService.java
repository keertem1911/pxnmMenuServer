package com.example.demo.service;

import com.example.demo.dao.ProjectJpaRespository;
import com.example.demo.dao.ProjectSubJpaRespository;
import com.example.demo.entity.Project;
import com.example.demo.entity.ProjectSub;
import lombok.extern.java.Log;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

@Service
@Log
public class ProjectSubService {

    @Autowired
    private ProjectSubJpaRespository projectSubJpaRespository;

    @Autowired
    private ProjectJpaRespository projectJpaRespository;

    public ProjectSub getOne(String orgId){
        return projectSubJpaRespository.getOne(orgId);
    }
    @Transactional
    public void readExcelInsertPersonTarget(List<List<Object>> lists){
        for (List<Object> list : lists) {
         //序号	类别	三级名称	组内序号	作业项目（培训对象）	培训地点	理论	实操	中心实操	培训课时数	需求单位ids	需求单位
           String pname=list.get(2)+"";
           String no=list.get(3)+"";
           String name=list.get(4)+"";
           String address=list.get(5)+"";
           String th=list.get(6)+"";
           String pra=list.get(7)+"";
           String center=list.get(8)+"";
           String course=list.get(9)+"";
           String companyType=list.get(10)+"";
           String companyTypeName=list.get(11)+"";
           String remark=null;
           if(list.size()>12)
           remark=list.get(12)+"";

           Project project = projectJpaRespository.findOneByName(pname);
           String pid=project.getId();
           ProjectSub projectSub=new ProjectSub();
           projectSub.setPxProject(pid);
           projectSub.setOrderIndex(Double.parseDouble(no));
           projectSub.setName(name);
           projectSub.setPxAddress(address);
           if(StringUtils.isNotBlank(th))
                projectSub.setPxThDay(Double.parseDouble(th));
           if(StringUtils.isNotBlank(pra))
                projectSub.setPxPraDay(Double.parseDouble(pra));
           if("是".equals(center.trim()))
               projectSub.setPxCenterPra("2");
           else
               projectSub.setPxCenterPra("1");
           if(StringUtils.isNotBlank(course))
           projectSub.setPxCourse(Double.parseDouble(course));
           if(StringUtils.isNotBlank(companyType)){
               projectSub.setCompanyTypeName(companyTypeName);
               projectSub.setCompanyType(companyType);
           }
           if(StringUtils.isNotBlank(remark))
               projectSub.setRemark(remark);
           projectSub.setCreateUserId("admin");
           log.info(projectSub.toString());
           projectSubJpaRespository.save(projectSub);

        }
    }

    @Transactional
    public void copyFromPxProjectId() {
       String []projectIds= {"05c51407c3db4a4ca898823eaca5bae5",
                "063a2bc5cb2d411489f8aef557ae7932",
                "06c580e4e66f45cdb3928d69e32bb39f",
                "1c54b030b68a4184b27f452d734feaff",
                "1e755870ee0a4ce0afc4178ba71cf2b8",
                "1f34090125324dff89e2098d3fc69aa0",
                "21eae816c5eb4294bc092ada68e08a58",
                "22a477028f7b492bb5b5c31f70b7a6a0",
                "2e3f40111307465e9d88f609f2124bdf",
                "32fc9f2fc02847ca92f9326643f2a6ef",
                "330320fd8b45400c96ca2108852cfe2a",
                "35a8f3e675804bbdb7773728f4b712f6",
                "4209fb91fd7d4a759643db37e3694835",
                "478dd16eb4914564814055a38415f86c",
                "526c5d3dbc154054a201b0a81707e32d",
                "5d86b246c9dc4beb8b4b256216cd4607",
                "5f5ceb996fc54a3da76e4eb908c0b451",
                "6165e61a0a2a49b797d2f3571dc4f177",
                "6710f04aa85f44f992f97a9c996cf1e6",
                "6773792b291a408aaeccfa3b76dc5495",
                "694699dd29624eb0a6ccce8f5f0f3b2f",
                "6a5d7f68899e4d859ed867708d201471",
                "7618baeefef14dc4b66f5f614735d511",
                "7878363169864d3d8a0e59b195ea3911",
                "7acc62a1437240a386bb89895bb7187d",
                "7cd72dc9b4e044649e96665c007b423f",
                "84ec8362c45146589b8e9e3dbcb2807b",
                "87f2e17394474db2b10be6c923807e61",
                "8c666491e43646c2bf2bb31dd7958eab",
                "8d96e9ff96d244298c274b3a7032a80f",
                "8fa88048398a4cc69a81ec89bfa3233a",
                "923466e41fb6410589a3a423eccd398c",
                "949f6ee723854ff9ab73e1bde8a279ac",
                "9567c085e3424410a34aaedd4c560cc8",
                "96cc99f683264a2cb4f2cc9070a4ceaa",
                "975a3e2418164da4852c9c1706018d0f",
                "990cc667315e4d08bb0c1db72e17ae51",
                "a04a95c903084b099938f08204693a30",
                "b181a72f3adc4514b56d789c7b7bf4fa",
                "bae0340bd23445bcaa86df0d84a0a98b",
                "c242a75b176b40a6ae5f3651918ec38d",
                "c5dd6ea6658140d793df32d50773e07c",
                "cef30f09373043e4aedbb0829e7ac919",
                "d3ac09e5040247849690b15a9b2354f2",
                "d4234c431d9e4829a8958bb43962e9da",
                "dbe695cf0fce4d8fb0e6716989705005",
                "dd64f1bc2a6f41b0a0e1c0b01d449ba6",
                "dea3847e361a4aa88348b73eb206e533",
                "e3cf2849dfb34dffbb0e1cf3dde2cca3",
                "e82d98178b9f4e03be1dab314f40403a",
                "e878313767d8435799d7955e6efafe01",
                "edab1d82861b4fdda9f92e33f86b8f5c",
                "f38cc9bfa00c4ab88ca25f2bb75b7876",
                "fe83f9b9283d41e68d21897c9060d3d8"};
       List<String> projectIdList=Arrays.asList(projectIds);
       List<Project> projects = projectJpaRespository.findAllById(projectIdList);
       projects.forEach(d->{
           ProjectSub projectSub=new ProjectSub();
           BeanUtils.copyProperties(d,projectSub);
           projectSub.setId(null);
           projectSub.setName(d.getPxPersonClassifyName());
           projectSub.setPxProject(d.getId());
           projectSub.setPxCourse(d.getClassHourv());
           projectSub.setPxCenterPra("Y".equalsIgnoreCase(d.getIsPxCenter())?"2":"1");
           projectSub.setPxThDay(d.getTrainingDays());
           projectSub.setOrderIndex(1.0);
           projectSub.setPxAddress(d.getTrainingPlace());
           projectSub.setCreateTime(new Date());
           projectSub.setCreateUserId("admin");
           projectSub.setRemark("通过培训项目培训对象创建");
           log.info(projectSub.toString());
           projectSubJpaRespository.save(projectSub);
       });
       log.info("创建完成！！ --------------------------");
    }
}
