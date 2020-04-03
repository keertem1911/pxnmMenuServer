package com.example.demo.entity;

import com.example.demo.annotation.ExportConfig;
import lombok.Data;
import lombok.ToString;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "px_project")
@GenericGenerator(name = "jpa-uuid", strategy = "uuid")
@Data
@ToString
public class Project implements Serializable {
	/**
	 *
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(generator = "jpa-uuid")
	@Column(length = 32)
	@ExportConfig(value = "组织机构编号")
	private String id;
	private String projectClassifyId;
	private String cultivateType;
	private String name;
	private String remark;
	private String isDelete = "N";
	private String pxPersonClassifyId;
	private String pxPersonClassifyName;

	private String createUserId;
	private String createUserName;
	private java.util.Date createTime=new Date();
	private java.util.Date updateTime=new Date();
	
	private String pxLevel; //培训项目级别
	private String projectRequire;	//立项要求
	private Double classHourv;	//培训课时
	private Double trainingDays;	//培训天数
	private String trainingMethods;	//培训方式
	private String trainingPlace;	//培训地点
	private String demandDepartment;	//需求单位
	private String implementDepartment;	//培训实施主责单位
	private String pxType;	//培训类型
	private String companyId;//二级单位
	private String companyType;
	private String companyTypeName;
	private String isPxCenter;
	private String projectType="1";// 1 普通项目2专项项目
	private String teachingObject;//授课对象1管理人员2操作人员
	private String projectSource;//项目添加来源见PxProjectSourceEnum，1手动添加，2申请添加
	private String approveId;// 申请项目main
	private String approveProjectId;// 申请项目
	private String isMonth;
	private String projectCode;
	private Double orderIndex;
}