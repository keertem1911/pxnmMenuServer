package com.example.demo.service;

import com.example.demo.dao.OperateJpsRepository;
import com.example.demo.entity.Operate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OperateService {
    @Autowired
    private OperateJpsRepository operateJpsRepository;

    public Operate addOperate(Operate operate){
        return operateJpsRepository.save(operate);
    }
    public boolean checkHasCode(String code){
        Operate operate=operateJpsRepository.findByCode(code);
        return operate!=null;
    }
    public List<Operate> findAllByMenuId(String menuId){
        return operateJpsRepository.findAllByMenuId(menuId);
    }
    public Operate getOne(String id){
        return operateJpsRepository.getOne(id);
    }
    public void delete(Operate operate){
          operateJpsRepository.delete(operate);
    }
}
