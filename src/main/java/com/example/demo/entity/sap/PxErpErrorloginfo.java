package com.example.demo.entity.sap;

import com.example.demo.annotation.ExportConfig;
import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.io.Serializable;

/**
 * @author 王传鑫
 * @date 2020/4/1014:37
 */
@Entity
@Table(name = "PX_ERP_ERRORLOGINFO")
@GenericGenerator(name = "jpa-uuid", strategy = "uuid")
@Data
public class PxErpErrorloginfo implements Serializable {

    private static final long serialVersionUID = 58940684181979187L;
    @Id
    @GeneratedValue(generator = "jpa-uuid")
    @Column(length = 32)
    @ExportConfig(value = "sap同步错误日志")
    private String id;
    @ExportConfig(value = "handlerid")
    private String handlid;
    @ExportConfig(value = "执行批次")
    private String pcid;
    @ExportConfig(value = "插入/更新")
    private String type;
    @ExportConfig(value = "校验错误/存储错误")
    private String errorType;
    @ExportConfig(value = "校验错误的字段")
    private String field;
    @ExportConfig(value = "错误信息")
    private String detail;
    @ExportConfig(value = "px_erp_infomx表的id")
    private String infomxid;


}
