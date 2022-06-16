package br.edu.unicesumar.pubsub.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.edu.unicesumar.pubsub.domain.aep.Pedido;

public interface PedidoRepository extends JpaRepository<Pedido, Long>{

}
