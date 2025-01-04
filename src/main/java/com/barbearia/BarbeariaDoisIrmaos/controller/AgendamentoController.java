package com.barbearia.BarbeariaDoisIrmaos.controller;

import com.barbearia.BarbeariaDoisIrmaos.model.Agendamento;
import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller //precisa especificar que é uma classe de controler para que ele entenda que é de controle e não uma classe normal
public class AgendamentoController {
    
    private List<Agendamento> listaAgendamentos = new ArrayList<>();
    
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
    
    
}
    
    
    
    
    
    
    
    
    
    

