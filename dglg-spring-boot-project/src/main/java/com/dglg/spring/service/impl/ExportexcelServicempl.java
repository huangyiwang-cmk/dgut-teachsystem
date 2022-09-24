package com.dglg.spring.service.impl;

import com.dglg.spring.dao.ExcelexcelDao;
import com.dglg.spring.model.Exportexcel;
import com.dglg.spring.service.ExportexcelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ExportexcelServicempl implements ExportexcelService {

    @Autowired
    private ExcelexcelDao excelexcelDao;
    public List<Exportexcel> findAll(){
        return  excelexcelDao.finAll();
    }
}
