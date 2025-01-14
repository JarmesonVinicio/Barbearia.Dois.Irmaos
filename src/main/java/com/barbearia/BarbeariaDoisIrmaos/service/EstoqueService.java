/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.barbearia.BarbeariaDoisIrmaos.service;

import com.barbearia.BarbeariaDoisIrmaos.model.Estoque;
import com.barbearia.BarbeariaDoisIrmaos.repository.EstoqueRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class EstoqueService {
    
    @Autowired
    EstoqueRepository estoqueRepository;
    
    //CRUD
    public Estoque buscarPorId(Integer id){
        return estoqueRepository.findById(id).orElseThrow();
    }
    
    public Estoque criar(Estoque estoque){
        estoque.setId(null);
        estoqueRepository.save(estoque);
        return estoque;
    }
    
    public void excluir(Integer id){
        Estoque produtoEncontrado = buscarPorId(id);
        estoqueRepository.deleteById(produtoEncontrado.getId());
    }
    
    public List<Estoque> buscarTodos(){
        return estoqueRepository.findAll();
    }
    
    public Estoque atualizar (Integer id, Estoque estoque){
        Estoque produtoEncontrado = buscarPorId(id);
        
        produtoEncontrado.setNome(estoque.getNome());
        produtoEncontrado.setCategoria(estoque.getCategoria());
        produtoEncontrado.setQuantidade(estoque.getQuantidade());
        produtoEncontrado.setPreco(estoque.getPreco());
        produtoEncontrado.setValor_total(estoque.getValor_total());
        produtoEncontrado.setData_compra(estoque.getData_compra());
        produtoEncontrado.setValidade(estoque.getValidade());
        produtoEncontrado.setObservacao(estoque.getObservacao());
        estoqueRepository.save(produtoEncontrado);
        return produtoEncontrado;
    } 
    
    
    
    
    
    
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
