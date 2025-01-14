/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.barbearia.BarbeariaDoisIrmaos.controller;

import com.barbearia.BarbeariaDoisIrmaos.model.Agendamento;
import com.barbearia.BarbeariaDoisIrmaos.service.AgendamentoService;
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
@RequestMapping("/agendamento")
public class AgendamentoAPIController {
    
    @Autowired
    AgendamentoService agendamentoService;
    
    //cadastrar
    @PostMapping("/adicionar")
    public ResponseEntity<Agendamento> criar(@RequestBody Agendamento agendamento){
        Agendamento novoAgendamento = agendamentoService.criar(agendamento);
        return new ResponseEntity<>(novoAgendamento,HttpStatus.CREATED);
    }
    
    @GetMapping("/listarTodos")
    public ResponseEntity<List> listar(){
        List<Agendamento> listarTodosAgendamentos = agendamentoService.buscarTodos();
        return new ResponseEntity<>(listarTodosAgendamentos,HttpStatus.CREATED);
    }
    
    @GetMapping("/buscar/{id}")
    public ResponseEntity<Agendamento> buscar(@PathVariable Integer id){
        Agendamento agendamentoEncontrado = agendamentoService.buscarPorId(id);
        return new ResponseEntity<>(agendamentoEncontrado,HttpStatus.OK);
    }
    
    @PutMapping("/atualizar/{id}")
    public ResponseEntity<Agendamento> atualizar(@PathVariable Integer id, @RequestBody Agendamento agendamento){
            Agendamento agendamentoAtualizado = agendamentoService.atualizar(id, agendamento);
            return new ResponseEntity<>(agendamentoAtualizado, HttpStatus.OK);
    }
    
    @DeleteMapping("/excluir/{id}")
    public ResponseEntity<Agendamento> excluir(@PathVariable Integer id){
        agendamentoService.excluir(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    
    
    
}