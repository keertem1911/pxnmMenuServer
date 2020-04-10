package com.example.demo.entity.sap;

import com.example.demo.annotation.ExportConfig;
import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.io.Serializable;

/**
 * @author 王传鑫
 * @date 2020/4/1014:46
 */
@Entity
@Table(name = "ERP_TEMP_ORG")
@GenericGenerator(name = "jpa-uuid", strategy = "uuid")
@Data
public class ErpTempOrg implements Serializable {

    private static final long serialVersionUID = 9090850188731985507L;
    @Id
    @GeneratedValue(generator = "jpa-uuid")
    @Column(length = 32)
    @ExportConfig(value = "sap同步组织机构")
    private String id;
    private String orgnum;
    private String orgname;
    private String statedate;
    private String enddate;
    private String updatedate;
    private String proid;
    private String creatdate;
}
