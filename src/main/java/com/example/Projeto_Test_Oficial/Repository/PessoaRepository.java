package com.example.Projeto_Test_Oficial.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Repository;

import com.example.Projeto_Test_Oficial.Model.Pessoa;

import java.util.List;

@Repository
public interface PessoaRepository extends JpaRepository<Pessoa, Long> {

    @Override
    @NonNull
    List<Pessoa> findAll();
    List<Pessoa> findByativo (boolean ativo);
}
