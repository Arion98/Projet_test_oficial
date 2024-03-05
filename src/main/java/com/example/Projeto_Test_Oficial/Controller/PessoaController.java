package com.example.Projeto_Test_Oficial.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.example.Projeto_Test_Oficial.Model.Pessoa;
import com.example.Projeto_Test_Oficial.Model.Cargo;
import com.example.Projeto_Test_Oficial.Repository.CargoRepository;
import com.example.Projeto_Test_Oficial.Repository.PessoaRepository;

import java.util.List;
import java.util.Optional;

@Controller
public class PessoaController {

    @Autowired
    private PessoaRepository pr;

    @Autowired
    private CargoRepository cr;

    @GetMapping("pessoa/criar")
    public String criar() {
        return "pessoa/criar";
    }

    @GetMapping("pessoa/alterar")
    public String alterar() {
        return "pessoa/alterar"; 
    }

    @PostMapping("pessoa/criar")
    public String criar(Pessoa pessoa) {
        
        Cargo cargo = cr.getReferenceById(Long.parseLong("1"));
        Cargo cargos = cr.getReferenceById(Long.parseLong("2"));
        pessoa.addCargos(cargo);
        pessoa.addCargos(cargos);
        pr.save(pessoa);
        return "redirect:/agendar/pedido";
    }


    @GetMapping("pessoa/listar")
    public ModelAndView listarPessoa(){
        ModelAndView view = new ModelAndView("pessoa/listar");
        List<Pessoa> pessoas = pr.findByativo(true); 
        Long quantidadePessoas = pr.count();

        view.addObject("pessoas", pessoas);
        return view; 
    }
    
    @GetMapping("pessoa/alterar/{id}")
    public ModelAndView alterar(@PathVariable Long id){
        ModelAndView view = new ModelAndView("pessoa/alterar");
        Optional<Pessoa> pessoa = pr.findById(id);
    
        view.addObject("pessoa", pessoa);
        view.addObject("id", id);
    
        return view; 
    }

     @PostMapping("pessoa/alterar/{id}")
     public String alterar(@PathVariable Long id, Pessoa pessoa){
         this.pr.save(pessoa);
         return "redirect:/pessoa/listar";
     }
    
    @GetMapping("pessoa/deletar/{id}")
    public String deletar(@PathVariable Long id){
        
        Optional<Pessoa> pessoa = this.pr.findById(id);
        Pessoa PessoaModel = pessoa.get();
        
        PessoaModel.setAtivo(false);
        pr.save(PessoaModel);
        return "pessoa/deletar/{id}";
    }

}
