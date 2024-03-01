package rinha.rinha.dto;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import rinha.rinha.Repository.ClienteRepository;
import rinha.rinha.Repository.TransacaoRepository;
import rinha.rinha.model.Cliente;
import rinha.rinha.model.Transacao;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping("clientes")
public class Api {

    @Autowired
    private TransacaoRepository repositoryT;
    @Autowired
    private ClienteRepository repositoryS;
    @PostMapping("/{id}/transacoes")
    @Transactional
    public ResponseEntity transacao(@PathVariable Integer id, @RequestBody TransacaoDTO dado){
        Optional<Cliente> pre_cliente = repositoryS.findById(id);
        if (pre_cliente.isEmpty()){
            return  ResponseEntity.notFound().build();
        }
        var c = pre_cliente.get();
        if (!c.AplicaValor(dado) ) {
            return ResponseEntity.unprocessableEntity().build();
        }
        Transacao t = new Transacao(dado, id);
        repositoryT.save(t);
        return  ResponseEntity
                .ok().build();
    }
    @GetMapping("/{id}/extratos")
    public ResponseEntity Extrato(@PathVariable Integer id){
        Optional<Cliente> pre_cliente = repositoryS.findById(id);
        if (pre_cliente.isEmpty()){
            return  ResponseEntity.notFound().build();
        }
        var c = pre_cliente.get();

        List<Transacao> t = repositoryT.findByClienteId(id);
        var b = t.stream().map( ft -> new TransacaoDTO(ft));

        return ResponseEntity.ok().build();

    }


}
