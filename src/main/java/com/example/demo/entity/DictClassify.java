package com.example.demo.entity;

import java.io.Serializable;

import com.example.demo.annotation.ExportConfig;
import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
@Entity
@Table(name = "SYS_DICT_CLASSIFY")
@GenericGenerator(name = "jpa-uuid", strategy = "uuid")
@Data
public class DictClassify implements Serializable {
	/**
	 *
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(generator = "jpa-uuid")
	@Column(length = 32)
	@ExportConfig(value = "字典等级分类")
	private String id;
	private String name;
	private String remark;
	private String code;
	private String isDelete = "N";

}