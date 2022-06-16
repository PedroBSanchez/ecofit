package br.edu.unicesumar.pubsub.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import br.edu.unicesumar.pubsub.domain.aep.Estabelecimento;
import br.edu.unicesumar.pubsub.service.EstabelecimentoService;

@CrossOrigin(allowedHeaders = "*", origins = "*")
@RestController
@RequestMapping("/estabelecimento")
public class EstabelecimentoController {
    
    @Autowired
    private EstabelecimentoService estabelecimentoService;

    @GetMapping
    public ResponseEntity<Page<Estabelecimento>> findAllEstabelecimento(Pageable pageable) {
        return new ResponseEntity<>(estabelecimentoService.findAll(pageable), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Estabelecimento> saveEstabelecimento(@RequestBody Estabelecimento estabelecimento){
        Estabelecimento novoEstabelecimento = this.estabelecimentoService.save(estabelecimento);
        return new ResponseEntity<>(novoEstabelecimento, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteEstabelecimento(@PathVariable(name = "id") Long id) {
        
        if(this.estabelecimentoService.deleteById(id)){
            return new ResponseEntity<>("Estabelecimento Deletado", HttpStatus.OK);
        }else{
            return new ResponseEntity<>("Estabelecimento não Encontrado", HttpStatus.BAD_REQUEST);
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> updateEstabelecimento(@PathVariable(name = "id") Long id, @RequestBody Estabelecimento estabelecimento) {

        if(this.estabelecimentoService.updateEstabelecimento(estabelecimento, id) == null){
            return new ResponseEntity<>("Estabelecimento não achado", HttpStatus.BAD_REQUEST);
        }else{
            return new ResponseEntity<>("Estabelecimento atualizado", HttpStatus.OK);
        }

        
    }
}
