package com.rental.db.eventos.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.rental.db.eventos.models.Movimentacao;
import com.rental.db.eventos.repositories.MovimentacaoRepository;


@Service
public class MovimentacaoService {

    @Autowired
    private MovimentacaoRepository movimentacaoRepository;

    public Long contarMovimentacoes() {
        return movimentacaoRepository.count();
    }

    public Movimentacao buscarMovimentacao(Integer id) {
        return movimentacaoRepository.findById(id).orElse(null);
    }

    public List<Movimentacao> listarMovimentacoes() {
        return movimentacaoRepository.findAll();
    }

    public Boolean deletarMovimentacao(Integer id) {
        if (movimentacaoRepository.existsById(id)) {
            movimentacaoRepository.deleteById(id);
            return true;
        }
        return false;
    }

    public Movimentacao cadastrarMovimentacao(Movimentacao movimentacao) {
        return movimentacaoRepository.save(movimentacao);
    }

    public Movimentacao atualizarMovimentacao(Integer id, Movimentacao movimentacao) {
        Movimentacao movimentacaoRecuperada = buscarMovimentacao(id);

       if (movimentacaoRecuperada != null) {
            movimentacaoRecuperada.setId(id);

            if (movimentacao.getUsuario() != null) {
                movimentacaoRecuperada.setUsuario(movimentacao.getUsuario());
            }
            if (movimentacao.getDataMovimentacao() != null) {
                movimentacaoRecuperada.setDataMovimentacao(movimentacao.getDataMovimentacao());
            }
            if (movimentacao.getTipoDeMovimentacao() != null) {
                movimentacaoRecuperada.setTipoDeMovimentacao(movimentacao.getTipoDeMovimentacao());
            }
            if (movimentacao.getModelo() != null) {
                movimentacaoRecuperada.setModelo(movimentacao.getModelo());
            }
            if (movimentacao.getQuantidade() != 0) {
                movimentacaoRecuperada.setQuantidade(movimentacao.getQuantidade());
            }

            return movimentacaoRepository.save(movimentacaoRecuperada);
        }
        return null;
    }
}
