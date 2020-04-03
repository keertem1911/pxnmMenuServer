package com.example.demo.controller;

import com.example.demo.service.ImportService;
import com.example.demo.service.ProjectClassifyService;
import com.example.demo.service.ProjectService;
import com.example.demo.service.SysUserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import javax.servlet.http.HttpServletRequest;
import java.io.InputStream;
import java.util.List;

@RestController
@RequestMapping("/user")
@Slf4j
public class UserController {

    @Autowired
    private SysUserService sysUserService;

    @Autowired
    private ImportService importService;
    @PostMapping(value = "/upload")
    @ResponseBody
    public String uploadExcel(HttpServletRequest request) throws Exception {
        MultipartHttpServletRequest multipartRequest = (MultipartHttpServletRequest) request;

        MultipartFile file = multipartRequest.getFile("filename");
        if (file.isEmpty()) {
            return "文件不能为空";
        }
        InputStream inputStream = file.getInputStream();
        List<List<Object>> list = importService.getBankListByExcel(inputStream, file.getOriginalFilename());
        inputStream.close();

        sysUserService.uploadList(list);
        return "上传成功";
    }
    @GetMapping(value = "/updatePhone")
    @ResponseBody
    public String updatePhone(HttpServletRequest request) throws Exception {

        sysUserService.updatePhone();
        return "success";
    }

    @GetMapping(value = "/updateTuiyang")
    @ResponseBody
    public String updateTuiyang(HttpServletRequest request) throws Exception {

        int num=sysUserService.updateTuiyang();
        return "success,更新数量="+num;
    }

}
