package com.example.demo.entity.monthcenter;

import lombok.Data;
import lombok.ToString;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.io.Serializable;
@Entity
@Table(name = "PX_MONTH_PLAN_CENTER_SCHEDULE")
@GenericGenerator(name = "jpa-uuid", strategy = "uuid")
@Data
@ToString
public class MonthPlanCenterSchedule implements Serializable {


	private static final long serialVersionUID = 5775208626400697122L;
	@Id
	@GeneratedValue(generator = "jpa-uuid")
	@Column(length = 32)
	private String id;	//
	private String pxMonthPlanCenterProject;	//月度计划项目
	private String timeName;	//日期名称(1号周一)
	private java.util.Date timeDate;	//安排日期
}