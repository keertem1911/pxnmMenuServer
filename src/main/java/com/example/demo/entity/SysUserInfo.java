package com.example.demo.entity;

import java.io.Serializable;

import com.example.demo.annotation.ExportConfig;
import lombok.Data;
import lombok.ToString;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Entity
@Table(name = "SYS_USER_INFO")
@GenericGenerator(name = "jpa-uuid", strategy = "uuid")
@Data
@ToString
public class SysUserInfo implements Serializable {
	
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(generator = "jpa-uuid")
	@Column(length = 32)
	@ExportConfig(value = "用户id")
	private String id;	//
	private String name;	//
	private String account;	//
	private String idCard;	//
	private String sex;	//
	private String phone;	//
	private String working;	//
	private String enabled;	//
	private String remark;	//
	private String isDelete;	//
	private String jobNumber;	//
	private Double age;	//
	private String createUserId;	//
	private Double userType;	//
	private String photoPic;	//
	private String eduPic;	//
	private String idCardPic;	//
	private String job;	//
	private String birthday;	//
	private String orgName;	//
	private String secondCompanyType;	//
	private String orgId;	//
	private String secondCompanyId;	//
	private String edu;	//
	private String duty;	//
	private String nation;	//
	private String nativeq;	//
	private String companyName;	//
	private String companyId;	//
}