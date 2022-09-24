package com.dglg.spring;


import com.dglg.spring.model.User;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.stereotype.Component;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

@Component
public class ImportExcelUtils {
    // 将表格中的数据添加到List集合中
    public static List<User> upload(String fileName, InputStream is) throws Exception{
        Workbook workbook = getWorkbook(fileName,is);
        List<User> piLList = new ArrayList<>();
        int number = workbook.getNumberOfSheets(); // 获取sheet值
        for (int i = 0; i < number; i++) {
            Sheet sheet = workbook.getSheetAt(i); // 获取表格页码
            if (sheet != null){
                int rowNum = sheet.getLastRowNum(); // 获取该页表共有多少行
                for (int j = 1; j <= rowNum; j++) {  // 一般来说第一行是标题,所以第二行开始读取
                    Row row = sheet.getRow(j); // 获取表格行
                    User piL = new User();
                    row.getCell(0).setCellType(Cell.CELL_TYPE_STRING); // 将该单元格获取出来的值设为String类型
                    piL.setStudent_id(row.getCell(0).getStringCellValue());
                    row.getCell(1).setCellType(Cell.CELL_TYPE_STRING);
                    piL.setStudent_name(row.getCell(1).getStringCellValue());
                    row.getCell(2).setCellType(Cell.CELL_TYPE_STRING);
                    piL.setGender(row.getCell(2).getStringCellValue());
                    row.getCell(3).setCellType(Cell.CELL_TYPE_STRING);
                    piL.setGrade(row.getCell(3).getStringCellValue());
                    row.getCell(4).setCellType(Cell.CELL_TYPE_STRING);
                    piL.setBanji(row.getCell(4).getStringCellValue());
                    row.getCell(5).setCellType(Cell.CELL_TYPE_STRING);
                    piL.setMajor(row.getCell(5).getStringCellValue());
                    piLList.add(piL);
                }
            }
        }
        System.out.println(piLList.toString());
        return piLList;
    }
    // 判断传入的文件是哪种类型的excel文件
    public static Workbook getWorkbook(String fileName,InputStream is) throws Exception{
        Workbook workbook = null;
        String name = fileName.substring(fileName.lastIndexOf("."));
        System.out.println(name);
        if (".xls".equals(name)){
            workbook = new HSSFWorkbook(is);
        }else if (".xlsx".equals(name)){
            workbook = new XSSFWorkbook(is);
        }else {
            throw new Exception(" 请上传.xls/.xlsx格式文件！");
        }
        return workbook;
    }
}
