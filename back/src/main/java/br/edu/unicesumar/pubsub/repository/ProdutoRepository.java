package br.edu.unicesumar.pubsub.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.edu.unicesumar.pubsub.domain.aep.Produto;

public interface ProdutoRepository extends JpaRepository<Produto,Long>{
    
}
