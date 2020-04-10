package com.example.demo.dao.sap;

import com.example.demo.entity.sap.PxErpErrorloginfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author 王传鑫
 * @date 2020/4/1014:49
 */
@Repository(value = "PxErpErrorloginfoRepository")
public interface PxErpErrorloginfoRepository extends JpaRepository<PxErpErrorloginfo,String> {

    List<PxErpErrorloginfo> findByInfomxid(String pid);
}
