package com.example.Projeto_Test_Oficial.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.Projeto_Test_Oficial.Model.Pedido;
import com.example.Projeto_Test_Oficial.Repository.PedidoRepository;


@Controller
public class PedidoController {
    @Autowired
    private PedidoRepository pr;

    @GetMapping("agendar/pedido")
    public String criar(){
        return "agendar/pedido";
    }

    @PostMapping("agendar/pedido")
    public String criar(Pedido pedido){
        pr.save(pedido);
        return "agendar/pedido"; 
    }
}
