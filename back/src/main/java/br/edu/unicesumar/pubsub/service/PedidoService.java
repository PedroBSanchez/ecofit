package br.edu.unicesumar.pubsub.service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import br.edu.unicesumar.pubsub.domain.aep.Pedido;
import br.edu.unicesumar.pubsub.repository.PedidoRepository;

@Service
public class PedidoService {
    
    @Autowired
    private PedidoRepository pedidoRepository;

    public Page<Pedido> fildAll(Pageable pageable){
        return this.pedidoRepository.findAll(pageable);
    }

    public Pedido save(Pedido pedido){
        return this.pedidoRepository.save(pedido);
    }
}
