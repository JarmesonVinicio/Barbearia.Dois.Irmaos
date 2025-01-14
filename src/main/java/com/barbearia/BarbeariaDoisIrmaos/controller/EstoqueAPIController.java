/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.barbearia.BarbeariaDoisIrmaos.controller;

import com.barbearia.BarbeariaDoisIrmaos.model.Estoque;
import com.barbearia.BarbeariaDoisIrmaos.service.EstoqueService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/estoque")
public class EstoqueAPIController {
    
    @Autowired
    EstoqueService estoqueService;
    
    //cadastrar
    @PostMapping("/adicionar")
    public ResponseEntity<Estoque> criar(@RequestBody Estoque estoque){
        Estoque novoProduto = estoqueService.criar(estoque);
        return new ResponseEntity<>(novoProduto,HttpStatus.CREATED);
    }
    
    @GetMapping("/listarTodos")
    public ResponseEntity<List> listar(){
        List<Estoque> listarTodosProdutos = estoqueService.buscarTodos();
        return new ResponseEntity<>(listarTodosProdutos,HttpStatus.CREATED);
    }
    
    @GetMapping("/buscar/{id}")
    public ResponseEntity<Estoque> buscar(@PathVariable Integer id){
        Estoque produtoEncontrado = estoqueService.buscarPorId(id);
        return new ResponseEntity<>(produtoEncontrado,HttpStatus.OK);
    }
    
    @PutMapping("/atualizar/{id}")
    public ResponseEntity<Estoque> atualizar(@PathVariable Integer id, @RequestBody Estoque estoque){
            Estoque produtoAtualizado = estoqueService.atualizar(id, estoque);
            return new ResponseEntity<>(produtoAtualizado, HttpStatus.OK);
    }
    
    @DeleteMapping("/excluir/{id}")
    public ResponseEntity<Estoque> excluir(@PathVariable Integer id){
        estoqueService.excluir(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
    
    
    
    
    
}
