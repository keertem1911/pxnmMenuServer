package com.example.demo.entity;


import com.example.demo.annotation.ExportConfig;
import lombok.Data;
import lombok.ToString;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "px_project_classify")
@GenericGenerator(name = "jpa-uuid", strategy = "uuid")
@Data
@ToString
public class ProjectClassify implements Serializable {
	/**
	 *
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(generator = "jpa-uuid")
	@Column(length = 32)
	@ExportConfig(value = "组织机构编号")
	private String id;
	private String name;
	private String remark;
	private String isDelete = "N";
	private String parent;
	private Date createTime=new Date();
	private String isMonth;
	private String code;
	private Double orderIndex;

}