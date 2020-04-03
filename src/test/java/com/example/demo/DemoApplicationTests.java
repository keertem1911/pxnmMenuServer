package com.example.demo;

import com.example.demo.dao.AuthzJpaRepository;
import com.example.demo.dao.MenuJpsRespository;
import com.example.demo.dao.OrgJpaRespository;
import com.example.demo.dto.EnumPushUserType;
import com.example.demo.dto.GetToken;
import com.example.demo.dto.PushLight;
import com.example.demo.dto.ResultData;
import com.example.demo.entity.Authz;
import com.example.demo.entity.Menu;
import com.example.demo.entity.Organization;
import com.example.demo.entity.ProjectClassify;
import com.example.demo.service.ProjectClassifyService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.*;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DemoApplicationTests {

    @Autowired
    private OrgJpaRespository orgJpaRespository;
    @Test
    public void contextLoads() {
        List<Organization> list=orgJpaRespository.findByOrderBySecondCompanyIdDesc();
        System.out.println(list.size());

    }
    @Autowired
    private AuthzJpaRepository authzJpaRepository;

    @Test
    public void test(){
        Authz z=authzJpaRepository.findOneById("003d4bf3784d46b7b869f314ae39eced");
        System.out.println(z.getId());
    }

    @Autowired
    private RestTemplate restTemplate;
    private String baseInnerUrl="http://192.168.206.11:33300";
    private String baseOuterUrl="http://mtyyxs.shnxmyjt.com:33300";
    private String appid="1000008";
    private String usernameLogin="nmjypxxt";
    private String passwordLogin="xxzx123@";
    @Test
    public void pushMain(){
        HttpHeaders headers = new HttpHeaders();//header参数
//        headers.add("token","");
        headers.add("caller",appid);
        headers.setContentType(MediaType.APPLICATION_JSON);

        GetToken token=new GetToken();
        token.setPassword(passwordLogin);
        token.setUserID(usernameLogin);
//        JSONObject obj = new JSONObject();//放入body中的json参数
//        obj.put("userId", id);
//        obj.put("name", name);

        HttpEntity<GetToken> request = new HttpEntity<>(token,headers); //组装

        String url=baseInnerUrl+"/api/OAuth/Login";
        ResponseEntity<ResultData> response =
                restTemplate.exchange(url, HttpMethod.POST,request,ResultData.class);
        System.out.println(response.getBody().getData());

    }
    @Test
    public  void enums() {
        int i=EnumPushUserType.ALL.ordinal();
        System.out.println(i);
    }
    @Autowired
    private MenuJpsRespository menuJpsRespository;
    @Test
    public void menuName(){
        Menu menu=menuJpsRespository.findOneByName("菜单管理");
        System.out.println(menu);
    }
    @Autowired
    private ProjectClassifyService projectClassifyService;
    @Test
    public void testProjectClassify(){
        projectClassifyService.readExeclIntoProject(null);
    }


}
