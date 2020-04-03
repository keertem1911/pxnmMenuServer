package com.example.demo.dao;

import com.example.demo.entity.Operate;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;
/**
 * @Description
 * @Author 王传鑫
 * @Date 2019/7/19
 */
@Repository
public interface OperateJpsRepository extends JpaRepository<Operate,String> {


    List<Operate> findAllByMenuId(String menuId);
    Operate findByCode(String code);
}
