package com.barbearia.BarbeariaDoisIrmaos.service;

import com.barbearia.BarbeariaDoisIrmaos.model.Agendamento;
import org.springframework.stereotype.Service;

@Service
public class AgendamentoService {
    
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
