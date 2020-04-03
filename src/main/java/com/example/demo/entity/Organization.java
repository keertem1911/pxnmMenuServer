package com.example.demo.entity;

import com.example.demo.annotation.ExportConfig;
import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.io.Serializable;
@Entity
@Table(name = "SYS_ORGANIZATION")
@GenericGenerator(name = "jpa-uuid", strategy = "uuid")
@Data
public class Organization implements Serializable {
	/**
	 *
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(generator = "jpa-uuid")
	@Column(length = 32)
	@ExportConfig(value = "组织机构编号")
	private String id;
	@ExportConfig(value = "名称")
	private String name;
	@ExportConfig(value = "全称名称")
	private String nameFull;
	@ExportConfig(value = "上级机构")
	private String parentId;
	@ExportConfig(value = "排序")
	private double orderIndex;
	@ExportConfig(value = "备注")
	private String remark;
	@ExportConfig(value = "是否为公司级别")
	private String isCompany;
//	private Date createDate;
//	private Date updateDate;//
	@ExportConfig(value = "删除状态")
	private String state;//删除逻辑状态1未删除 0删除
	@ExportConfig(value = "二级单位")
	private String secondCompanyId;//所属二级公司即parent_id为集团的

	@ExportConfig(value = "上级公司名称")
	@Transient
	private String parentName;
	@ExportConfig(value = "二级单位名称")
	@Transient
	private String secondCompanyName;
}