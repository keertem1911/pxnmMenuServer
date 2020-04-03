package com.example.demo.entity;

import java.io.Serializable;
import java.util.Date;

import com.example.demo.annotation.ExportConfig;
import lombok.Data;
import lombok.ToString;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Entity
@Table(name = "PX_PROJECT_SUB")
@GenericGenerator(name = "jpa-uuid", strategy = "uuid")
@Data
@ToString
public class ProjectSub implements Serializable {
	
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(generator = "jpa-uuid")
	@Column(length = 32)
	@ExportConfig(value = "用户id")
	private String id;	//
	private String pxProject;	//三级项目
	private String name;	//名称
	private Double pxThDay=0.0;	//理论天数
	private Double pxPraDay=0.0;	//实操天数
	private Double pxCourse=0.0;	//培训课时数
	private String createUserId;	//创建人
	private Date createTime=new Date();	//创建时间
	private Double orderIndex=0.0;	//排序
	private String companyType;	//需求单位
	private String companyTypeName;	//需求单位
	private String pxCenterPra;	//是否中心实操
	private String pxAddress;	//培训地点
	private String remark;	//备注

}