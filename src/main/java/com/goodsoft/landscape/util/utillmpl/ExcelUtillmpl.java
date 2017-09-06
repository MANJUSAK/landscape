package com.goodsoft.landscape.util.utillmpl;

import com.goodsoft.landscape.entity.device.DrivingRecord;
import com.goodsoft.landscape.entity.device.MechanicalEQ;
import com.goodsoft.landscape.template.TemplatePath;
import com.goodsoft.landscape.util.ExcelUtil;
import org.apache.log4j.Logger;
import org.apache.poi.hssf.util.HSSFColor;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.xssf.usermodel.*;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.nio.channels.FileChannel;
import java.util.List;

/**
 * function 创建excel表格工具类
 * 将表单数据写入excel表格中
 * Created by 严彬荣 on 2017/7/27.
 */
@SuppressWarnings("ALL")
@Service
public class ExcelUtillmpl implements ExcelUtil {

    //实例化UUID工具类
    private UUIDUtil uuid = UUIDUtil.getInstance();
    //实例化日志管理类
    private Logger logger = Logger.getLogger(ExcelUtillmpl.class);
    //实例化模板文件路径工具类
    private TemplatePath templatePath = TemplatePath.getInstance();

    /**
     * function 将表单数据写入excel表格中
     *
     * @return String 文件存放数据库路径
     * @parameter request http请求，list 写入excel表数据，var 是否存在导出的excel文件路径
     */
    @Override
    public String writeExcel(HttpServletRequest request, List list, String excel) throws Exception {
        String rootPath = null;
        String tomcatPath = null;
        String arg = null;
        String arg1 = null;
        // 获取服务器存放路径
        rootPath = request.getSession().getServletContext().getRealPath("");
        // 截取文件存放服务器路径
        tomcatPath = rootPath.substring(0, rootPath.lastIndexOf("l"));
        // 创建Excel文件存放路径
        StringBuilder sb = new StringBuilder(tomcatPath);
        String var1 = "/file/excel/";
        sb.append(var1);
        //文件夹路径
        String str = sb.toString();
        File filePath = new File(str);
        if (!filePath.exists()) {
            filePath.mkdirs();
        }
        //创建表格路径
        String var2 = this.uuid.getUUID().toString();
        sb.append(var2);
        sb.append(".xlsx");
        arg = sb.toString();
        //存放数据库路径
        sb.delete(0, sb.length());
        sb.append(var1);
        sb.append(var2);
        sb.append(".xlsx");
        arg1 = sb.toString();
        //模板文件路径
        sb.delete(0, sb.length());
        sb.append(this.templatePath.getTemplatePath().toString());
        sb.append(excel);
        sb.append(".xlsx");
        String arg2 = sb.toString();
        File file = new File(arg2);
        //将模板文件复制到服务器
        FileChannel input = null;
        FileChannel output = null;
        input = new FileInputStream(file).getChannel();
        output = new FileOutputStream(arg).getChannel();
        input.transferTo(0, input.size(), output);
        output.close();
        input.close();
        //存放服务器文件
        File file1 = new File(arg);
        FileOutputStream ot = new FileOutputStream(file1);
        this.createExcel(file, list, excel).write(ot);
        ot.close();
        return arg1;
    }

    /**
     * function 创建excel表格
     * 将表单数据写入excel表格中
     *
     * @return XSSFXSSFWorkbook
     * @parameter data 写入到表格数据
     */
    private XSSFWorkbook createExcel(File file, List list, String excel) {
        return this.createHeaderStyle(file, list, excel);
    }

    /**
     * function 创建excel表头样式表格
     *
     * @return XSSFXSSFWorkbook
     * @parameter data 写入到表格数据
     */
    private XSSFWorkbook createHeaderStyle(File file, List list, String excel) {
        //创建excel文件
        XSSFWorkbook wb = null;
        try {
            wb = new XSSFWorkbook(new FileInputStream(file));
        } catch (Exception e) {
            e.printStackTrace();
        }
       /* XSSFCellStyle style = wb.createCellStyle();
        //水平居中
        style.setAlignment(XSSFCellStyle.ALIGN_CENTER);
        //垂直居中
        style.setVerticalAlignment(XSSFCellStyle.VERTICAL_CENTER);
        //设置单元格背景颜色
        style.setFillForegroundColor(IndexedColors.GREY_25_PERCENT.getIndex());
        style.setFillPattern(XSSFCellStyle.SOLID_FOREGROUND);
        //设置上下左右边框
        style.setBorderBottom(XSSFCellStyle.BORDER_THIN);
        style.setBorderTop(XSSFCellStyle.BORDER_THIN);
        style.setBorderRight(XSSFCellStyle.BORDER_THIN);
        style.setBorderLeft(XSSFCellStyle.BORDER_THIN);
        // 自动换行
        style.setWrapText(true);
        XSSFFont font = wb.createFont();
        // 设置字体颜色
        font.setColor(HSSFColor.BLACK.index);
        // 设置字体样式
        font.setFontName("微软雅黑");
        // 设置字体大小
        font.setFontHeightInPoints((short) 12);
        // 设置字体粗细
        font.setBoldweight(XSSFFont.BOLDWEIGHT_BOLD);
        // 把字体应用到当前的样式中
        style.setFont(font);*/
        return this.writeHeaderCellExcel(wb, list, excel);
    }

