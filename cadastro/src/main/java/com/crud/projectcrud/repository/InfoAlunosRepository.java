package com.crud.projectcrud.repository;

import com.crud.projectcrud.model.InfoAlunos;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;



@Repository
public interface InfoAlunosRepository extends JpaRepository<InfoAlunos, Integer> {

    List<InfoAlunos> findByNomeContains(String nome);

}
