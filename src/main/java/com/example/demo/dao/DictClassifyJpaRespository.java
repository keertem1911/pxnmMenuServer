package com.example.demo.dao;

import com.example.demo.entity.DictClassify;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface DictClassifyJpaRespository extends JpaRepository<DictClassify,String> {

    DictClassify findOneByCode(String code);
}
