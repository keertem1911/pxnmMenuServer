package com.example.demo.controller;

import com.example.demo.service.ImportService;
import com.example.demo.service.ProjectClassifyService;
import com.example.demo.service.ProjectService;
import com.example.demo.service.ProjectSubService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import javax.servlet.http.HttpServletRequest;
import java.io.InputStream;
import java.util.List;

@RestController
@RequestMapping("/projectsub")
@Slf4j
public class ProjectSubController {

    @Autowired
    private ProjectSubService projectSubService;

    @Autowired
    private ImportService importService;

    /**
     * 四级项目导入
     * @param request
     * @return
     * @throws Exception
     */
    @PostMapping(value = "/readExeclIntoProject")
    @ResponseBody
    public String readExeclIntoProject(HttpServletRequest request) throws Exception {
        MultipartHttpServletRequest multipartRequest = (MultipartHttpServletRequest) request;

        MultipartFile file = multipartRequest.getFile("filename");
        if (file.isEmpty()) {
            return "文件不能为空";
        }
        InputStream inputStream = file.getInputStream();
        List<List<Object>> list = importService.getBankListByExcel(inputStream, file.getOriginalFilename());
        inputStream.close();
        projectSubService.readExcelInsertPersonTarget(list);
        return "上传成功";
    }

    /**
     * 将三级项目的培训对象复制到四级里面当项目
     */
    @GetMapping("/copy")
    @ResponseBody
    public String copy(){
        projectSubService.copyFromPxProjectId();
        return "success";
    }
}
