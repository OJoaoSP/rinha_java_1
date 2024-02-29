package rinha.rinha.model;

import jakarta.persistence.*;
import rinha.rinha.dto.TransacaoDTO;

@Entity
@Table(name = "clientes")
public class Cliente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer Id;
    private String Nome;
    public Integer Limite;
    public Integer Saldo;

    public Boolean AplicaValor(TransacaoDTO t){
        if (t.tipo() == "c"){
            Saldo = Saldo + t.valor();
            return true;
        }

        Integer resultado_saldo = Saldo - t.valor();
        if (resultado_saldo < (Limite * -1 ) ){
            return false;
        }
        Saldo = Saldo - t.valor();
        return  true;


    }

}
