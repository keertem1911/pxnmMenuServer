package com.example.demo.entity.sap;

import com.example.demo.annotation.ExportConfig;
import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.io.Serializable;

/**
 * @author 王传鑫
 * @date 2020/4/1014:35
 */
@Entity
@Table(name = "PX_ERP_INFOMX")
@GenericGenerator(name = "jpa-uuid", strategy = "uuid")
@Data
public class PxErpInfomx implements Serializable {

    private static final long serialVersionUID = -8926359097970956427L;
    @Id
    @GeneratedValue(generator = "jpa-uuid")
    @Column(length = 32)
    @ExportConfig(value = "sap同步功能表id")
    private String id;
    @ExportConfig(value = "执行信息id（px_erp_info）")
    private String pid;
    @ExportConfig(value = "类型（a,u）add,update")
    private String type;
    @ExportConfig(value = "内容明细")
    private String content;



}
