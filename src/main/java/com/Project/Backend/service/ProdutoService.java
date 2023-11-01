package com.Project.Backend.service;

import com.Project.Backend.model.Produto;
import com.Project.Backend.repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProdutoService {

    @Autowired
    private ProdutoRepository repository;

    public Produto post(Produto p){
        return repository.save(p);
    }

    public Optional<Produto> getone(Produto p, Produto preço){
        return repository.findProdutoParams(p.getId(),p.getPreço());
    }
    public Optional<Produto> getoneNomeSQL(Produto nome){
        return repository.nomeProdutoSQL(String.valueOf(nome));
    }

    public Optional<Produto> getoneNomeJPQL(Produto nome){
        return repository.nomeProdutoJPQL(String.valueOf(nome));
    }

    public List<Produto> findAll() {
        return repository.findAll();

    }

    public Optional<Produto> findById(Integer id) {
        return repository.findById(id);

    }

    public void delete(Integer id) {
        repository.deleteById(id);
    }
}
