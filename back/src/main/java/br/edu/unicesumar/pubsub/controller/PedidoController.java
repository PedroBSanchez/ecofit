package br.edu.unicesumar.pubsub.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import br.edu.unicesumar.pubsub.domain.aep.Pedido;
import br.edu.unicesumar.pubsub.service.PedidoService;

@RestController
@RequestMapping("/pedido")
public class PedidoController {
    
    @Autowired
    private PedidoService service;

    @GetMapping
    public Page<Pedido> buscarTodosPedidos(Pageable pageable){
        return this.service.fildAll(pageable);
    }

    @PostMapping
    public Pedido salvarPedido(@RequestBody Pedido pedido){
        return this.service.save(pedido);
    }
}
