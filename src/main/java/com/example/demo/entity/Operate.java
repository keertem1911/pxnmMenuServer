package com.example.demo.entity;

import com.example.demo.annotation.ExportConfig;
import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "SYS_OPERATE")
@GenericGenerator(name = "jpa-uuid", strategy = "uuid")
@Data
public class Operate implements Serializable {
	/**
	 *
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(generator = "jpa-uuid")
	@Column(length = 32)
	@ExportConfig(value = "id")
	private String id;
	@ExportConfig(value = "编码")
	private String code;
	@ExportConfig(value = "是否启用")
	private String enabled;
	@ExportConfig(value = "名称")
	private String name;
	@ExportConfig(value = "排序")
	private double orderIndex;
	@ExportConfig(value = "资源路径")
	private String resourcePath;
	@ExportConfig(value = "菜单id")
	private String menuId;
	@ExportConfig(value = "备注")
	private String remark;
	@ExportConfig(value = "是否赋权")
	private String allowAuthz;
	@ExportConfig(value = "是否记录日志")
	private String isLog;
}