package com.example.demo.util;

import com.example.demo.domain.ResponseBo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URLEncoder;
import java.util.List;
import java.util.UUID;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.regex.PatternSyntaxException;

public class FileUtil {

    private static Logger log = LoggerFactory.getLogger(FileUtil.class);

    private FileUtil() {

    }

    /**
     * 文件名加UUID
     *
     * @param filename 文件名
     * @return UUID_文件名
     */
    private static String makeFileName(String filename) {
        return UUID.randomUUID().toString() + "_" + filename;
    }

    /**
     * 文件名特殊字符过滤
     *
     * @param fileName 文件名
     * @return 过滤后的文件名
     * @throws PatternSyntaxException 正则异常
     */
    public static String stringFilter(String fileName) {
        String regEx = "[`~!@#$%^&*+=|{}':; ',//[//]<>/?~！@#￥%……&*（）——+|{}【】‘；：”“’。，、？]";
        Pattern p = Pattern.compile(regEx);
        Matcher m = p.matcher(fileName);
        return m.replaceAll("").trim();
    }

    /**
     * 生成Excel文件
     *
     * @param filename 文件名称
     * @param list     文件内容List
     * @param clazz    List中的对象类型
     * @return ResponseBo
     */
    public static ResponseBo createExcelByPOIKit(String filename, List<?> list, Class<?> clazz, HttpServletResponse response) {

        if (list.isEmpty()) {
            return ResponseBo.warn("导出数据为空！");
        } else {
            boolean operateSign = false;
            String fileName = filename+System.currentTimeMillis() + ".xlsx";
//            fileName = makeFileName(fileName);
            try {
//                File fileDir = new File("file");
//                if (!fileDir.exists())
//                    fileDir.mkdir();
//                String path = "file/" + fileName;
//                log.info(path);
                response.setCharacterEncoding("utf-8");
//                response.setHeader("Cache-Control", "no-store");
                response.setHeader("Content-Disposition", "attachment;fileName="
                        + URLEncoder.encode(fileName, "UTF-8"));
                response.setContentType("APPLICATION/OCTET-STREAM");
                ServletOutputStream fos = response.getOutputStream();
                operateSign = ExcelUtils.builder(clazz)
                        // 设置每个sheet的最大记录数,默认为10000,可不设置
                        // .setMaxSheetRecords(10000)
                        .toExcel(list, "查询结果", fos);
            } catch (FileNotFoundException e) {
                log.error("文件未找到", e);
            }catch (IOException e) {
                log.error("文件未找到", e);
            }
            if (operateSign) {
                return null;
            } else {
                return ResponseBo.error("导出Excel失败，请联系网站管理员！");
            }
        }
    }

    /**
     * 生成Csv文件
     *
     * @param filename 文件名称
     * @param list     文件内容List
     * @param clazz    List中的对象类型
     * @return ResponseBo
     */
    public static ResponseBo createCsv(String filename, List<?> list, Class<?> clazz) {

        if (list.isEmpty()) {
            return ResponseBo.warn("导出数据为空！");
        } else {
            boolean operateSign;
            String fileName = filename + ".csv";
            fileName = makeFileName(fileName);

            File fileDir = new File("file");
            if (!fileDir.exists())
                fileDir.mkdir();
            String path = "file/" + fileName;
            operateSign = ExcelUtils.builder(clazz)
                    .toCsv(list, path);
            if (operateSign) {
                return ResponseBo.ok(fileName);
            } else {
                return ResponseBo.error("导出Csv失败，请联系网站管理员！");
            }
        }
    }

}
