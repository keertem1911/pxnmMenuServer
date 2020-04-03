package com.example.demo.controller;

import com.example.demo.dao.*;
import com.example.demo.domain.ResponseBo;
import com.example.demo.dto.MenuJson;
import com.example.demo.entity.*;
import com.example.demo.responseDto.ResponseData;
import com.example.demo.service.AuthzService;
import com.example.demo.service.MenuService;
import com.example.demo.service.OperateService;
import com.example.demo.util.FileUtil;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.lang.reflect.Type;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @Description
 * @Author 王传鑫
 * @Date 2019/7/19
 */
@RestController
@RequestMapping("/menu")
@Slf4j
public class MenuController {
    @Autowired
    private AuthzService authzService;
    @Autowired
    private MenuService menuService;
    @Autowired
    private OperateService operateService;

    private Gson gson=new Gson();
    private String getParamJson(HttpServletRequest request) {
        StringBuffer stringBuffer = new StringBuffer();
        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(request.getInputStream(), "UTF-8"));
            String line=null;
            while ((line=reader.readLine())!=null){
                stringBuffer.append(line);
            }
        }catch (Exception e){

        }

        return stringBuffer.toString();
    }
    @GetMapping("/hello")
    public String hello(){
        return  new Date()+" at now ";
    }
    @PostMapping("/addlist")
    public ResponseData addList(HttpServletRequest request){
        Type type=new TypeToken<List<MenuJson>>(){}.getType();
        List<MenuJson> list=gson.fromJson(getParamJson(request),type);
        List<Menu> menus=new ArrayList<>(list.size());
        for (int i = 0; i < list.size(); i++) {
            menus.add(adds(list.get(i)));
        }
        return ResponseData.success(menus);
    }
    @PostMapping("/adds")
    public ResponseData adds(HttpServletRequest request){
       MenuJson menuJson=gson.fromJson(getParamJson(request), MenuJson.class);
        /**
         *      private String name; => text
         *      private String parentId; => pid
         *      private String enabled;
         *      private double orderIndex;
         *      private String icon;
         *      private String resourcePath;
         *      private String remark;
         *      private String type; => "MODULE"
         *      private String allowAuthz;=> "Y"
         */

       return ResponseData.success(adds(menuJson));
    }
    private Menu adds(MenuJson menuJson){
//        Menu menuOld=menuJpsRespository.findOneByName(menuJson.getText());
//        if(menuOld!=null){
//            menuOld.setRemark("菜单已存在");
//            return menuOld;
//        }
        Menu menu=new Menu();
        menuJson.setIcon(null);
        BeanUtils.copyProperties(menuJson,menu);
        menu.setName(menuJson.getText());
        menu.setOrderIndex(menuJson.getOrderIndex());
        menu.setId(null);
        menu.setParentId(menuJson.getPid());
        menu.setType("MODULE");
        menu.setAllowAuthz("Y");
        menu=menuService.addMenu(menu);
        Authz authz=authzService.addAuthz("MENU");
        addAuthz2Menu(authz.getId(),menu.getId());
        // 菜单保存完成
        // 子操作功能保存
        List<MenuJson.ChildrenBean> childrenBean = menuJson.getChildren();

        final String typeOperate="OPERATE";
            double index=0.0;
        if(childrenBean!=null&&childrenBean.size()>0)
            for (MenuJson.ChildrenBean bean: childrenBean)
                if(!operateService.checkHasCode(bean.getCode())) {
                    Operate operate = new Operate();

                    BeanUtils.copyProperties(bean, operate);
                    operate.setId(null);
                    operate.setMenuId(menu.getId());
                    operate.setOrderIndex(++index);
                    operate.setName(bean.getText());
                    operate=operateService.addOperate(operate);
                    Authz authz1=authzService.addAuthz(typeOperate);
                    addAuthz2Operate(authz1.getId(),operate.getId());
                }
         return menu;
    }


    @Autowired
    private JdbcTemplate jdbcTemplate;
    private void addAuthz2Menu(String authzId,String menuId){
        String insertSql="insert into SYS_AUTHZ_MENU(authz_id,menu_id) values('"+authzId+"','"+menuId+"')";
        jdbcTemplate.execute(insertSql);
    }
    private void addAuthz2Operate(String authzId,String operateId){
        String insertSql="insert into SYS_AUTHZ_OPERATE(authz_id,operate_id) values('"+authzId+"','"+operateId+"')";
        jdbcTemplate.execute(insertSql);
    }


    @DeleteMapping("/item/{id}")
    public ResponseData deleteItem(@PathVariable("id")String menuId){
        Menu menu=menuService.getOne(menuId);
        if(menu==null)
            return ResponseData.error("菜单ID不存在");
        List<Operate> operates = operateService.findAllByMenuId(menuId);
        if(operates!=null&&operates.size()>0)
            for(Operate o:operates){
                    deleteByOperate(o.getId());
            }
        deleteByMenu(menuId);
        return ResponseData.success(menuId);
    }
    @DeleteMapping("/items")
    public @ResponseBody ResponseData deletes(HttpServletRequest request){
        Type type=new TypeToken<List<String>>(){}.getType();
        List<String> deleteIds=gson.fromJson(getParamJson(request),type);
        deleteIds.stream().forEach(d->deleteItem(d));
        return ResponseData.success();
    }
    private int deleteByOperate(String operateId){
        String sql="select authz_id from sys_authz_operate where operate_id= '"+operateId+"'";
        List<String> authzList = jdbcTemplate.query(sql, new RowMapper<String>() {
            @Override
            public String mapRow(ResultSet resultSet, int i) throws SQLException {
                String authzId = resultSet.getString("authz_id");
                return authzId;
            }
        });
        String deleteSql="delete from sys_authz_operate where operate_id='"+operateId+"' ";
        if(authzList!=null&&authzList.size()>0){
            for(String authzId : authzList){
                Authz authz = authzService.findOneById(authzId);
                authzService.delete(authz);
            }
        }
        jdbcTemplate.execute(deleteSql);
        Operate operate = operateService.getOne(operateId);
        operateService.delete(operate);
        return 1;
    }
    private int deleteByMenu(String menuId){
        String sql="select authz_id from sys_authz_menu where menu_id= '"+menuId+"'";
        List<String> authzList = jdbcTemplate.query(sql, new RowMapper<String>() {
            @Override
            public String mapRow(ResultSet resultSet, int i) throws SQLException {
                String authzId = resultSet.getString("authz_id");
                return authzId;
            }
        });
        String deleteSql="delete from sys_authz_menu where menu_id='"+menuId+"' ";
        if(authzList!=null&&authzList.size()>0){
            for(String authzId : authzList){
                Authz authz = authzService.findOneById(authzId);
                authzService.delete(authz);
            }
        }
        jdbcTemplate.execute(deleteSql);
        Menu menu = menuService.getOne(menuId);
        menuService.delete(menu);
        return 1;
    }

    @GetMapping("/excel")
    public ResponseBo logExcel(HttpServletResponse response) {
        try {
            List<Menu> list = menuService.findByOrderByName();
            return FileUtil.createExcelByPOIKit
                    ("系统菜单表", list, Menu.class,response);
        } catch (Exception e) {
            log.error("导出菜单Excel失败", e);
            return ResponseBo.error("导出Excel失败，请联系网站管理员！");
        }
    }
}
