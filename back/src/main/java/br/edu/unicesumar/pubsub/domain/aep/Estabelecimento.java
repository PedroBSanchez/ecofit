package br.edu.unicesumar.pubsub.domain.aep;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Data;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Estabelecimento {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String cnpj;

    private String nome;

    private String fone;

    private Float taxaEntrega;

    private String email;

    private String imgUrl;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "produto_id")
    private List<Produto> produtos = new ArrayList<>();
}
