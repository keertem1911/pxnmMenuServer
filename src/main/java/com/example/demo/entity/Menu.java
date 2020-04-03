package com.example.demo.entity;

import com.example.demo.annotation.ExportConfig;
import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "SYS_MENU")
@GenericGenerator(name = "jpa-uuid", strategy = "uuid")
@Data
public class Menu implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	
	@Id
	@GeneratedValue(generator = "jpa-uuid")
	@Column(length = 32)
	@ExportConfig(value = "id")
	private String id;
	@ExportConfig(value = "菜单名称",width = 150)
	private String name;
	@ExportConfig(value = "parentId")
	private String parentId;
	@ExportConfig(value = "enabled",width = 60)
	private String enabled="Y";
	@ExportConfig(value = "排序")
	private double orderIndex;
	private String icon;
	@ExportConfig(value = "资源路径")
	private String resourcePath;
	@ExportConfig(value = "备注")
	private String remark;
	@ExportConfig(value = "类型")
	private String type;
	@ExportConfig(value = "是否赋权限")
	private String allowAuthz="Y";
}
