package com.example.demo.dao;

import com.example.demo.entity.Organization;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface OrgJpaRespository extends JpaRepository<Organization,String> {

    List<Organization> findByOrderBySecondCompanyIdDesc();

    List<Organization> findByParentId(String parentId);
}
