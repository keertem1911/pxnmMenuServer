package com.example.demo.entity.demand;

import java.io.Serializable;

import com.example.demo.annotation.ExportConfig;
import lombok.Data;
import lombok.ToString;
import org.hibernate.annotations.GenericGenerator;
import javax.persistence.*;

@Entity
@Table(name = "PX_YEAR_DEMAND_LOG")
@GenericGenerator(name = "jpa-uuid", strategy = "uuid")
@Data
@ToString
public class YearDemandLog implements Serializable {


	private static final long serialVersionUID = -6614511651995728931L;
	@Id
	@GeneratedValue(generator = "jpa-uuid")
	@Column(length = 32)
	@ExportConfig(value = "用户id")
	private String id;	//
	private String pxYearPlanProject;	//
	private java.util.Date createTime;	//
	private String createUserId;	//
	private java.util.Date updateTime;	//


}