package com.example.demo.entity.demand;

import java.io.Serializable;

import com.example.demo.annotation.ExportConfig;
import lombok.Data;
import lombok.ToString;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Entity
@Table(name = "PX_YEAR_DEMAND_PROJECT")
@GenericGenerator(name = "jpa-uuid", strategy = "uuid")
@Data
@ToString
public class YearDemandProject implements Serializable {


	private static final long serialVersionUID = 3030711075369274498L;
	@Id
	@GeneratedValue(generator = "jpa-uuid")
	@Column(length = 32)
	@ExportConfig(value = "用户id")
	private String id;	//主键
	private String pxYearDemand;	//培训需求id
	private String projectId;	//项目id
	private java.util.Date createTime;	//创建时间
	private String createUserId;	//创建人
	private String departmentId;	//部门
	private String companyId;	//公司
	private String secondCompanyId;	//二级单位
	private String type;	//类型
	private String sumOrg;	//汇总组织id


}