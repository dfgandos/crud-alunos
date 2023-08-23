package com.crud.projectcrud.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.sql.Date;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "info_alunos")
public class InfoAlunos {

    public String format(String c, boolean mascara){
        if (mascara){
            return (c.substring(0,3) + "." + c.substring(3,5) + "." + c.substring(5,8) + "-" + c.substring(8,10));
        } else{
            c = c.replace(".","");
            c = c.replace("-","");
            return c;
        }
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer matricula;

    private String cpf;
    private String email;
    private String nome;
    private String sexo;

    @JoinColumn(name = "data_nasc")
    private Date dataNasc;

    @ManyToOne
    @JoinColumn(name = "curso_id")
    private Curso curso;

    @ManyToOne
    @JoinColumn(name = "periodo_id")
    private Periodo periodo;

    @ManyToOne
    @JoinColumn(name = "endereco_id")
    private Endereco endereco;
}

