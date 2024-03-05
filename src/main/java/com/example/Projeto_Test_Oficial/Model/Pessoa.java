package com.example.Projeto_Test_Oficial.Model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

import java.util.ArrayList;
import java.util.Objects;

import org.hibernate.mapping.List;

@Entity
@Table (name = "pessoa")
public class Pessoa {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    
    @Column(name = "nome", nullable = true, length = 250)
    private String nome;

    @Column(name = "cpf", nullable = true, length = 15)
    private String cpf;
    
    @Column(name = "email", nullable = true, length = 250)
    private String email;

    @Column(name = "ativo", nullable = true, columnDefinition = "boolean default true")
    private boolean ativo = true;

    @Column(name = "texto", nullable = true, length = 250)
    private String texto;

    @ManyToMany
    private java.util.List<Cargo> cargos;

    public Pessoa(){
        this.cargos = new ArrayList<>();
    }
    
    public String getNome(){
        return this.nome;
    }

    public void setNome( String nome){
        this.nome = nome;
    }



    public String getCpf(){
        return cpf;
    }

    public void setCpf( String cpf){
        this.cpf = cpf;
    }



    public String getEmail(){
        return email;
    }

    public void setEmail( String email){
        this.email = email;
    }



    public String getTexto(){
        return texto;
    }

    public void setTexto( String texto){
        this.texto = texto;
    }



    public boolean isAtivo(){
        return this.ativo;
    }

    public void setAtivo (boolean ativo){
        this.ativo = ativo;
    }

    public Pessoa(Long id) {
        this.id = id;
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Pessoa id(Long id) {
        setId(id);
        return this;
    }

    public java.util.List<Cargo> getCargo(){
        return this.cargos;
    }

    public void addCargos (Cargo cargo){
        this.cargos.add(cargo);
    }

    // public Cargo getCargo (){
    //     return this.cargo;

    // }

    // public void setCargo(Cargo cargo) {
    //     this.cargo = cargo;
    // }


}
