package com.example.demo.entity.demand;

import java.io.Serializable;

import com.example.demo.annotation.ExportConfig;
import lombok.Data;
import lombok.ToString;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;


@Entity
@Table(name = "PX_YEAR_PLAN_HR_PROJECT")
@GenericGenerator(name = "jpa-uuid", strategy = "uuid")
@Data
@ToString
public class YearPlanHrProject implements Serializable {


	private static final long serialVersionUID = 5105720772728645296L;
	@Id
	@GeneratedValue(generator = "jpa-uuid")
	@Column(length = 32)
	@ExportConfig(value = "用户id")
	private String id;	//主键
	private String projectId;	//项目id
	private java.util.Date createTime;	//创建时间
	private String sysUser;	//创建人
	private String pxJtDemandNews;	//外键

}