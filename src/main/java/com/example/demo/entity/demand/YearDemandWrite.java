package com.example.demo.entity.demand;

import java.io.Serializable;

import com.example.demo.annotation.ExportConfig;
import lombok.Data;
import lombok.ToString;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Entity
@Table(name = "PX_YEAR_DEMAND_WRITE")
@GenericGenerator(name = "jpa-uuid", strategy = "uuid")
@Data
@ToString
public class YearDemandWrite implements Serializable {


	private static final long serialVersionUID = 3978015684291503933L;
	@Id
	@GeneratedValue(generator = "jpa-uuid")
	@Column(length = 32)
	@ExportConfig(value = "用户id")
	private String id;	//逻辑主键
	private String projectId;	//项目id
	private String yearDemandId;	//年度需求id
	private Double month1;	//一月
	private Double month2;	//
	private Double month3;	//
	private Double month4;	//
	private Double month5;	//
	private Double month6;	//
	private Double month7;	//
	private Double month8;	//
	private Double month9;	//
	private Double month10;	//
	private Double month11;	//
	private Double month12;	//十二月
	private String createUserId;	//创建人id
	private String createUserName;	//创建人name
	private java.util.Date createTime;	//创建时间
	private java.util.Date updateTime;	//修改时间
	private String pxYearPlanProject;	//培训需求id

}