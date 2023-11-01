package com.Project.Backend.controller;

import com.Project.Backend.model.Pedido;
import com.Project.Backend.model.Produto;
import com.Project.Backend.service.PedidoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PedidoController {

    @Autowired
    private PedidoService service;

    @PostMapping
    public ResponseEntity<String> insert(@RequestBody Pedido pedido){
        Pedido prod = service.insert(pedido);
        return prod !=  null ? new ResponseEntity<>("Pedido criado com sucesso", HttpStatus.CREATED) : new ResponseEntity<>("Erro ao criar pedido", HttpStatus.BAD_REQUEST);
    }
}
