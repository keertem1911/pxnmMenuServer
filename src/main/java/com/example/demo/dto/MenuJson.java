package com.example.demo.dto;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * @Description
 * @Author 王传鑫
 * @Date 2019/7/19
 */
@Data
public class MenuJson implements Serializable {

    private static final long serialVersionUID = 7440843299091365573L;


    /**
     * authzId : 953b4dcdaa8e4a4194a9f49c7eb717bd
     * type : MODULE
     * referencesId : null
     * id : 36691ac29d8946d082c2e7ef95b07531
     * text : 工种管理
     * pid : 30321a7f5ea547f48369dfc8b3e12529
     * orderIndex : 2
     * resourcePath : App.sys.module.worktype.View
     * allowAuthz : Y
     * remark : null
     * enabled : Y
     * code : null
     * isLog : N
     * icon : /insstatic/image/icon/form.png
     * children : [{"authzId":"d496687d2af44e838974f22eca745b65","type":"OPERATE","referencesId":null,"id":"7d8dbb5f7f77466ebf1c8583947af4e6","text":"添加工种分类","pid":"36691ac29d8946d082c2e7ef95b07531","orderIndex":1,"resourcePath":"/px/worktype/classify/add","allowAuthz":"Y","remark":null,"enabled":"Y","code":"PX_WORKTYPE_CLASSIFY_ADD","isLog":"Y","icon":"/insstatic/image/icon/config.png","leaf":true},{"authzId":"3d63ac29d38747c8b0b24e260af26a38","type":"OPERATE","referencesId":null,"id":"5571553d79e94ec8a3ae07c413acd101","text":"编辑工种分类","pid":"36691ac29d8946d082c2e7ef95b07531","orderIndex":2,"resourcePath":"/px/worktype/classify/update","allowAuthz":"Y","remark":null,"enabled":"Y","code":"PX_WORKTYPE_CLASSIFY_UPDATE","isLog":"Y","icon":"/insstatic/image/icon/config.png","leaf":true},{"authzId":"6d52f6f337674687816581ba56b923c8","type":"OPERATE","referencesId":null,"id":"2eaf75a38e6f4c5e9efe474e84979e18","text":"删除工种分类","pid":"36691ac29d8946d082c2e7ef95b07531","orderIndex":3,"resourcePath":"/px/worktype/classify/delete","allowAuthz":"Y","remark":"禁用此功能，工种分类不能删","enabled":"Y","code":"PX_WORKTYPE_CLASSIFY_DELETE","isLog":"Y","icon":"/insstatic/image/icon/config.png","leaf":true},{"authzId":"e140497e9fcd4675b400cb8341d4670f","type":"OPERATE","referencesId":null,"id":"ddead73c0e9c4aca9ef89c4e890936f4","text":"查看工种分类","pid":"36691ac29d8946d082c2e7ef95b07531","orderIndex":4,"resourcePath":"/px/worktype/classify/load","allowAuthz":"Y","remark":null,"enabled":"Y","code":"PX_WORKTYPE_CLASSIFY_VIEW","isLog":"Y","icon":"/insstatic/image/icon/config.png","leaf":true},{"authzId":"a29bb435d86b45a5b20c9ceb74e1c466","type":"OPERATE","referencesId":null,"id":"30d397ebd4874a7b874e6d2c8e4ed7d5","text":"添加工种","pid":"36691ac29d8946d082c2e7ef95b07531","orderIndex":5,"resourcePath":"/px/worktype/add","allowAuthz":"Y","remark":null,"enabled":"Y","code":"PX_WORKTYPE_ADD","isLog":"Y","icon":"/insstatic/image/icon/config.png","leaf":true},{"authzId":"d76909693ab045ad980115a2c1fd3c92","type":"OPERATE","referencesId":null,"id":"4c9ad32675064dcfafbbd4e19874aec3","text":"编辑工种","pid":"36691ac29d8946d082c2e7ef95b07531","orderIndex":6,"resourcePath":"/px/worktype/update","allowAuthz":"Y","remark":null,"enabled":"Y","code":"PX_WORKTYPE_UPDATE","isLog":"Y","icon":"/insstatic/image/icon/config.png","leaf":true},{"authzId":"72887f7fc0274aaabaffe7ccb1c0d527","type":"OPERATE","referencesId":null,"id":"7de3d2dd69ab45619fbcf51c1bbbe468","text":"删除工种","pid":"36691ac29d8946d082c2e7ef95b07531","orderIndex":7,"resourcePath":"/px/worktype/delete","allowAuthz":"Y","remark":"禁用此功能，工种不能删","enabled":"Y","code":"PX_WORKTYPE_DELETE","isLog":"Y","icon":"/insstatic/image/icon/config.png","leaf":true},{"authzId":"8ce8eb77e3ea4dbe89ccdd998018e529","type":"OPERATE","referencesId":null,"id":"6bfb82f2ef604440bbec2a5c0ec60448","text":"查看工种","pid":"36691ac29d8946d082c2e7ef95b07531","orderIndex":8,"resourcePath":"/px/worktype/load","allowAuthz":"Y","remark":null,"enabled":"Y","code":"PX_WORKTYPE_VIEW","isLog":"Y","icon":"/insstatic/image/icon/config.png","leaf":true},{"authzId":"8e3270e61ed8476eb2358fede93f40c0","type":"OPERATE","referencesId":null,"id":"a9b8c3f22469478baee07776dad5bbe6","text":"添加工种级别","pid":"36691ac29d8946d082c2e7ef95b07531","orderIndex":9,"resourcePath":"/px/worktype/level/add","allowAuthz":"Y","remark":null,"enabled":"Y","code":"PX_WORKTYPE_LEVEL_ADD","isLog":"Y","icon":"/insstatic/image/icon/config.png","leaf":true},{"authzId":"60908ba4b5a3499db08a677384c0299e","type":"OPERATE","referencesId":null,"id":"7bf8c785f9484f6596cd8731139fd234","text":"编辑工种级别","pid":"36691ac29d8946d082c2e7ef95b07531","orderIndex":10,"resourcePath":"/px/worktype/level/update","allowAuthz":"Y","remark":null,"enabled":"Y","code":"PX_WORKTYPE_LEVEL_UPDATE","isLog":"Y","icon":"/insstatic/image/icon/config.png","leaf":true},{"authzId":"d556aa51b19e4a7abfbe9300c58be258","type":"OPERATE","referencesId":null,"id":"d1881f168ccf44098d276e4b6a81152f","text":"删除工种级别","pid":"36691ac29d8946d082c2e7ef95b07531","orderIndex":11,"resourcePath":"/px/worktype/level/delete","allowAuthz":"Y","remark":"禁用此功能，工种级别不能删","enabled":"Y","code":"PX_WORKTYPE_LEVEL_DELETE","isLog":"Y","icon":"/insstatic/image/icon/config.png","leaf":true},{"authzId":"7f041c9b8dce42b99964592d1a38ba12","type":"OPERATE","referencesId":null,"id":"d1fec916f414452783d37c4263e96094","text":"查看工种级别","pid":"36691ac29d8946d082c2e7ef95b07531","orderIndex":12,"resourcePath":"/px/worktype/level/load","allowAuthz":"Y","remark":null,"enabled":"Y","code":"PX_WORKTYPE_LEVEL_VIEW","isLog":"Y","icon":"/insstatic/image/icon/config.png","leaf":true}]
     */

