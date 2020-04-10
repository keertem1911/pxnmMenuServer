package com.example.demo.dao.sap;

import com.example.demo.entity.sap.PxErp;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author 王传鑫
 * @date 2020/4/1014:49
 */
@Repository(value = "PxErpRepository")
public interface PxErpRepository extends JpaRepository<PxErp,String> {

    List<PxErp> findAllByOrderByExtimeDesc();
}
