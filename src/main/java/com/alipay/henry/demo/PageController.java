/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2018 All Rights Reserved.
 */
package com.alipay.henry.demo;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.alipay.henry.demo.dao.GxyMapper;
import com.alipay.henry.demo.model.GxyDO;
import com.alipay.henry.demo.util.DataUtil;
import com.alipay.henry.demo.util.ExcelUtil;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.lang.reflect.Field;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * @author Henry
 * @version $Id: PageController.java, v 0.1 2018-07-29 下午3:54 Henry Exp $$
 */
@Controller
public class PageController {

    @Resource
    private GxyMapper gxyMapper;

    public static final String[] TITLES = {"id","姓名","性别","出生日期","CKD病史","高血压病史","糖尿病病史","心脑血管病史",
                "SBP1","DBP1","SBP2","DBP2","SBP3","DBP3","动态血压","动态血压收缩压均值","动态血压舒张压均值",
                "动态血压日间收缩压均值","动态血压日间舒张压均值","动态血压夜间收缩压均值","动态血压夜间舒张压均值",
                "动态血压收缩压标准差","动态血压舒张压标准差","尿蛋白","24h尿蛋白定量","血尿","尿沉渣红细胞数",
                "血常规血红素","血常规白细胞数","血常规中性细胞数","血常规血小板","血肌酐","血红蛋白","iPTH","血钙",
                "血磷","头颅CT脑梗塞","心脏彩超","IVS房间隔","左房大小","左室大小","室间隔厚度","左室后壁厚度","射血分数","瓣膜坏死"};

    /**
     * for home page
     * @param model
     * @return
     */
    @GetMapping("/test")
    public String homePage(Model model) {
        model.addAttribute("title","title=hello gxy");
        return "gxy";
    }


    @PostMapping("/fillForm")
    public String handleGxy(@RequestParam Map<String, String> body,Model model) {
        String msg = "success";
        String id = null;
        try {
            GxyDO gxyDO = convertToGxyDO(body);
            gxyMapper.insert(gxyDO);
            id = gxyDO.getId();
        } catch (Exception e) {
            msg = e.toString();
        }
        model.addAttribute("id",id);
        model.addAttribute("result", msg);
        return "result";
    }

    @PostMapping("/upload")
    public String  fileUpload2(@RequestParam("id") String id,
                               @RequestParam MultipartFile file,
                               Model model) throws IOException {
        String msg = "success";

        try {
            if(id==null) {
                id = String.valueOf(System.currentTimeMillis());
            }
            String path="/root/ftp/" + id + "_" + file.getOriginalFilename();

            File newFile=new File(path);
            //通过CommonsMultipartFile的方法直接写文件（注意这个时候）
            file.transferTo(newFile);
        } catch (Exception e) {
            msg = e.toString();
        }
        model.addAttribute("result", msg);
        return "result2";
    }

    @GetMapping("/yf")
    public String hack(HttpServletRequest request,Model model) {
        String msg = null;

        String id = request.getParameter("id");
        String name = request.getParameter("name");
        msg = id+"_"+ name +"\r\n";
        if(id==null && name==null) {
            msg += "id和name为空";
            model.addAttribute("result",msg);
            return "hack";
        }
        List<GxyDO> gxyDOList = null;
        if(id!=null) {
            gxyDOList = gxyMapper.selectById(id);
        } else if(name!=null) {
            gxyDOList = gxyMapper.selectByName(name);
        }
        if(gxyDOList==null || gxyDOList.size()==0) {
            msg += "notfound";
            model.addAttribute("result",msg);
            return "hack";
        }
        msg += JSON.toJSONString(gxyDOList);
        model.addAttribute("result",msg);
        return "hack";
    }


