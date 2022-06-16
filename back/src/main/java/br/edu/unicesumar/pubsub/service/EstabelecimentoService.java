package br.edu.unicesumar.pubsub.service;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import br.edu.unicesumar.pubsub.domain.aep.Estabelecimento;
import br.edu.unicesumar.pubsub.repository.EstabelecimentoRepository;

@Service
public class EstabelecimentoService {
    
    @Autowired
    private EstabelecimentoRepository estabelecimentoRepository;

    public Estabelecimento save(Estabelecimento estabelecimento){
        return this.estabelecimentoRepository.save(estabelecimento);
    }

    public Page<Estabelecimento> findAll(Pageable pageable){
        return this.estabelecimentoRepository.findAll(pageable);
    }

    public Boolean deleteById(Long id) {
        Optional<Estabelecimento> estabelecimentoOpt = this.estabelecimentoRepository.findById(id);

        if(estabelecimentoOpt.isPresent()) {
            this.estabelecimentoRepository.deleteById(id);
            return true;
        }else{
            return false;
        }
        
    }

    public Estabelecimento updateEstabelecimento(Estabelecimento estabelecimento, Long id) {
        Optional<Estabelecimento> estabelecimentoOpt = this.estabelecimentoRepository.findById(id);

        if(estabelecimentoOpt.isPresent()) {
            Estabelecimento estabelecimentoBancoDeDados = estabelecimentoOpt.get();
            estabelecimentoBancoDeDados.setNome(estabelecimento.getNome());
            estabelecimentoBancoDeDados.setCnpj(estabelecimento.getCnpj());
            estabelecimentoBancoDeDados.setFone(estabelecimento.getFone());
            estabelecimentoBancoDeDados.setTaxaEntrega(estabelecimento.getTaxaEntrega());
            estabelecimentoBancoDeDados.setEmail(estabelecimento.getEmail());
            estabelecimentoBancoDeDados.setImgUrl(estabelecimento.getImgUrl());
            estabelecimentoBancoDeDados.getProdutos().clear();
            estabelecimentoBancoDeDados.getProdutos().addAll(estabelecimento.getProdutos());
            return this.save(estabelecimentoBancoDeDados);
        }else{
            return null;
        }
    }
}
