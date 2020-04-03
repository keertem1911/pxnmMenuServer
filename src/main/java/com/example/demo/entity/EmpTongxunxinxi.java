package com.example.demo.entity;

import com.example.demo.annotation.ExportConfig;
import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.Entity;
import javax.persistence.Table;
import java.io.Serializable;
import javax.persistence.*;

@Entity
@Table(name = "CESMS_EMP_TONGXUNXINXI")
@GenericGenerator(name = "jpa-uuid", strategy = "uuid")
@Data
public class EmpTongxunxinxi implements Serializable {
	
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(generator = "jpa-uuid")
	@Column(length = 32)
	@ExportConfig(value = "id")
	private Serializable id;	//序号
	private String txType;	//通讯类型
	private String flag;	//标识
	private String personid;	//所属人员id_if_person
	private java.util.Date updateTime;	//最新更新时间
	private String isModify="Y";// N 数据同步 Y修改不同步/本系统新增

	public String getIsModify() {
		return isModify;
	}

	public void setIsModify(String isModify) {
		this.isModify = isModify;
	}
	public void setId(Serializable value) {
		this.id = value;
	}
	
	public Serializable getId() {
		return this.id;
	}
	
	public void setTxType(String value) {
		this.txType = value;
	}
	
	public String getTxType() {
		return this.txType;
	}
	
	public void setFlag(String value) {
		this.flag = value;
	}
	
	public String getFlag() {
		return this.flag;
	}

	public String getPersonid() {
		return personid;
	}

	public void setPersonid(String personid) {
		this.personid = personid;
	}

	public void setUpdateTime(java.util.Date value) {
		this.updateTime = value;
	}
	
	public java.util.Date getUpdateTime() {
		return this.updateTime;
	}
	
}