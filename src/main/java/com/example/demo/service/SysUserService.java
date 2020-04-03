package com.example.demo.service;

import com.example.demo.dao.EmpTongxunxinxiJpaRespository;
import com.example.demo.dao.SysUserInfoJpaRespository;
import com.example.demo.dao.SysUserJpaRespository;
import com.example.demo.entity.Dict;
import com.example.demo.entity.SysUserInfo;
import com.example.demo.entity.User;
import lombok.extern.java.Log;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;

@Service
@Log
public class SysUserService {

    private SysUserJpaRespository sysUserJpaRespository;

    private SysUserInfoJpaRespository sysUserInfoJpaRespository;
    @Autowired
    public SysUserService(SysUserJpaRespository sysUserJpaRespository
    , EmpTongxunxinxiJpaRespository empTongxunxinxiJpaRespository
    , SysUserInfoJpaRespository sysUserInfoJpaRespository) {

        this.sysUserJpaRespository = sysUserJpaRespository;
        this.sysUserInfoJpaRespository=sysUserInfoJpaRespository;
        this.empTongxunxinxiJpaRespository=empTongxunxinxiJpaRespository;

    }

    private EmpTongxunxinxiJpaRespository empTongxunxinxiJpaRespository;

    public List<User> findAll(){
        return  sysUserJpaRespository.findAll();
    }
    public User save(User Project){
        return sysUserJpaRespository.save(Project);
    }
    public User getOne(String orgId){
        return sysUserJpaRespository.getOne(orgId);
    }

    /**
     * 3:岗位 job  *字典 SYSTEM_JOB
     * 5:职务 duty *字典 SYSTEM_DUTY
     * 6:员工编码 account
     * 7:姓名 name
     * 8:性别 sex
     * 9:员工组 EMPLOYEE_GROUP  *字典 PX_EMPLOYEE_GROUP
     * 10:员工子组 EMPLOYEE_SUBGROUP *字典 PX_EMPLOYEE_SUBGROUP
     * 11:身份证号 id_card
     * 12:参加工作时间 ATTEND_WORK_TIME
     * 13:进入神华系统时间 ACCESS_SH_TIME
     * 14:进入子(分)公司时间 ACCESS_SUBSIDIAR_TIME
     * 15:进入本单位时间 ACCESS_THIE_UNIT_TIME
     * 16:政治面貌 POLITICS_STATUS *字典 PX_POLITICS_STATUS
     * 17:参加党派时间 ATTEND_PARTY_TIME
     * 18:最高学历 HIGHEST_EDUCATION *字典 SYSTEM_EDU
     * 26:最高专业技术资格 HIGHEST_MAJOR *字典 PX_HIGHEST_MAJOR
     * @param list
     */
    private static final String JOB="job";
    private static final String DUTY="duty";
    private static final String ACCOUNT="account";
    private static final String NAME="name";
    private static final String SEX="sex";
    private static final String EMPLOYEEGROUP="employeeGroup";
    private static final String EMPLOYEESUBGROUP="employeeSubgroup";
    private static final String IDCARD="idCard";
    private static final String ATTENDWORKTIME="attendWorkTime";
    private static final String ACCESSSHTIME="accessShTime";
    private static final String ACCESSSUBSIDIARTIME="accessSubsidiarTime";
    private static final String ACCESSTHIEUNITTIME="accessThieUnitTime";
    private static final String POLITICSSTATUS="politicsStatus";
    private static final String ATTENDPARTYTIME="attendPartyTime";
    private static final String HIGHESTEDUCATION="highestEducation";
    private static final String HIGHESTMAJOR="highestMajor";

