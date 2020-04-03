package com.example.demo.service;

import com.example.demo.dao.AuthzJpaRepository;
import com.example.demo.entity.Authz;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AuthzService {
    @Autowired
    private AuthzJpaRepository authzJpaRepository;

    public Authz addAuthz(String type){
        Authz authz=new Authz(type);
        return  authzJpaRepository.save(authz);
    }
    public Authz findOneById(String id){
        return authzJpaRepository.findOneById(id);
    }
    public void delete(Authz authz){
         authzJpaRepository.delete(authz);
    }
}
