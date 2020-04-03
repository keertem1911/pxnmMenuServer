package com.example.demo.service;

import com.example.demo.dao.MenuJpsRespository;
import com.example.demo.entity.Menu;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.xml.ws.Action;
import java.util.List;

@Service
public class MenuService {
    @Autowired
    private MenuJpsRespository menuJpsRespository;

    public Menu addMenu(Menu menu){

        return menuJpsRespository.save(menu);
    }
    public Menu getOne(String menuId){
       return  menuJpsRespository.getOne(menuId);
    }
    public void delete(Menu menu){
        menuJpsRespository.delete(menu);
    }
    public List<Menu> findByOrderByName(){
        return menuJpsRespository.findByOrderByName();
    }
}
