package com.barbearia.BarbeariaDoisIrmaos.service;

import com.barbearia.BarbeariaDoisIrmaos.model.Agendamento;
import com.barbearia.BarbeariaDoisIrmaos.repository.AgendamentoRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AgendamentoService {
    
    @Autowired
    AgendamentoRepository agendamentoRepository;

    //CRUD
    public Agendamento criar (Agendamento agendamento){
        agendamento.setId(null);
        agendamentoRepository.save(agendamento); //salvar no banco de dados
        return agendamento; //retornar a entidade salva completa
    }
    
    public List<Agendamento> buscarTodos(){
        return agendamentoRepository.findAll();
    }
    
    public void excluir(Integer id){
        Agendamento agendamentoEncontrado = buscarPorId(id);
        agendamentoRepository.deleteById(agendamentoEncontrado.getId());
    }
    
    public Agendamento buscarPorId(Integer id){
        return agendamentoRepository.findById(id).orElseThrow();
    }
    
    public Agendamento atualizar (Integer id, Agendamento agendamento){
        Agendamento agendamentoEncontrado = buscarPorId(id);
        
        agendamentoEncontrado.setNome(agendamento.getNome());
        agendamentoEncontrado.setTelefone(agendamento.getTelefone());
        agendamentoEncontrado.setData(agendamento.getData());
        agendamentoEncontrado.setHora(agendamento.getHora());
        agendamentoEncontrado.setBarbeiro_resp(agendamento.getBarbeiro_resp());
        agendamentoRepository.save(agendamentoEncontrado);
        return agendamentoEncontrado;
    } 
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    //MÉTODO QUE CALCULA O TOTAL DOS SERVICOS SELECIONADOS
    public double calcularValor(Agendamento agendamento){
        //atributos
        double valorCabelo = 0;
        double valorBarba = 0;
        double valorSobrancelha = 0;
        double valorHidratacao = 0;
        double valorTintura = 0;
        
        if(agendamento.getCabelo()){ //se estiver como TRUE, significa que ele foi marcado (checkbox)
            valorCabelo = 20;
        }
        if(agendamento.getBarba()){ //se estiver como TRUE, significa que ele foi marcado (checkbox)
            valorBarba = 10;
        }
        if(agendamento.getSobrancelha()){ //se estiver como TRUE, significa que ele foi marcado (checkbox)
            valorSobrancelha = 5;
        }
        if(agendamento.getHidratacao()){ //se estiver como TRUE, significa que ele foi marcado (checkbox)
            valorHidratacao = 30;
        }
        if(agendamento.getTintura()){ //se estiver como TRUE, significa que ele foi marcado (checkbox)
            valorTintura = 20;
        }
        
        double valorTotal = valorCabelo + valorBarba + valorSobrancelha + valorHidratacao + valorTintura;
        
        return valorTotal;
        
    } 
    
    
    
    
}
