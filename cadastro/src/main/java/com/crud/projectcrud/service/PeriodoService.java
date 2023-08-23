package com.crud.projectcrud.service;


import com.crud.projectcrud.repository.PeriodoRepository;
import com.crud.projectcrud.interfaceservice.PeriodoInterfServ;
import com.crud.projectcrud.model.Periodo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PeriodoService implements PeriodoInterfServ {

    @Autowired
    private PeriodoRepository data;

    @Override
    public List<Periodo> listar() {
        return (List<Periodo>) data.findAll();
    }
}
