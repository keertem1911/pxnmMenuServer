package com.example.demo.entity.monthcenter;

import lombok.Data;
import lombok.ToString;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;


@Entity
@Table(name = "PX_MONTH_PLAN_CENTER")
@GenericGenerator(name = "jpa-uuid", strategy = "uuid")
@Data
@ToString
public class PxMonthPlanCenter implements Serializable {


	private static final long serialVersionUID = 3921152549327218858L;
	@Id
	@GeneratedValue(generator = "jpa-uuid")
	@Column(length = 32)
	private String id;
	private String pxYear;    //培训年
	private String pxMonth;    //培训月
	private Date createTime = new Date();    //创建时间
	private String state = "N";    //发布状态
	private Date writeStopTime;    //第一次截止时间
	private String createUserId;    //创建人
	private String remark;    //备注
	private Date writeStopTimeSecond;
	private String stateSecond = "N";//
	private String monthPlanCenterHref;
	private String endState = "N";// 终稿状态

}