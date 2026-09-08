package com.rental.db.eventos.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rental.db.eventos.models.Equipamento;
import com.rental.db.eventos.repositories.EquipamentoRepository;

@Service
public class EquipamentoService {

    @Autowired
    private EquipamentoRepository equipamentoRepository;

    public Long contarEquipamentos() {
        return equipamentoRepository.count();
    }

    public Equipamento buscarEquipamento(Integer id) {
        return equipamentoRepository.findById(id).orElse(null);
    }

    public List<Equipamento> listarEquipamentos() {
        return equipamentoRepository.findAll();
    }

    public Boolean deletarEquipamento(Integer id) {
        if (equipamentoRepository.existsById(id)) {
            equipamentoRepository.deleteById(id);
            return true;
        }
        return false;
    }

    public Equipamento cadastrarEquipamento(Equipamento equipamento) {
        return equipamentoRepository.save(equipamento);
    }

    public Equipamento atualizarEquipamento(Integer id, Equipamento equipamento) {
        Equipamento equipamentoRecuperado = buscarEquipamento(id);
        
        if (equipamentoRecuperado != null) {
            equipamentoRecuperado.setId(id);

            if (equipamento.getMarca() != null) {
                equipamentoRecuperado.setMarca(equipamento.getMarca());
            }
            if (equipamento.getModelo() != null) {
                equipamentoRecuperado.setModelo(equipamento.getModelo());
            }
            if (equipamento.getCategoria() != null) {
                equipamentoRecuperado.setCategoria(equipamento.getCategoria());
            }
            if (equipamento.getPotencia() != 0) {
                equipamentoRecuperado.setPotencia(equipamento.getPotencia());
            }
            if (equipamento.getMaterial() != null) {
                equipamentoRecuperado.setMaterial(equipamento.getMaterial());
            }
            if (equipamento.getPeso() != 0) {
                equipamentoRecuperado.setPeso(equipamento.getPeso());
            }
            if (equipamento.getDimensoes() != 0) {
                equipamentoRecuperado.setDimensoes(equipamento.getDimensoes());
            }
            if (equipamento.getCor() != null) {
                equipamentoRecuperado.setCor(equipamento.getCor());
            }
            if (equipamento.getQuantidade() != 0) {
                equipamentoRecuperado.setQuantidade(equipamento.getQuantidade());
            }

            return equipamentoRepository.save(equipamentoRecuperado);
        }
        return null;
    }
}