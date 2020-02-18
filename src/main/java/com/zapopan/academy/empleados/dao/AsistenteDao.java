package com.zapopan.academy.empleados.dao;

import com.zapopan.academy.empleados.entities.Asistente;
import org.springframework.data.repository.CrudRepository;

public interface AsistenteDao extends CrudRepository<Asistente, Integer> {
    Asistente findByCurp(String curp);
    Asistente findByApellidoMaternoAndAndApellidoPaterno(String apellidoMaterno, String apellidoPaterno);

}
