package com.example.Projeto_Test_Oficial.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.Projeto_Test_Oficial.Model.Pedido;


@Repository
public interface PedidoRepository extends JpaRepository<Pedido, Long> {


    
}