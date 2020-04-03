package com.example.demo.entity;


import com.example.demo.annotation.ExportConfig;
import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.io.Serializable;
@Entity
@Table(name = "SYS_DICT")
@GenericGenerator(name = "jpa-uuid", strategy = "uuid")
@Data
public class Dict implements Serializable {
	/**
	 *
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(generator = "jpa-uuid")
	@Column(length = 32)
	@ExportConfig(value = "字典")
	private String id;
	private String name;
	private String remark;
	private double orderIndex;
	private String isDelete = "N";
	private String classifyId;
	/**
	 * 0无意义考试为1则代表是安监局考试
	 */
	private String signType="0";
	
}