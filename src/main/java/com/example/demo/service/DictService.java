package com.example.demo.service;

import com.example.demo.dao.DictClassifyJpaRespository;
import com.example.demo.dao.DictJpaRespository;
import com.example.demo.dao.SysUserJpaRespository;
import com.example.demo.entity.Dict;
import com.example.demo.entity.DictClassify;
import com.example.demo.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

@Service
public class DictService {
    @Autowired
    private DictJpaRespository dictJpaRespository;
    @Autowired
    private DictClassifyJpaRespository dictClassifyJpaRespository;

    public List<Dict> findAll(){
        return  dictJpaRespository.findAll();
    }
    public Dict save(Dict dict){
        return dictJpaRespository.save(dict);
    }
    public Dict getOne(String id){
        return dictJpaRespository.getOne(id);
    }
    public Dict getDictOrSave(String name, String code) {
       List<Dict> dicts =dictJpaRespository.getDictByCodeAndName(name, code);
       Dict dict;
        if(dicts==null|| dicts.size()==0)
        {
            DictClassify classifty = dictClassifyJpaRespository.findOneByCode(code);
            BigDecimal orderIndex = dictJpaRespository.getMaxOrderIndex(code);
            Dict obj=new Dict();
            obj.setClassifyId(classifty.getId());
            obj.setIsDelete("N");
            obj.setName(name);
            obj.setOrderIndex(orderIndex.intValue()+1);
            obj.setRemark("批量导入");
            dict=dictJpaRespository.save(obj);
        }else
        dict=dicts.get(0);
        return dict;
    }
}
