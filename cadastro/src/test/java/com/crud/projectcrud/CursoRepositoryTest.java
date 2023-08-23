package com.crud.projectcrud;

import com.crud.projectcrud.model.Curso;
import com.crud.projectcrud.repository.CursoRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.annotation.Rollback;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@Rollback(value = false)
class CursoRepositoryTest {

    @Autowired
    private CursoRepository repo;

    @Autowired
    private TestEntityManager testEntityManager;

    @Test
    void testCreateCurso(){
        Curso curso = new Curso();
        curso.setNome("Ciências da Computação");

        Curso savedCurso = repo.save(curso);

        Curso existCurso = testEntityManager.find(Curso.class, savedCurso.getId());

        assert(existCurso.getNome().equals(curso.getNome()));
    }

}
