package com.Project.Backend.controller;

import com.Project.Backend.model.Produto;
import com.Project.Backend.service.ProdutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/produto")
public class ProdutoControler {

    @Autowired
    private ProdutoService service;

    @PostMapping("/insert")
    public ResponseEntity<String> insert(@RequestBody Produto produto){
        Produto prod = service.post(produto);
        return prod !=  null ? new ResponseEntity<>("Produto criado com sucesso", HttpStatus.CREATED) : new ResponseEntity<>("Erro ao criar produto", HttpStatus.BAD_REQUEST);
    }

    @GetMapping("/{id}")
    public Optional<Produto> getId(Produto id){
        return service.findById(id.getId());
    }

    @GetMapping("/jpql-produto/{id}/{preço}")
    public Optional<Produto> getId(Produto id, Produto preço){
        return service.getone(id, preço);
    }
    @GetMapping("/jpql-produto/{nome}")
    public Optional<Produto> getnomeJPQL(Produto nome){
        return service.getoneNomeJPQL(nome);
    }
    @GetMapping("/sql-produto/{nome}")
    public Optional<Produto> getnomeSQL(Produto nome){
        return service.getoneNomeSQL(nome);
    }


    @GetMapping("/produtos")
    public ResponseEntity<List<Produto>> getall(){
        List<Produto> produtos = service.findAll();
        return !produtos.isEmpty() ? new ResponseEntity<>(produtos, HttpStatus.OK) : new ResponseEntity<>(produtos, HttpStatus.BAD_REQUEST);
    }

    @PutMapping("/produto-update")
    public ResponseEntity<String> update(@RequestBody Produto p){
        Produto prod = service.post(p);
        return prod !=  null ? new ResponseEntity<>("Produto atualizado com sucesso", HttpStatus.OK)
                : new ResponseEntity<>("Erro ao atualizar produto", HttpStatus.BAD_REQUEST);

    }

    @DeleteMapping("/produto-delete/{id}")
    public ResponseEntity<String> delete(@PathVariable Integer id){
        service.delete(id);
        Optional<Produto> prod = service.findById(id);
        return !prod.isPresent() ? new ResponseEntity<>("Produto deletado com sucesso", HttpStatus.OK) : new ResponseEntity<>("Erro ao deletar produto ou produto não encontrado", HttpStatus.NOT_FOUND);

    }

}
