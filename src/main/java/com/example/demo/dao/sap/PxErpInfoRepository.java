package com.example.demo.dao.sap;

import com.example.demo.entity.sap.PxErpInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author 王传鑫
 * @date 2020/4/1014:49
 */
@Repository(value = "PxErpInfoRepository")
public interface PxErpInfoRepository extends JpaRepository<PxErpInfo,String> {

    List<PxErpInfo> findByPid(String pid);
    
}
