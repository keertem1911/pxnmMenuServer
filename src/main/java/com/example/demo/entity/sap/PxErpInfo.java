package com.example.demo.entity.sap;

import com.example.demo.annotation.ExportConfig;
import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.io.Serializable;

/**
 * @author 王传鑫
 * @date 2020/4/1014:33
 */
@Entity
@Table(name = "PX_ERP_INFO")
@GenericGenerator(name = "jpa-uuid", strategy = "uuid")
@Data
public class PxErpInfo implements Serializable {


    private static final long serialVersionUID = 7220576114902757818L;
    @Id
    @GeneratedValue(generator = "jpa-uuid")
    @Column(length = 32)
    @ExportConfig(value = "sap同步功能表")
    private String id;
    @ExportConfig(value = "erp执行id（px_erp）")
    private String pid;// px_erp
    @ExportConfig(value = "执行多长时间")
    private Integer extime;
    @ExportConfig(value = "新增记录数")
    private Integer addcount;
    @ExportConfig(value = "更新记录数")
    private Integer upcount;
    @ExportConfig(value = "更新时间表id")
    private String gxid;
}
