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
            asistente.setCurp(r.getCell(0).getStringCellValue());
            asistente.setNombre(r.getCell(1).getStringCellValue());
            asistente.setApellidoPaterno(r.getCell(2).getStringCellValue());
            asistente.setApellidoMaterno(r.getCell(3).getStringCellValue());
            asistente.setSexo(r.getCell(4).getStringCellValue());
            asistente.setCalle(r.getCell(5).getStringCellValue());
            asistente.setNumeroExt(r.getCell(6).getStringCellValue());
            asistente.setNumeroInt(r.getCell(7).getStringCellValue());
            asistente.setCodigo(r.getCell(8).getStringCellValue());
            asistente.setColonia(r.getCell(9).getStringCellValue());
            asistente.setMunicipio(r.getCell(10).getStringCellValue());
            asistente.setEstado(r.getCell(11).getStringCellValue());
            asistente.setTelefonoCasa(r.getCell(12).getStringCellValue());
            asistente.setTelefonoCelular(r.getCell(13).getStringCellValue());


            asistenteDao.save(asistente);
        }

        return true;
    }

    public Asistente getAsistenteByCurp(String curp){
        return asistenteDao.findByCurp(curp);
    }
}