    /**
     * function 创建excel表头单元格
     * 将表单数据写入excel表格中
     *
     * @return XSSFXSSFWorkbook
     * @parameter wb 表属性，style 表样式，data 写入到表格数据
     */
    private XSSFWorkbook writeHeaderCellExcel(XSSFWorkbook wb, List list, String excel) {
        /*//创建一张excel表
        XSSFSheet sheet = wb.createSheet("表1");
        //设置列宽
        sheet.setDefaultColumnWidth(20);
        //创建表头
        XSSFRow row = sheet.createRow(0);
        //设置行高
        row.setHeight((short) (16 * 25));
        // 创建表头单元格
        XSSFCell cell = null;
        for (int i = 0; i < 15; ++i) {
            cell = row.createCell(i);
            cell.setCellValue("单元格" + (1 + i));
            cell.setCellStyle(style);
        }*/
        //获取一张excel表
        XSSFSheet sheet = wb.getSheetAt(0);
        return this.createCellStyle(wb, sheet, list, excel);
    }

    /**
     * function 创建excel单元格样式
     * 将表单数据写入excel表格中
     *
     * @return XSSFXSSFWorkbook
     * @parameter wb 表属性，sheet 表，data 写入到表格数据
     */
    private XSSFWorkbook createCellStyle(XSSFWorkbook wb, XSSFSheet sheet, List list, String excel) {
        XSSFCellStyle style = wb.createCellStyle();
        //水平居中
        style.setAlignment(XSSFCellStyle.ALIGN_CENTER);
        //垂直居中
        style.setVerticalAlignment(XSSFCellStyle.VERTICAL_CENTER);
        //设置上下左右边框
        style.setBorderBottom(XSSFCellStyle.BORDER_THIN);
        style.setBorderTop(XSSFCellStyle.BORDER_THIN);
        style.setBorderRight(XSSFCellStyle.BORDER_THIN);
        style.setBorderLeft(XSSFCellStyle.BORDER_THIN);
        //设置自动换行
        //style.setWrapText(true);
        Font font = wb.createFont();
        // 设置字体颜色
        font.setColor(HSSFColor.BLACK.index);
        // 设置字体样式
        font.setFontName("微软雅黑");
        // 设置字体大小
        font.setFontHeightInPoints((short) 11);
        // 设置字体粗细
        font.setBoldweight(XSSFFont.BOLDWEIGHT_NORMAL);
        // 把字体应用到当前的样式中
        style.setFont(font);
        switch (excel) {
            case "mechanical":
                return this.mechanical(wb, sheet, style, list);
            case "drive":
                return this.drivingRecord(wb, sheet, style, list);
            default:
                return null;
        }

    }

    /**
     * function 创建机械设备excel单元格内容
     * 将表单数据写入excel表格中
     *
     * @return XSSFXSSFWorkbook
     * @parameter wb 表属性，sheet 表，style 表样式，data 写入到表格数据
     */
    private XSSFWorkbook mechanical(XSSFWorkbook wb, XSSFSheet sheet, XSSFCellStyle style, List data) {
        List<MechanicalEQ> list = data;
        for (int i = 0, length = list.size(); i < length; ++i) {
            XSSFRow row = sheet.createRow(2 + i);
            // 创建表内容单元格
            XSSFCell cell = null;
            cell = row.createCell(0);
            cell.setCellValue((1 + i));
            cell.setCellStyle(style);
            cell = row.createCell(1);
            cell.setCellValue(list.get(i).getCarId());
            cell.setCellStyle(style);
            cell = row.createCell(2);
            cell.setCellValue(list.get(i).getEngineId());
            cell.setCellStyle(style);
            cell = row.createCell(3);
            cell.setCellValue(list.get(i).getVin());
            cell.setCellStyle(style);
            cell = row.createCell(4);
            cell.setCellValue(list.get(i).getRegisterDate());
            cell.setCellStyle(style);
            cell = row.createCell(5);
            cell.setCellValue(list.get(i).getCheckDate());
            cell.setCellStyle(style);
            cell = row.createCell(6);
            cell.setCellValue(list.get(i).getInsuranceDate());
            cell.setCellStyle(style);
            cell = row.createCell(7);
            cell.setCellValue(list.get(i).getCompany());
            cell.setCellStyle(style);
            cell = row.createCell(8);
            cell.setCellValue(list.get(i).getComment());
            cell.setCellStyle(style);

        }
        return wb;
    }

    /**
     * function 创建行车记录excel单元格内容
     * 将表单数据写入excel表格中
     *
     * @return XSSFXSSFWorkbook
     * @parameter wb 表属性，sheet 表，style 表样式，data 写入到表格数据
     */
    private XSSFWorkbook drivingRecord(XSSFWorkbook wb, XSSFSheet sheet, XSSFCellStyle style, List data) {
        List<DrivingRecord> list = data;
        for (int i = 0, length = list.size(); i < length; ++i) {
            XSSFRow row = sheet.createRow(2 + i);
            // 创建表内容单元格
            XSSFCell cell = null;
            cell = row.createCell(0);
            cell.setCellValue((1 + i));
            cell.setCellStyle(style);
            cell = row.createCell(1);
            cell.setCellValue(list.get(i).getCarId());
            cell.setCellStyle(style);
            cell = row.createCell(2);
            cell.setCellValue(list.get(i).getDriverName());
            cell.setCellStyle(style);
            cell = row.createCell(3);
            cell.setCellValue(list.get(i).getWkStartingPoint());
            cell.setCellStyle(style);
            cell = row.createCell(4);
            cell.setCellValue(list.get(i).getWkEnd());
            cell.setCellStyle(style);
            cell = row.createCell(5);
            cell.setCellValue(list.get(i).getWorkTime());
            cell.setCellStyle(style);
        }
        return wb;
    }
}
