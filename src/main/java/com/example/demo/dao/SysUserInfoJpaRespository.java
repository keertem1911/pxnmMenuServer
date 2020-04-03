package com.example.demo.dao;

import com.example.demo.entity.SysUserInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface SysUserInfoJpaRespository extends JpaRepository<SysUserInfo,String> {


    SysUserInfo findOneByAccount(String account);

    @Query(value="select id from sys_user_info where is_delete='N' and enabled='Y' and name<>'机构管理员' AND ID<>'admin' and user_type=0",nativeQuery=true)
    List<String> findUserAll();

    /**
     * 离岗休养
     * 国家能源集团宁夏煤业有限责任公司乌兰煤矿
     * 乌兰煤矿非领导岗位人员
     * @return
     */
    @Query(value="select id from sys_user_info where is_delete='N'   " +
            "             and (org_name like '%内部退养%' or org_name like '%非领导%') " +
            "             and duty='离退休.退休(线外)' ",nativeQuery=true)
    List<String> findUserTuiyangList();

    SysUserInfo findOneById(String id);

    @Query(value = "select id from sys_user_info where second_company_id is null and is_delete='N' ",nativeQuery=true)
    List<String> findNoSecondCompanyId();

}
