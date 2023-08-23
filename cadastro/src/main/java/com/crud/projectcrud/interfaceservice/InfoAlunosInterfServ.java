package com.crud.projectcrud.interfaceservice;

import com.crud.projectcrud.model.InfoAlunos;

import java.util.List;
import java.util.Optional;


public interface InfoAlunosInterfServ {

    public List<InfoAlunos> listar();
    public Optional<InfoAlunos> listarPeloId(Integer matricula);

}
