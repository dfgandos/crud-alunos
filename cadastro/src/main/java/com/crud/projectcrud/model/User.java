package com.crud.projectcrud.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import javax.persistence.*;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "user")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(nullable = false, length = 25)
    private String nome;

    @Column(nullable = false, length = 35)
    private String email;

    @Column(nullable = false, length = 64)
    private String senha;

    @Column(nullable = false, name = "ativo")
    private boolean ativo;
    public void setSenha(String senha) {
        BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
        bCryptPasswordEncoder.encode(senha);
        this.senha = bCryptPasswordEncoder.encode(senha);
    }
    public void setAtivo(boolean ativo) {
        this.ativo = ativo;
    }
}