    public void uploadList(List<List<Object>> list) {
        Map<Integer,String> indexMap=new TreeMap<>();
        indexMap.put(3,JOB);
        indexMap.put(5,DUTY);
        indexMap.put(6,ACCOUNT);
        indexMap.put(7,NAME);
        indexMap.put(8,SEX);
        indexMap.put(9,EMPLOYEEGROUP);
        indexMap.put(10,EMPLOYEESUBGROUP);
        indexMap.put(11,IDCARD);
        indexMap.put(12,ATTENDWORKTIME);
        indexMap.put(13,ACCESSSHTIME);
        indexMap.put(14,ACCESSSUBSIDIARTIME);
        indexMap.put(15,ACCESSTHIEUNITTIME);
        indexMap.put(16,POLITICSSTATUS);
        indexMap.put(17,ATTENDPARTYTIME);
        indexMap.put(18,HIGHESTEDUCATION);
        indexMap.put(26,HIGHESTMAJOR);
        List<Map<String,String>> userList=new ArrayList<>();
        for (int i=1;i<list.size();++i) {
            List<Object> data=list.get(i);
            Map<String,String> user=new HashMap<>();
            if(data.size()>26) {
                for (Integer integer : indexMap.keySet()) {
                    String item = "" + data.get(integer);
                    user.put(indexMap.get(integer), item.trim());
                }
                userList.add(user);
            }
        }

        int totle=userList.size();
        for (int i=0;i<userList.size();++i) {
            Map<String, String> userMap=userList.get(i);
            String jobCode = userMap.get(JOB);
            String dutyCode = userMap.get(DUTY);
            String account = userMap.get(ACCOUNT);
            String employeegroup = userMap.get(EMPLOYEEGROUP);
            String employeesubgroup = userMap.get(EMPLOYEESUBGROUP);
            String attendworktime = userMap.get(ATTENDWORKTIME);
            String accessshtime = userMap.get(ACCESSSHTIME);
            String accesssubsidiartime = userMap.get(ACCESSSUBSIDIARTIME);
            String accessthieunittime = userMap.get(ACCESSTHIEUNITTIME);
            String politicsstatus = userMap.get(POLITICSSTATUS);
            String attendpartytime = userMap.get(ATTENDPARTYTIME);
            String highesteducation = userMap.get(HIGHESTEDUCATION);
            String highestmajor = userMap.get(HIGHESTMAJOR);
            User user=sysUserJpaRespository.findOneByAccount(account);
            if(user!=null){
                //SYSTEM_JOB 岗位
                if(StringUtils.isNotBlank(jobCode)) {
                    Dict dict=dictService.getDictOrSave(jobCode,"SYSTEM_JOB");
                    user.setJob(dict.getId());
                }
                //SYSTEM_DUTY 职务
                if(StringUtils.isNotBlank(dutyCode)) {
                    Dict dict=dictService.getDictOrSave(dutyCode,"SYSTEM_DUTY");
                    user.setDuty(dict.getId());
                }
                //PX_EMPLOYEE_GROUP 员工组
                if(StringUtils.isNotBlank(employeegroup)) {
                    Dict dict=dictService.getDictOrSave(employeegroup,"PX_EMPLOYEE_GROUP");
                    user.setEmployeeGroup(dict.getId());
                }
                //PX_EMPLOYEE_SUBGROUP 员工子组
                if(StringUtils.isNotBlank(employeesubgroup)) {
                    Dict dict=dictService.getDictOrSave(employeesubgroup,"PX_EMPLOYEE_SUBGROUP");
                    user.setEmployeeSubgroup(dict.getId());
                }
                //PX_POLITICS_STATUS 政治面貌
                if(StringUtils.isNotBlank(politicsstatus)) {
                    Dict dict=dictService.getDictOrSave(politicsstatus,"PX_POLITICS_STATUS");
                    user.setPoliticsStatus(dict.getId());
                }
                //最高学历   *字典 SYSTEM_EDU
                if(StringUtils.isNotBlank(highesteducation)) {
                    Dict dict=dictService.getDictOrSave(highesteducation,"SYSTEM_EDU");
                    user.setHighestEducation(dict.getId());
                }
                //最高专业技术资格   *字典 PX_HIGHEST_MAJOR
                if(StringUtils.isNotBlank(highestmajor)) {
                    Dict dict=dictService.getDictOrSave(highestmajor,"PX_HIGHEST_MAJOR");
                    user.setHighestMajor(dict.getId());
                }
                SimpleDateFormat format=new SimpleDateFormat("yyyy.MM.dd");
                /**
                 * 时间
                 *   * 12:参加工作时间 ATTEND_WORK_TIME
                 *   * 13:进入神华系统时间 ACCESS_SH_TIME
                 *   * 14:进入子(分)公司时间 ACCESS_SUBSIDIAR_TIME
                 *   * 15:进入本单位时间 ACCESS_THIE_UNIT_TIME
                 */
                if(StringUtils.isNotBlank(attendworktime)){
                    try {
                        Date workTime = format.parse(attendworktime);
                        user.setAttendWorkTime(workTime);
                    }catch (Exception e){
                        e.printStackTrace();
                    }
                }
                if(StringUtils.isNotBlank(accessshtime)){
                    try {
                        Date accessshTime = format.parse(accessshtime);
                        user.setAccessShTime(accessshTime);
                    }catch (Exception e){
                        e.printStackTrace();
                    }
                }
                if(StringUtils.isNotBlank(accesssubsidiartime)){
                    try {
                        Date accesssubsidiarTime = format.parse(accesssubsidiartime);
                        user.setAccessSubsidiarTime(accesssubsidiarTime);
                    }catch (Exception e){
                        e.printStackTrace();
                    }
                }
                if(StringUtils.isNotBlank(accessthieunittime)){
                    try {
                        Date accessthieunitTime = format.parse(accessthieunittime);
                        user.setAccessThieUnitTime(accessthieunitTime);
                    }catch (Exception e){
                        e.printStackTrace();
                    }
                }
                if(StringUtils.isNotBlank(attendpartytime)){
                    try {
                        Date attendpartyTime = format.parse(attendpartytime);
                        user.setAttendPartyTime(attendpartyTime);
                    }catch (Exception e){
                        e.printStackTrace();
                    }
                }
                sysUserJpaRespository.save(user);
                log.info("已更新,员工编号="+account);

            }
            else{
                log.info("用户不存在 员工编号= "+account);
            }
            log.info("更新进度 "+i+" / "+totle);

        }

    }
    @Autowired
    private DictService dictService;
    public void updatePhone(){

        List<String> userIds = sysUserJpaRespository.findUserAll();
        List<User> users=new ArrayList<>(userIds.size());
        int totle=userIds.size();

        userIds.stream().forEach(d->{

            List<String> phones = empTongxunxinxiJpaRespository.findFlagByUserId(d);
            if(phones!=null&&phones.size()>0){
                User user = sysUserJpaRespository.getOne(d);

                SysUserInfo userInfo = sysUserInfoJpaRespository.getOne(d);
                user.setPhone(phones.get(0));
                userInfo.setPhone(phones.get(0));
                log.info("name="+user.getName()+",flag="+user.getPhone());
                log.info("已更新 ="+users.size()+" 总"+totle);
                sysUserJpaRespository.save(user);
                sysUserInfoJpaRespository.save(userInfo);
            }

        });
    }
    public int updateTuiyang(){
        List<String> userIds= sysUserJpaRespository.findUserTuiyangList();
        final int totle=userIds.size();
        AtomicInteger i=new AtomicInteger(0);
        if(userIds!=null&&userIds.size()>0)
            userIds.forEach(id->{
                User u = sysUserJpaRespository.getOne(id);
                u.setIsDelete("Y");
                log.info("更新退养人员,员工编号="+u.getAccount()+" ,姓名="+u.getName());
                log.info("totle="+totle+", current="+i);
                i.getAndAdd(1);
                sysUserJpaRespository.save(u);
            });
        i.set(0);
        List<String> userInfoIds= sysUserInfoJpaRespository.findUserTuiyangList();
        final int totle2=userInfoIds.size();
        if(userInfoIds!=null&&userInfoIds.size()>0)
            userInfoIds.forEach(id->{
                SysUserInfo u = sysUserInfoJpaRespository.findOneById(id);
                if(u!=null) {
                    u.setIsDelete("Y");
                    log.info("更新退养人员,员工编号=" + u.getAccount() + " ,姓名=" + u.getName());
                    log.info("totle="+totle2+", current="+i);
                    sysUserInfoJpaRespository.save(u);
                    i.getAndAdd(1);
                }
            });
        userIds.clear();
        userInfoIds.clear();
        userIds=sysUserJpaRespository.findNoSecondCompanyId();
        userInfoIds=sysUserInfoJpaRespository.findNoSecondCompanyId();
        final int totle3=userInfoIds.size();
        log.info("更新无组织机构人员"+totle3);
        if(userIds.size()>0)
            userIds.forEach(d->{
                User user = sysUserJpaRespository.getOne(d);
                user.setIsDelete("Y");
                log.info("更新无组织机构人员,员工编号=" + user.getAccount() + " ,姓名=" + user.getName());
                sysUserJpaRespository.save(user);
            });
        if(userInfoIds.size()>0)
            userInfoIds.forEach(d->{
                SysUserInfo user = sysUserInfoJpaRespository.findOneById(d);
                user.setIsDelete("Y");
                sysUserInfoJpaRespository.save(user);
            });
        return totle+totle2+totle3;
    }
}
