package com.crud.projectcrud.service;

import com.crud.projectcrud.repository.CursoRepository;
import com.crud.projectcrud.interfaceservice.CursoInterfSer;
import com.crud.projectcrud.model.Curso;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CursoService implements CursoInterfSer {

    @Autowired
    private CursoRepository data;

    @Override
    public List<Curso> listar() {
        return (List<Curso>) data.findAll();
    }
}
