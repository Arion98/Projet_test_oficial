package com.example.Projeto_Test_Oficial.Model;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table (name = "Pedido")
public class Pedido {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    
    @Column(name = "nome", nullable = true, length = 250)
    private String nome;

    @Column(name = "valor", nullable = true, length = 4)
    private float valor;

    @Column(name = "data")
    private LocalDate data;

    @Column(name = "texto", nullable = true, length = 250)
    private String texto;
    
    public String getNome(){
        return this.nome;
    }

    public void setNome( String nome){
        this.nome = nome;
    }

    public float getValor(){
        return valor;
    }

    public void setValor( float valor){
        this.valor = valor;
    }

    public LocalDate getData() {
        return data;
    }

    public void setData(LocalDate data) {
        this.data = data;
    }

    public String getTexto(){
        return texto;
    }

    public void setTexto( String texto){
        this.texto = texto;
    }
}
