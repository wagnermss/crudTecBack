package com.Project.Backend.repository;

import com.Project.Backend.model.Produto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.swing.text.html.Option;
import java.util.Optional;

public interface ProdutoRepository extends JpaRepository<Produto,Integer> {

    @Query("SELECT p FROM Produto p WHERE p.id = :id AND p.preço  <= :preço")
    Optional<Produto> findProdutoParams(Integer id, Double preço);

    @Query(value = "SELECT p FROM Produto p " +
            "WHERE p.id = :id " +
            "AND p.preço  <= :preço", nativeQuery = true)
    Optional<Produto> findPrecoSQL(Integer id, Double preço);

    @Query("SELECT p FROM Produto p WHERE p.nome = :nome")
    Optional<Produto> nomeProdutoJPQL(String nome);

    @Query(value = "SELECT p FROM Produto p WHERE p.nome = :nome", nativeQuery = true)
    Optional<Produto> nomeProdutoSQL(String nome);
//

}
