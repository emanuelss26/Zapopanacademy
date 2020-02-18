package com.zapopan.academy.empleados.controllers;

import com.zapopan.academy.empleados.entities.Asistente;
import com.zapopan.academy.empleados.services.ImportacionService;
import javassist.tools.web.BadHttpRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.io.InputStream;


@RestController
@RequestMapping(value="/upload")
public class ImportacionExcelController {

    @Autowired
    private ImportacionService importacionService;

    @RequestMapping(value = "/excel", method = RequestMethod.POST)
    public void uploadExcelFile(MultipartFile multipartFile) throws IOException, BadHttpRequest {
        InputStream in = multipartFile.getInputStream();
        if (!importacionService.uploadAndPersistExcelFile(in)){
            throw new BadHttpRequest();
        }
    }

    @RequestMapping(value = "/asistente/{curp}", method = RequestMethod.GET)
    public Asistente getAsistente(@RequestParam String curp){
        return importacionService.getAsistenteByCurp(curp);
    }
}