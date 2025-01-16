package com.barbearia.BarbeariaDoisIrmaos.controller;

import com.barbearia.BarbeariaDoisIrmaos.model.Agendamento;
import com.barbearia.BarbeariaDoisIrmaos.service.AgendamentoService;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller //precisa especificar que é uma classe de controler para que ele entenda que é de controle e não uma classe normal
public class AgendamentoController {
    
     @Autowired
     AgendamentoService agendamentoService;
    
    
    @GetMapping("/") //aqui é definido o nome da rota que a URL sera chamada no navegador de internet
    public String inicio(){ //apenas o nome do método
        return "index"; //será chamado o arquivo HTML da camada View (pasta templates), pagina inicial
    }
    
    @GetMapping("/inicio") //se o usuário digitar /inicio também é redirecionado para o menu iniciar
    public String inicio2(){
        return "index";
    }
    
    @GetMapping("/cadastrar") //missão é chamar o formulário
    public String cadastre(Model model){
        model.addAttribute("agendamento", new Agendamento()); //criando um objeto de agendamento(Agendamento) vazio com seus atributos e jogando para a model.
        return "cadastro"; //procurar pelo HTML com nome de: cadastro
    }
    
    @PostMapping("/gravar")
    public String processarFormulario(@ModelAttribute Agendamento agendamento, Model model){ //receber os dados do formulário e salva numa lista de agendamentos
        
        if(agendamento.getId() != null){ //se for diferente de nulo, é pra editar
            agendamentoService.atualizar(agendamento.getId(), agendamento);
        }
        else{ //se for nulo é pra cadastrar
            agendamentoService.criar(agendamento);
        }
        return "redirect:/listagem"; //chamar a listagem dos agendamentos salvos
    }
    
    @GetMapping("/listagem")
    public String listaForm(Model model){
        
        model.addAttribute("lista", agendamentoService.buscarTodos());
        return "listagem";
    }
    
    @GetMapping("/alterar-agendamento")
    public String alterarAgendamento(Model model, @RequestParam String id){
        
        Integer idAgendamento = Integer.parseInt(id);
        model.addAttribute("agendamento", agendamentoService.buscarPorId(idAgendamento));
        return "cadastro";
    }
    
    @GetMapping("/excluir-agendamento")
    public String excluirAgendamento(Model model, @RequestParam String id){
        
        Integer idAgendamento = Integer.parseInt(id);
        agendamentoService.excluir(idAgendamento);
        return "redirect:/listagem"; //chamar a listagem dos agendamentos salvos
    }
    
    @GetMapping("/exibir") 
    public String mostrarDetalhes(@RequestParam String id, Model model) {
        
        Integer idAgendamento = Integer.parseInt(id);
        model.addAttribute("agendamento", agendamentoService.buscarPorId(idAgendamento));
        double valorTotal = agendamentoService.calcularValor(agendamentoService.buscarPorId(idAgendamento));
        model.addAttribute("valorTotal", valorTotal);
        
        return "exibir";
    }
    
    



}
    
    
    
    
    
    
    
    
    
    

