package com.example.demo.entity;

import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "SYS_AUTHZ")
@GenericGenerator(name = "jpa-uuid", strategy = "uuid")
@Data
public class Authz implements Serializable {
	/**
	 *
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(generator = "jpa-uuid")
	@Column(length = 32)
	private String id;
	private String type;

	public Authz(String type) {
		this.type = type;
	}
	public Authz(){}
}