    private String authzId;
    private String type;
    private Object referencesId;
    private String id;
    private String text;
    private String pid;
    private double orderIndex;
    private String resourcePath;
    private String allowAuthz;
    private Object remark;
    private String enabled;
    private Object code;
    private String isLog;
    private String icon;
    private List<ChildrenBean> children;

    @Data
    public static class ChildrenBean {
        /**
         * authzId : d496687d2af44e838974f22eca745b65
         * type : OPERATE
         * referencesId : null
         * id : 7d8dbb5f7f77466ebf1c8583947af4e6
         * text : 添加工种分类
         * pid : 36691ac29d8946d082c2e7ef95b07531
         * orderIndex : 1
         * resourcePath : /px/worktype/classify/add
         * allowAuthz : Y
         * remark : null
         * enabled : Y
         * code : PX_WORKTYPE_CLASSIFY_ADD
         * isLog : Y
         * icon : /insstatic/image/icon/config.png
         * leaf : true
         private String id;
         private String code;
         private String enabled;
         private String name;=> text
         private double orderIndex;
         private String resourcePath;
         private String menuId;
         private String remark;
         private String allowAuthz;
         private String isLog;
         */

        private String authzId;
        private String type;
        private Object referencesId;
        private String id;
        private String text;
        private String pid;
        private double orderIndex;
        private String resourcePath;
        private String allowAuthz;
        private Object remark;
        private String enabled;
        private String code;
        private String isLog;
        private String icon;
        private boolean leaf;

    }
}
