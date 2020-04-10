package com.example.demo.dao.sap;

import com.example.demo.entity.sap.PxErpInfomx;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author 王传鑫
 * @date 2020/4/1014:49
 */
@Repository(value = "PxErpInfomxRepository")
public interface PxErpInfomxRepository extends JpaRepository<PxErpInfomx,String> {
    List<PxErpInfomx>  findByPid(String pid);
    
}
