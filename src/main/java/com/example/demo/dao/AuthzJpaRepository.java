package com.example.demo.dao;

import com.example.demo.entity.Authz;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @Description
 * @Author 王传鑫
 * @Date 2019/7/19
 */
@Repository
public interface AuthzJpaRepository extends JpaRepository<Authz,String> {
    Authz findOneById(String id);
}
