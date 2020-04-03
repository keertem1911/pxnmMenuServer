package com.example.demo.entity.demand;

import java.io.Serializable;

import com.example.demo.annotation.ExportConfig;
import lombok.Data;
import lombok.ToString;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Entity
@Table(name = "PX_YEAR_PLAN_PROJECT")
@GenericGenerator(name = "jpa-uuid", strategy = "uuid")
@Data
@ToString
public class YearPlanProject implements Serializable {


	private static final long serialVersionUID = 5825836729495584476L;
	@Id
	@GeneratedValue(generator = "jpa-uuid")
	@Column(length = 32)
	@ExportConfig(value = "用户id")
	private String id;	//逻辑主键
	private String yearPlanId;	//年度计划id
	private String projectId;	//项目id
	private String name;	//培训项目名称
	private String pxPersonClassifyId;	//培训人员分类ID
	private String pxPersonClassifyName;	//培训人员分类ID
	private String pxLevel;	//培训项目级别
	private String projectRequire;	//立项要求
	private Double classHourv;	//培训课时
	private Double trainingDays;	//培训天数
	private String trainingMethods;	//培训方式
	private String trainingPlace;	//培训地点
	private String demandDepartment;	//需求单位
	private String implementDepartment;	//培训实施主责单位
	private String pxType;	//培训类型
	private String remark;	//备注
	private String projectClassifyId;	//项目类型ID
	private java.util.Date createTime;	//创建时间
	private Double addType;	//增加类型
	private String costTeaching;	//授课费
	private String costTraining;	//实训费
	private Double costPaper;	//命题费
	private String costMarking;	//阅卷费
	private Double costInvigilate;	//理论
	private Double costUnderground;	//井下实操
	private Double costGround;	//地面实操
	private String costStay;	//集团外培训住宿费
	private String costCarAllowance;	//车补
	private String costMeal;	//餐补
	private String costMaster;	//师带徒津贴


}