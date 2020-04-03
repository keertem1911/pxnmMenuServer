package com.example.demo.dao;

import com.example.demo.entity.Menu;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @Description
 * @Author 王传鑫
 * @Date 2019/7/19
 */
@Repository
public interface MenuJpsRespository extends JpaRepository<Menu,String> {
        Menu findOneByName(String name);
        List<Menu> findByOrderByName();
}
