
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
    
    private List<Estoque> listaProdutos = new ArrayList<>();
    
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
        if (estoque.getId() != null){ //se for diferente de nulo, ele atualiza
            for(Estoque e: listaProdutos){
            if(e.getId()== estoque.getId()){ //esse id se refere ao id hidden (campo invisível) do HTML estoque. 
                e.setNome(estoque.getNome()); //pega o que esta na variavel estoque(que veio do html) e atualiza na lista (e)
                e.setCategoria(estoque.getCategoria());
                e.setQuantidade(estoque.getQuantidade());
                e.setPreco(estoque.getPreco());
                
                
                
                double valorTotal = estoqueService.calcularValor(e.getQuantidade(), e.getPreco());
                model.addAttribute("valorTotal", valorTotal);
                e.setValor_total(valorTotal);
                
                
                
                e.setData_compra(estoque.getData_compra());
                e.setValidade(estoque.getValidade());
                e.setObservacao(estoque.getObservacao());
                
                break;
            }
        }
            
        }
        else{
            estoque.setId(listaProdutos.size() + 1); //adicionando ID
            
            double valorTotal = estoqueService.calcularValor(estoque.getQuantidade(), estoque.getPreco());
            estoque.setValor_total(valorTotal);
            
            
            listaProdutos.add(estoque); //INSERIR NA LISTA
        }
        return "redirect:/listagem-produtos"; //chamar a listagem dos produtos salvos
    }
    
    @GetMapping("/listagem-produtos")
    public String listaForm(Model model){
        
        model.addAttribute("lista", listaProdutos);
        return "listagemProdutos";
    }
    
    @GetMapping("/alterar-produto")
    public String alterarProduto(Model model, @RequestParam String id){
        
        Integer idProduto = Integer.parseInt(id);
        model.addAttribute("estoque", obtemProdutoPeloId(idProduto));
        return "cadastroProdutos";
    }
    
    @GetMapping("/excluir-produto")
    public String excluirProduto(Model model, @RequestParam String id){
        
        Integer idProduto = Integer.parseInt(id);
        listaProdutos.remove(obtemProdutoPeloId(idProduto));
        return "redirect:/listagem-produtos"; //chamar a listagem dos produtos salvos
    }
        
    public Estoque obtemProdutoPeloId(Integer idProduto){
        Estoque registroEncontrado = new Estoque();
        for(Estoque e: listaProdutos){
            if(e.getId()== idProduto){
                registroEncontrado = e;
                break;
            }
        }
        return registroEncontrado;
    }
    
    @Autowired
    private EstoqueService estoqueService;
    
    @GetMapping("/exibir-produto") 
    public String mostrarDetalhes(@RequestParam String id, Model model) {
        Integer idProduto = Integer.parseInt(id);
        Estoque registroEncontrado = obtemProdutoPeloId(idProduto);
        if (registroEncontrado != null) {
            model.addAttribute("estoque", registroEncontrado);
//            double valorTotal = estoqueService.calcularValor(registroEncontrado);
//            model.addAttribute("valorTotal", valorTotal);
        }
        return "exibirProduto";
    }
    
    
    
}
