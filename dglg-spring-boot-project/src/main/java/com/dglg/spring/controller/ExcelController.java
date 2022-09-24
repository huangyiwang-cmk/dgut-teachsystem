package com.dglg.spring.controller;


import com.dglg.spring.dao.ExcelDao;
import com.dglg.spring.model.Student;
import com.dglg.spring.model.User;
import com.dglg.spring.service.ExcelService;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


@RestController
@RequestMapping("/student")
public class ExcelController {

    List<Student> list = new ArrayList<>();
    @Autowired
    private ExcelService excelService;
    @Autowired
    private ExcelDao excelDao;
//    Student student = new Student();

    @PostMapping("/import")
    public String importExcel(@RequestParam("file") MultipartFile file) throws IOException {
        HSSFWorkbook workbook = new HSSFWorkbook(file.getInputStream());  // excel文件转成wb对象
        Sheet sheet = workbook.getSheetAt(0);
        Row title = sheet.getRow(0);
        String[] templates = {"student_id", "student_name", "gender", "grade", "class", "major"};
        for (int i = 0; i < title.getPhysicalNumberOfCells(); i++) {
            if (!templates[i].equals(title.getCell(i).getStringCellValue())) {
                return "数据模板不匹配，请重新下载模板！";
            }
        }
        int rowNum = sheet.getPhysicalNumberOfRows();
        Row row = null;
        for (int i = 1; i < rowNum; i++) {
            Student student = new Student();
            row = sheet.getRow(i);
            for (int j = 0; j < row.getPhysicalNumberOfCells(); j++) {
                Cell cell = row.getCell(j);
                student = excelService.student(j, String.valueOf(cell),student);
//                System.out.println(student);

            }
            list.add(student);
        }
        String result = null;

        result = String.valueOf(excelDao.addStudent(list));
//        System.out.println(list);

        return result;
    }


//    private User mapperUser(int i, String value) {
//        User user = new User();
//        switch (i) {
//            case 0:
//                user.setStudent_id(value);
//                break;
//            case 1:
//                user.setStudent_name(value);
//                break;
//            case 2:
//                user.setGender(value);
//                break;
//            case 3:
//                user.setStudent_id(value);
//                break;
//            case 4:
//                user.setStudent_id(value);
//                break;
//            case 5:
//                user.setStudent_id(value);
//                break;
//            default:user = null;
//
//        }
//
//
//        return user;
//    }

//
//                int batchInsert(List<Student> list);
//
//                <insert>
//                    insert into table(stuNum,name,sex,....) values
//                    <foreach collections="list" item="user" seperator=",">
//
//                             (#{user.num}, 菜菜, 女, ....)
//                    </foreach>
//                </insert>
}