    /**
     * 导出excel
     * @param request
     * @param response
     * @param model
     * @return
     */
    @RequestMapping(value="/download",produces = {"application/vnd.ms-excel;charset=UTF-8"})
    public String download(HttpServletRequest request, HttpServletResponse response, Model model) {
        String msg = null;
        try {
            String id = request.getParameter("id");
            String name = request.getParameter("name");
            if(id==null && name==null) {
                return "notfound";
            }
            List<GxyDO> gxyDOList = null;
            if(id!=null) {
                gxyDOList = gxyMapper.selectById(id);
            } else if(name!=null) {
                gxyDOList = gxyMapper.selectByName(name);
            }
            if(gxyDOList==null || gxyDOList.size()==0) {
                return "notfound";
            }
            name = gxyDOList.get(0).getName();
            HSSFWorkbook hssfWorkbook = exportExcel(id, name, gxyDOList);
            if(hssfWorkbook==null) {
                return "notfound";
            }
            ByteArrayOutputStream os = new ByteArrayOutputStream();
            try {
                hssfWorkbook.write(os);
            } catch (IOException e) {
                e.printStackTrace();
            }
            String fileName = name+"_"+id;
            byte[] content = os.toByteArray();
            InputStream is = new ByteArrayInputStream(content);
            // 设置response参数，可以打开下载页面
            response.reset();
            response.setContentType("application/vnd.ms-excel;charset=utf-8");
            response.setHeader("Content-Disposition", "attachment;filename="+ new String((fileName + ".xls").getBytes(), "iso-8859-1"));
            ServletOutputStream out = response.getOutputStream();
            BufferedInputStream bis = null;
            BufferedOutputStream bos = null;
            try {
                bis = new BufferedInputStream(is);
                bos = new BufferedOutputStream(out);
                byte[] buff = new byte[2048];
                int bytesRead;
                // Simple read/write loop.
                while (-1 != (bytesRead = bis.read(buff, 0, buff.length))) {
                    bos.write(buff, 0, bytesRead);
                }
            } catch (final IOException e) {
                throw e;
            } finally {
                if (bis != null)
                    bis.close();
                if (bos != null)
                    bos.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
            msg = e.toString();
        }
        model.addAttribute("result", msg);

        return msg==null?null:"error";
    }


    /**
     * 导出excel
     * @param id
     * @param name
     * @param gxyDOList
     */
    private HSSFWorkbook exportExcel(String id, String name, List<GxyDO> gxyDOList) {

        String sheetName = "高血压项目";

        String[][] content = generateExcelValues(gxyDOList);
        return ExcelUtil.getHSSFWorkbook(sheetName, TITLES, content, null);

    }

    /**
     *
     * @param gxyDOList
     * @return
     */
    private String[][] generateExcelValues(List<GxyDO> gxyDOList) {
        if(gxyDOList==null||gxyDOList.size()==0) {
            return null;
        }
        String[][] values = new String[gxyDOList.size()][TITLES.length];
        for(int i=0;i<gxyDOList.size();i++) {
            int j = 0;
            GxyDO gxyDO = gxyDOList.get(i);
            values[i][j++] = gxyDO.getId();
            values[i][j++] = gxyDO.getName();
            values[i][j++] = gxyDO.getGender()==1?"男":"女";
            values[i][j++] = DataUtil.format(gxyDO.getBirthday());
            values[i][j++] = DataUtil.format(gxyDO.getCkdDate());
            values[i][j++] = getRadioValue(gxyDO.getGxy());
            values[i][j++] = getRadioValue(gxyDO.getTnb());
            values[i][j++] = getRadioValue(gxyDO.getXhdb());
            values[i][j++] = gxyDO.getSbp1();
            values[i][j++] = gxyDO.getDbp1();
            values[i][j++] = gxyDO.getSbp2();
            values[i][j++] = gxyDO.getDbp2();
            values[i][j++] = gxyDO.getSbp3();
            values[i][j++] = gxyDO.getDbp3();
            values[i][j++] = getRadioValue(gxyDO.getDtxy());
            values[i][j++] = String.valueOf(gxyDO.getAvgSsy());
            values[i][j++] = String.valueOf(gxyDO.getAvgSzy());
            values[i][j++] = String.valueOf(gxyDO.getAvgSsyDay());
            values[i][j++] = String.valueOf(gxyDO.getAvgSzyDay());
            values[i][j++] = String.valueOf(gxyDO.getAvgSsyNight());
            values[i][j++] = String.valueOf(gxyDO.getAvgSzyNight());
            values[i][j++] = String.valueOf(gxyDO.getStdSsy());
            values[i][j++] = String.valueOf(gxyDO.getStdSzy());
            values[i][j++] = getRadioValue(gxyDO.getNdb());
            values[i][j++] = String.valueOf(gxyDO.getNdb24h());
            values[i][j++] = getRadioValue(gxyDO.getHasBloodN());
            values[i][j++] = String.valueOf(gxyDO.getNczRed());
            values[i][j++] = String.valueOf(gxyDO.getXhs());
            values[i][j++] = String.valueOf(gxyDO.getWhiteCellCount());
            values[i][j++] = String.valueOf(gxyDO.getMidCellCount());
            values[i][j++] = String.valueOf(gxyDO.getXxbCount());
            values[i][j++] = String.valueOf(gxyDO.getXj());
            values[i][j++] = String.valueOf(gxyDO.getXhdb());
            values[i][j++] = String.valueOf(gxyDO.getIpth());
            values[i][j++] = String.valueOf(gxyDO.getBloodG());
            values[i][j++] = String.valueOf(gxyDO.getBloodL());
            values[i][j++] = getRadioValue(gxyDO.getCtgs());
            values[i][j++] = String.valueOf(gxyDO.getXzcc());
            values[i][j++] = String.valueOf(gxyDO.getIvsFjg());
            values[i][j++] = String.valueOf(gxyDO.getZfdx());
            values[i][j++] = String.valueOf(gxyDO.getZsdx());
            values[i][j++] = String.valueOf(gxyDO.getSjghd());
            values[i][j++] = String.valueOf(gxyDO.getZshbhd());
            values[i][j++] = String.valueOf(gxyDO.getSxfs());
            values[i][j++] = getRadioValue(gxyDO.getBmhs());
        }
        return values;
    }

    /**
     *
     * @param value
     * @return
     */
    private String getRadioValue(int value) {
        return value==1?"Y":"N";
    }


    private GxyDO convertToGxyDO(Map<String, String> body) {
        GxyDO gxyDO = new GxyDO();

        try {
            Field[] fileds = GxyDO.class.getDeclaredFields();
            for(Field field:fileds) {
                String name = field.getName();
                Object value = parseValue(field.getType(), name, body);
                if(value==null) {
                    continue;
                }
                field.setAccessible(true);
                field.set(gxyDO,value);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        gxyDO.setId(String.valueOf(System.currentTimeMillis()));
        return gxyDO;
    }


    private Object parseValue(Class type, String name, Map<String,String> body) throws ParseException {
        String obj = body.get(name);
        if(obj==null||obj.equals("")) {
            return null;
        }
        obj = obj.trim();
        if("gender".equals(name)) {
            return "男".equals(obj)?1:0;
        }
        if("birthday".equals(name) || "ckdDate".equals(name)) {
            return parseDate(obj);
        }
        if(type == Integer.TYPE) {
            return Integer.parseInt(obj);
        }
        if(type == Double.TYPE) {
            return Double.parseDouble(obj);
        }
        return obj;
    }

    private Date parseDate(String obj) throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        return sdf.parse(obj);
    }

}