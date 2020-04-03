package com.example.demo.dao;

import com.example.demo.entity.Dict;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;


@Repository
public interface DictJpaRespository extends JpaRepository<Dict,String> {
    @Query(value="select t.* from SYS_DICT t where t.classify_id=(select tt.id from SYS_DICT_CLASSIFY tt where tt.code=?2) and t.name=?1",nativeQuery=true)
    List<Dict> getDictByCodeAndName(String name, String code);

    @Query(value="select max(t.order_index) from SYS_DICT t where t.classify_id=(select tt.id from SYS_DICT_CLASSIFY tt where tt.code=?1)",nativeQuery=true)
    BigDecimal getMaxOrderIndex(String code);
}
