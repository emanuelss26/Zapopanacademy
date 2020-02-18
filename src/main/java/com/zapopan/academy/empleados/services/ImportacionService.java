package com.zapopan.academy.empleados.services;

import com.zapopan.academy.empleados.dao.AsistenteDao;
import com.zapopan.academy.empleados.entities.Asistente;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.io.InputStream;

@Service
public class ImportacionService {

    @Autowired
    private AsistenteDao asistenteDao;

    public boolean uploadAndPersistExcelFile(InputStream inputStream) throws IOException {
        Workbook workbook = org.apache.poi.ss.usermodel.WorkbookFactory.create(inputStream);
        Sheet firstSheet = workbook.getSheetAt(0);

        int count = 1;

        for (Row r : firstSheet) {
            if (count == 1){
                count++;
                continue;
            }
            Asistente asistente = new Asistente();
            asistente.setNombre(r.getCell(0).getStringCellValue());
            asistente.setApellido_materno(r.getCell(1).getStringCellValue());
            asistente.setApellido_paterno(r.getCell(2).getStringCellValue());
            asistente.setCurp(r.getCell(3).getStringCellValue());

            asistenteDao.save(asistente);
        }

        return true;
    }

    public Asistente getAsistenteByCurp(String curp){
        return asistenteDao.findByCurp(curp);
    }
}
