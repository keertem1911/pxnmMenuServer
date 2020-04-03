package com.example.demo.service;

import com.example.demo.dao.DictClassifyJpaRespository;
import com.example.demo.entity.DictClassify;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DictClassifyService {
    @Autowired
    private DictClassifyJpaRespository dictClassifyJpaRespository;

    public List<DictClassify> findAll(){
        return  dictClassifyJpaRespository.findAll();
    }
    public DictClassify save(DictClassify dict){
        return dictClassifyJpaRespository.save(dict);
    }
    public DictClassify getOne(String id){
        return dictClassifyJpaRespository.getOne(id);
    }

}
