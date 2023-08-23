package com.crud.projectcrud.service;

import com.crud.projectcrud.repository.InfoAlunosRepository;
import com.crud.projectcrud.interfaceservice.InfoAlunosInterfServ;
import com.crud.projectcrud.model.InfoAlunos;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class InfoAlunosService implements InfoAlunosInterfServ {

    @Autowired
    private InfoAlunosRepository data;

    @Override
    public List<InfoAlunos> listar() {
        return (List<InfoAlunos>) data.findAll();
    }

    @Override
    public Optional<InfoAlunos> listarPeloId(Integer matricula) {
        return (Optional<InfoAlunos>) data.findById(matricula);
    }
}
