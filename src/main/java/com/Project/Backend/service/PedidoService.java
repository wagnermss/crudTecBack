package com.Project.Backend.service;

import com.Project.Backend.model.Pedido;
import com.Project.Backend.model.Produto;
import com.Project.Backend.repository.PedidoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@Service
public class PedidoService {

    @Autowired
    private PedidoRepository repository;

    public Pedido insert(@RequestBody Pedido pedido) {
        return repository.save(pedido);
    }
}
