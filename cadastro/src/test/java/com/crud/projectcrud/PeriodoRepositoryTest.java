package com.crud.projectcrud;

import com.crud.projectcrud.model.Periodo;
import com.crud.projectcrud.repository.PeriodoRepository;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.annotation.Rollback;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@Rollback(value = false)
class PeriodoRepositoryTest {

    @Autowired
    private PeriodoRepository repo;

    @Autowired
    private TestEntityManager entityManager;

    @Test
    void TestCreatedPeriodo(){
        Periodo periodo = new Periodo();

        periodo.setPeriodo("Primeiro");

        Periodo savedPeriodo = repo.save(periodo);

        Periodo existPeriodo = entityManager.find(Periodo.class, savedPeriodo.getId());

        assert(existPeriodo.getPeriodo().equals(periodo.getPeriodo()));
    }

}
