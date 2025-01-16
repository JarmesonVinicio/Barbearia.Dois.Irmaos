
package com.barbearia.BarbeariaDoisIrmaos.controller;

import com.barbearia.BarbeariaDoisIrmaos.model.Estoque;
import com.barbearia.BarbeariaDoisIrmaos.service.EstoqueService;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class EstoqueController {
    
    @Autowired
    private EstoqueService estoqueService;
       
    
    @GetMapping("/home") //se o usuário digitar /inicio também é redirecionado para o menu iniciar
    public String home(){
        return "index";
    }
    
    @GetMapping("/cadastrar-produtos") //missão é chamar o formulário
    public String cadastre(Model model){
        model.addAttribute("estoque", new Estoque()); //criando um objeto de estoque(Estoque) vazio com seus atributos e jogando para a model.
        return "cadastroProdutos"; //procurar pelo HTML com nome de: cadastroProdutos
    }
    
    @PostMapping("/gravar-produtos")
    public String processarFormulario(@ModelAttribute Estoque estoque, Model model, @RequestParam String id){ //receber os dados do formulário e salva numa lista de produtos
        
        if(estoque.getId() != null){ //se for diferente de nulo, é pra editar
            double valorTotal = estoqueService.calcularValor(estoque.getQuantidade(), estoque.getPreco());
            estoque.setValor_total(valorTotal);
            estoqueService.atualizar(estoque.getId(), estoque);
        }
        else{ //se for nulo é pra cadastrar
            double valorTotal = estoqueService.calcularValor(estoque.getQuantidade(), estoque.getPreco());
            estoque.setValor_total(valorTotal);
            estoqueService.criar(estoque);
        }
        return "redirect:/listagem-produtos"; //chamar a listagem dos produtos salvos
    }
    
    @GetMapping("/listagem-produtos")
    public String listaForm(Model model){
        
        model.addAttribute("lista", estoqueService.buscarTodos());
        return "listagemProdutos";
    }
    
    @GetMapping("/alterar-produto")
    public String alterarProduto(Model model, @RequestParam String id){
        
        Integer idProduto = Integer.parseInt(id);
        model.addAttribute("estoque", estoqueService.buscarPorId(idProduto));
        return "cadastroProdutos";
    }
    
    @GetMapping("/excluir-produto")
    public String excluirProduto(Model model, @RequestParam String id){
        
        Integer idProduto = Integer.parseInt(id);
        estoqueService.excluir(idProduto);
        return "redirect:/listagem-produtos"; //chamar a listagem dos produtos salvos
    }
    
    @GetMapping("/exibir-produto") 
    public String mostrarDetalhes(@RequestParam String id, Model model) {
        
        Integer idProduto = Integer.parseInt(id);
        model.addAttribute("estoque", estoqueService.buscarPorId(idProduto));
        return "exibirProduto";
    }
    
    
    
}
