package com.example.demo.service.sap;

import com.example.demo.dao.sap.PxErpErrorloginfoRepository;
import com.example.demo.dao.sap.PxErpInfoRepository;
import com.example.demo.dao.sap.PxErpInfomxRepository;
import com.example.demo.dao.sap.PxErpRepository;
import com.example.demo.entity.sap.PxErp;
import com.example.demo.entity.sap.PxErpErrorloginfo;
import com.example.demo.entity.sap.PxErpInfo;
import com.example.demo.entity.sap.PxErpInfomx;
import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author 王传鑫
 * @date 2020/4/1014:52
 */
@Service
@Log
public class SapService {

    @Autowired
    PxErpRepository pxErpRepository;
    @Autowired
    private PxErpInfoRepository pxErpInfoRepository;
    @Autowired
    private PxErpInfomxRepository pxErpInfomxRepository;
    @Autowired
    private PxErpErrorloginfoRepository pxErpErrorloginfoRepository;


    public int updateErpData(int limitNum){
        List<PxErp> erps = pxErpRepository.findAllByOrderByExtimeDesc();
        if(erps.size()<=limitNum)
            return 0;
        List<PxErp> erpsSub = erps.subList(limitNum, erps.size());
        log.info("共删除记录数 :"+erpsSub.size());
        erpsSub.forEach(d->{
            deleteErpInfo(d.getId());
            log.info(String.format("删除sap记录id:%s,时间%s",d.getId(),d.getExtime()+""));
            pxErpRepository.delete(d);
        });
        return erps.size();
    }
    private int deleteErpInfo(String pid){
        List<PxErpInfo> erpInfos = pxErpInfoRepository.findByPid(pid);
        erpInfos.forEach(d->{
            deleteErpInfomx(d.getId());
            log.info(String.format("功能详情%s",d.getGxid()));
            pxErpInfoRepository.delete(d);
        });
        return erpInfos.size();
    }
    private int deleteErpInfomx(String pid){
        List<PxErpInfomx> infomxList=pxErpInfomxRepository.findByPid(pid);
        infomxList.forEach(d->{
            deleteErrorLoginfo(d.getId());
            pxErpInfomxRepository.delete(d);
        });
        return infomxList.size();
    }
    private int deleteErrorLoginfo(String pid){
        List<PxErpErrorloginfo> erpErrorloginfos=
                pxErpErrorloginfoRepository.findByInfomxid(pid);
        erpErrorloginfos.forEach(pxErpErrorloginfoRepository::delete);
        return erpErrorloginfos.size();
    }


}
