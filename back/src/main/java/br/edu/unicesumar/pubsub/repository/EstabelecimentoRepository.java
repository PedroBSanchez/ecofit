package br.edu.unicesumar.pubsub.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.edu.unicesumar.pubsub.domain.aep.Estabelecimento;

public interface EstabelecimentoRepository extends JpaRepository<Estabelecimento, Long>{
    
}
