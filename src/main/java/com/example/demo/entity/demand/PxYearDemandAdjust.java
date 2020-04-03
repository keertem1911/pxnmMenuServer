package com.example.demo.entity.demand;

import com.example.demo.annotation.ExportConfig;
import lombok.Data;
import lombok.ToString;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "PX_YEAR_DEMAND_ADJUST")
@GenericGenerator(name = "jpa-uuid", strategy = "uuid")
@Data
@ToString
public class PxYearDemandAdjust implements Serializable {

  private static final long serialVersionUID = -4782582233475689915L;
  @Id
  @GeneratedValue(generator = "jpa-uuid")
  @Column(length = 32)
  @ExportConfig(value = "用户id")
  private String id;
  @Column(name = "project_id_old")
  private String projectIdOld;
  @Column(name = "project_id_new")
  private String projectIdNew;
  private Date createTime;
  private String createUserId;


}
