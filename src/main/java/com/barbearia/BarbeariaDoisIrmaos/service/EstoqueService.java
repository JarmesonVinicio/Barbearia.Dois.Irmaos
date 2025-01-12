/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.barbearia.BarbeariaDoisIrmaos.service;

import com.barbearia.BarbeariaDoisIrmaos.model.Estoque;
import org.springframework.stereotype.Service;


@Service
public class EstoqueService {
    
    //MÉTODO QUE CALCULA O VALOR TOTAL, MULTIPLICANDO A QUANTIDADE DE ITENS PELO SEU PREÇO UNITÁRIO 
    public double calcularValor(double valor_1, double valor_2){
    
        double valor_total;
        
        if(valor_1 == 0){ //se a quantidade for 0 então não pode multiplicar pois o valor total daria 0
            valor_total = valor_1 + valor_2; //Nesse caso deve-se somar quantidade com preço unitario
        }
        else{
            valor_total = valor_1 * valor_2;
        }
        return valor_total;
        
    }
    
    
    
    
}
