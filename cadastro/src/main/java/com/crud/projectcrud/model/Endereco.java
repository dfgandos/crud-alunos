package com.crud.projectcrud.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "endereco")
public class Endereco {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private Integer cep;
    private String uf;
    private String cidade;
    private String bairro;
    private String rua;
    private Integer numero;
    private String complemento;

    @OneToMany(mappedBy = "endereco", cascade= {CascadeType.ALL}, fetch=FetchType.EAGER)
    private List<InfoAlunos> alunos;
}
