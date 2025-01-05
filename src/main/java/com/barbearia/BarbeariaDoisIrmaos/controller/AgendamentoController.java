package com.barbearia.BarbeariaDoisIrmaos.controller;

import com.barbearia.BarbeariaDoisIrmaos.model.Agendamento;
import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

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
    
    @PostMapping("/gravar")
    public String processarFormulario(@ModelAttribute Agendamento agendamento, Model model){ //receber os dados do formulário e salva numa lista de agendamentos
        if (agendamento.getId() != null){ //se for diferente de nulo, ele atualiza
            for(Agendamento a: listaAgendamentos){
            if(a.getId()== agendamento.getId()){ //esse id se refere ao id hidden (campo invisível) do HTML cadastro. 
                a.setNome(agendamento.getNome());
                a.setTelefone(agendamento.getTelefone());
                a.setData(agendamento.getData());
                a.setHora(agendamento.getHora());
                a.setBarbeiro_resp(agendamento.getBarbeiro_resp());
                a.setCabelo(agendamento.getCabelo());
                a.setBarba(agendamento.getBarba());
                a.setSobrancelha(agendamento.getSobrancelha());
                a.setHidratacao(agendamento.getHidratacao());
                a.setTintura(agendamento.getTintura());
                
                break;
            }
        }
            
        }
        else{
            agendamento.setId(listaAgendamentos.size() + 1); //adicionando ID
//            livro.setLido(false); //informando que ele não foi lido (informação default)
            listaAgendamentos.add(agendamento); //INSERIR NA LISTA
        }
        return "redirect:/listagem"; //chamar a listagem dos agendamentos salvos
    }
    
    @GetMapping("/listagem")
    public String listaForm(Model model){
        
        model.addAttribute("lista", listaAgendamentos);
        return "listagem";
    }
    
    
    @GetMapping("/exibir")
    public String mostrarDetalhes(Model model, @RequestParam String id){ //recebendo o id de fora(da listagem.html, quando o link for clicado)
        Integer idAgendamento = Integer.parseInt(id); //convertendo o Sting id que veio de fora para inteiro)
        
        Agendamento registroEncontrado = new Agendamento(); //criando um objeto vazio de Agendamento, que será passado para o model.addAttribute
        for(Agendamento a: listaAgendamentos){ //a representa a propria listaAgendamentos que esta preenchida com varios atributos de Agendamento(ex:nome,telefone, data,hora, etc)
            if(a.getId()== idAgendamento){ //verificando se a cada ITERAÇÃO feita pelo looping for, se o ID da LISTA é o mesmo que foi recebido de fora(id da listagem, o do parametro)
                registroEncontrado = a; //SE FOR O MESMO, ele pega todos os dados do objeto l naquela volta da iteração e atribui (preenche) no registroEncontrado. 
                break; //encontrou, então para o loop e sai dele
            }
        }
        
        model.addAttribute("agendamento", registroEncontrado); //com o objeto encontrado ele atribui ao name do model para ser usado em outra pagina HTML.
        return "exibir"; //chama o exibir.html
    }
    
    
    @GetMapping("/alterar-agendamento")
    public String alterarAgendamento(Model model, @RequestParam String id){
        
        Integer idAgendamento = Integer.parseInt(id);
        model.addAttribute("agendamento", obtemAgendamentoPeloId(idAgendamento));
        return "cadastro";
    }
    
    @GetMapping("/excluir-agendamento")
    public String excluirAgendamento(Model model, @RequestParam String id){
        
        Integer idAgendamento = Integer.parseInt(id);
        listaAgendamentos.remove(obtemAgendamentoPeloId(idAgendamento));
        return "redirect:/listagem"; //chamar a listagem dos agendamentos salvos
    }
        
    public Agendamento obtemAgendamentoPeloId(Integer idAgendamento){
        Agendamento registroEncontrado = new Agendamento();
        for(Agendamento a: listaAgendamentos){
            if(a.getId()== idAgendamento){
                registroEncontrado = a;
                break;
            }
        }
        return registroEncontrado;
    }       
    
    
    
    
    
    
    
    
    
    
}
    
    
    
    
    
    
    
    
    
    

