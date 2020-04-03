package com.example.demo.dao;

import com.example.demo.entity.EmpTongxunxinxi;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import java.util.List;


@Repository
public interface EmpTongxunxinxiJpaRespository extends JpaRepository<EmpTongxunxinxi,String> {
    @Query(value="select flag from CESMS_EMP_TONGXUNXINXI tx where  tx.personid=? and tx.tx_type='移动电话' order by is_modify desc,update_time desc",nativeQuery=true)
    List<String> findFlagByUserId(String userid);
}
