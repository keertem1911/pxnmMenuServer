package com.example.demo.entity;

import com.example.demo.annotation.ExportConfig;
import lombok.Data;
import lombok.ToString;
import org.hibernate.annotations.GenericGenerator;
import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "SYS_USER")
@GenericGenerator(name = "jpa-uuid", strategy = "uuid")
@Data
@ToString
public class User implements Serializable {
	/**
	 *
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(generator = "jpa-uuid")
	@Column(length = 32)
	@ExportConfig(value = "用户id")
	private String id;
	private String name;
	private String account;
	private String password;
	private String idCard;
	private String sex;
	private java.util.Date birthday;
	private String phone;
	private String working;
	private String remark;
	private java.sql.Blob photo;
	private String enabled;
	private String edu;
	private String nation;
	private String duty;
	private String nativeq;
	private String isDelete = "N";
	private String jobNumber;
	private String age;
	private String job;
	private String employeeGroup;
	private String employeeSubgroup;
	private Date attendWorkTime;
	private Date accessShTime;
	private Date accessSubsidiarTime;
	private Date accessThieUnitTime;
	private String politicsStatus;
	private Date attendPartyTime;
	private String highestEducation;
	private String jobEducation;
	private String highestMajor;
	private Date createTime;
	private Date updateTime;
	private String createUserId;
	private String initpwd;// 同步初始化密码
	private Integer havefingers;// 有没有录指纹 0为没有 1 为有
	private String isModify="Y";//是否手动修改(Y是N否为了防止erp延迟数据)
	private String ismarry;//婚姻状况 1 未婚 2已婚 3离异
	private Integer userType=0;//0内部 1外围
	private String photoPic;// 头像
	private String idCardPic;// 身份证
	private String eduPic;// 学位证


}