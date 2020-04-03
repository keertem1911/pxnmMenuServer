package com.example.demo.entity.demand;

import java.io.Serializable;

import com.example.demo.annotation.ExportConfig;
import lombok.Data;
import lombok.ToString;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Entity
@Table(name = "PX_YEAR_DEMAND_STATISTICS")
@GenericGenerator(name = "jpa-uuid", strategy = "uuid")
@Data
@ToString
public class YearDemandStatistics implements Serializable {


	private static final long serialVersionUID = 1466656059116747762L;
	@Id
	@GeneratedValue(generator = "jpa-uuid")
	@Column(length = 32)
	@ExportConfig(value = "用户id")
	private String id;	//逻辑主键
	private String projectId;	//项目id
	private String yearDemandId;	//年度需求id
	private Double month1=0.0;	//一月
	private Double month2=0.0;	//
	private Double month3=0.0;	//
	private Double month4=0.0;	//
	private Double month5=0.0;	//
	private Double month6=0.0;	//
	private Double month7=0.0;	//
	private Double month8=0.0;	//
	private Double month9=0.0;	//
	private Double month10=0.0;	//
	private Double month11=0.0;	//
	private Double month12=0.0;	//十二月
	private String createUserId;	//创建人id
	private String createUserName;	//创建人name
	private java.util.Date createTime;	//创建时间
	private java.util.Date updateTime;	//修改时间
	private String companyId;	//公司id
	private String companyName;	//公司name
	private Double flowState;	//流程状态
	private Double flowNode;	//流程节点
	private String flowId;	//流程id
	private String pxYearPlanProject;	//年度需求项目id
	private String sumType;	//汇总类型1区队2二级单位3人力资源
	private String pxType;	//培训类型内培或外陪
	private String departmentId;	//部门id
	private String departmentName;	//部门名称
	private String statisticsState;	//统计状态
	private Double npTeaching=0.0;	//授课费
	private Double npStay=0.0;	//住宿费
	private Double npLife=0.0;	//生活补助费
	private Double npTraffic=0.0;	//交通费
	private Double wpTeachingPrimary=0.0;	//初级/高级工（授课费）
	private Double wpTeachingMiddle=0.0;	//中级/技师  （授课费）
	private Double wpTeachingSenior=0.0;	//高级/高级技师（授课费）
	private Double wpTrainingPrimary=0.0;	//初级/高级工（实训费  ）
	private Double wpTrainingMiddle=0.0;	//中级/技师  （实训费）
	private Double wpTrainingSenior=0.0;	//高级/高级技师（实训费）
	private Double wpPaper=0.0;	//试卷（命题费）
	private Double wpQuestion=0.0;	//题库（命题费）
	private Double wpInvigilate=0.0;	//理论（监考费）
	private Double wpUnderground=0.0;	//井下实操（监考费）
	private Double wpGround=0.0;	//地面实操（监考费）
	private Double wpProvincial=0.0;	//省会城市  （集团外培训住宿费）
	private Double wpProvincialOther=0.0;	//其他城市  （集团外培训住宿费）
	private Double wpCarAllowance=0.0;	//车补
	private Double wpMeal=0.0;	//生活补助（餐补）
	private Double wpMaster=0.0;	//师带徒津贴
	private Double wpOther=0.0;	//其他（印刷材料、教案、教具）
	private Double costBudget=0.0;	//费用预算
	private String secondCompanyId;	//二级单位id
	private String secondCompanyName;	//二级单位名称
	private String sumOrg;	//汇总组织
	private Double npOther=0.0;	//其他费用
	private Double wpMarking=0.0;	//阅卷费

}