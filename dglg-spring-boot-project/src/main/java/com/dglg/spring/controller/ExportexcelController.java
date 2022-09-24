package com.dglg.spring.controller;

import com.dglg.spring.model.Exportexcel;
import com.dglg.spring.service.ExportexcelService;
import org.apache.poi.hssf.usermodel.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
@RestController
public class ExportexcelController {
    @Autowired
    private ExportexcelService exportexcelService;
//    @RequestMapping(value = "UserExcelDownloads", method = RequestMethod.GET)
    @GetMapping(value = "/export")
    public void downloadAllClassmate(HttpServletResponse response) throws IOException {
        HSSFWorkbook workbook = new HSSFWorkbook();
        HSSFSheet sheet = workbook.createSheet("学生信息表");

        List<Exportexcel> cl = exportexcelService.findAll();

        String fileName = "userinf"  + ".xls";//设置要导出的文件的名字
        //新增数据行，并且设置单元格数据

        int rowNum = 1;

        String[] headers = { "student_id", "student_name","gender","grade","class","major"};
        //headers表示excel表中第一行的表头

        HSSFRow row = sheet.createRow(0);
        //在excel表中添加表头

        for(int i=0;i<headers.length;i++){
            HSSFCell cell = row.createCell(i);
            HSSFRichTextString text = new HSSFRichTextString(headers[i]);
            cell.setCellValue(text);
        }

        //在表中存放查询到的数据放入对应的列
        for (Exportexcel te : cl) {
            HSSFRow row1 = sheet.createRow(rowNum);
            row1.createCell(0).setCellValue(te.getstudent_id());
            row1.createCell(1).setCellValue(te.getstudent_name());
            row1.createCell(2).setCellValue(te.getgender());
            row1.createCell(3).setCellValue(te.getgrade());
            row1.createCell(4).setCellValue(te.getbanji());
            row1.createCell(5).setCellValue(te.getmajor());

            rowNum++;
        }

        response.setContentType("application/octet-stream");
        response.setHeader("Content-disposition", "attachment;filename=" + fileName);
        response.flushBuffer();
        workbook.write(response.getOutputStream());
    }
}
