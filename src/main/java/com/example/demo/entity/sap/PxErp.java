package com.example.demo.entity.sap;

import com.example.demo.annotation.ExportConfig;
import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * @author 王传鑫
 * @date 2020/4/1014:29
 */
@Entity
@Table(name = "PX_ERP")
@GenericGenerator(name = "jpa-uuid", strategy = "uuid")
@Data
public class PxErp implements Serializable {

    private static final long serialVersionUID = 5302098330951887246L;
    @Id
    @GeneratedValue(generator = "jpa-uuid")
    @Column(length = 32)
    @ExportConfig(value = "sap同步时间表")
    private String id;
    @ExportConfig(value = "执行时间")
    private Date extime;
    @ExportConfig(value = "批次")
    private Integer pcid;
    @ExportConfig(value = "是否删除")
    private String isDelete;
}
