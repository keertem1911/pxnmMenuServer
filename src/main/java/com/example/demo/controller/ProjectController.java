package com.example.demo.controller;

import com.example.demo.entity.Project;
import com.example.demo.service.ImportService;
import com.example.demo.service.ProjectClassifyService;
import com.example.demo.service.ProjectService;
import com.example.demo.service.YearDemandService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import javax.servlet.http.HttpServletRequest;
import java.io.InputStream;
import java.util.List;

@RestController
@RequestMapping("/project")
@Slf4j
public class ProjectController {

    @Autowired
    private ProjectService projectService;
    @Autowired
    private ProjectClassifyService projectClassifyService;

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

        for (int i = 0; i < list.size(); i++) {
            List<Object> lo = list.get(i);
            String projectId= lo.get(0)+"";
//            Project project=projectService.getOne(projectId);
            for (Object o : lo) {
                System.out.print(o+"-");
            }
            System.out.println();
        }
        return "上传成功";
    }

    @PostMapping(value = "/readExeclIntoMonth")
    @ResponseBody
    public String readExeclIntoMonth(HttpServletRequest request) throws Exception {
        MultipartHttpServletRequest multipartRequest = (MultipartHttpServletRequest) request;

        MultipartFile file = multipartRequest.getFile("filename");
        if (file.isEmpty()) {
            return "文件不能为空";
        }
        InputStream inputStream = file.getInputStream();
        List<List<Object>> list = importService.getBankListByExcel(inputStream, file.getOriginalFilename());
        inputStream.close();

        projectClassifyService.readExeclIntoMonth(list);
        return "上传成功";
    }

    /**
     * 三级项目导入
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

        projectClassifyService.readExeclIntoProject(list);
        return "上传成功";
    }
    /**
     * 补全需求单位
     * @param request
     * @return
     * @throws Exception
     */
    @PostMapping(value = "/readExeclCompanyType")
    @ResponseBody
    public String readExeclCompanyType(HttpServletRequest request) throws Exception {
        MultipartHttpServletRequest multipartRequest = (MultipartHttpServletRequest) request;

        MultipartFile file = multipartRequest.getFile("filename");
        if (file.isEmpty()) {
            return "文件不能为空";
        }
        InputStream inputStream = file.getInputStream();
        List<List<Object>> list = importService.getBankListByExcel(inputStream, file.getOriginalFilename());
        inputStream.close();

        projectClassifyService.readExeclCompanyType(list);
        return "上传成功";
    }
    @Autowired
    private YearDemandService yearDemandService;

    /**
     * 需求填报去重合并
     * @return
     */
    @GetMapping("/distinct")
    public String getDistinct(){
        yearDemandService.handlerDemand();
        return "success";
    }
}
