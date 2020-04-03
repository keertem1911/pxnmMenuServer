package com.example.demo.entity.monthcenter;

import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
@Entity
@Table(name = "PX_MONTH_PLAN_CENTER_PROJECT")
@GenericGenerator(name = "jpa-uuid", strategy = "uuid")
@Data

public class PxMonthPlanCenterProject implements Serializable {


	private static final long serialVersionUID = -3162339221070560206L;
	@Id
	@GeneratedValue(generator = "jpa-uuid")
	@Column(length = 32)
	private String id;	//
	private String pxProject;	//培训项目id
	private String pxProjectName;	//培训项目名称
	private String pxPeojectTarget;	//作业项目(培训对象)名称
	private String pxAddress;	//培训地点
	private java.util.Date beginTime;	//培训开始时间
	private java.util.Date endTime;	//培训培训结束时间
	private String pxTime;	//培训时间(begin_time+end_time)
	private Double pxDay=0.0;	//培训天数
	private Double pxCourse=0.0;	//培训课时
	private Double pxThDay=0.0;	//理论天数
	private Double pxPraDay=0.0;	//实操天数
	private String pxCenterPra="N";	//中心实操是否
	private String companyTypeName;	//需求单位名称
	private String projectType="1";	//项目类型(一般还是专项)默认1普通项目
	private java.util.Date createTime=new Date();	//创建时间
	private String createUserId;	//创建人
	private String isDelete="N";	//是否删除
	private String remark;	//备注
	private String planType="1";	//计划项目
	private String pxMonthPlanCenter;	//月度安排
	private Double pxBudget=0.0;	//培训费
	private Double roomBudget=0.0;	//住宿费
	private Double lifeBudget=0.0;	//生活补助
	private Double transportBudget=0.0;	//交通补助
//	private Double other_budget=0.0;// 其他费用
	private Integer pxNum=0;// 项目人数
	private String companyId;// 专项项目指定机关单位
	private String isUploadAttchmentfile="N";
	private String isOpen="Y";// 机关部室是否开班
	private String lastMonthClass;//顺延班级标识
	private String isOuter="N";//内外部市场班

	private String pxProjectSub;// 四级项目

	private String departmentId;// 主责单位
	private String departmentUserId;// 主责负责人

	private Integer yearPlanNum;
	private String planAbroad="N";//是否增补计划
}