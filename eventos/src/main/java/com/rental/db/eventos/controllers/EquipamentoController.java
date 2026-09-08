package com.rental.db.eventos.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.rental.db.eventos.models.Equipamento;
import com.rental.db.eventos.services.EquipamentoService;

@RestController
@RequestMapping("/equipamento")
public class EquipamentoController {

    @Autowired
    private EquipamentoService equipamentoService;

    @GetMapping("/contar-equipamentos")
    public Long contarEquipamentos() {
        return equipamentoService.contarEquipamentos();
    }

    @GetMapping("/buscar-equipamento/{id}")
    public Equipamento buscarEquipamento(@PathVariable Integer id) {
        return equipamentoService.buscarEquipamento(id);
    }

    @GetMapping("/listar-equipamentos")
    public List<Equipamento> listarEquipamentos() {
        return equipamentoService.listarEquipamentos();
    }

    @DeleteMapping("/deletar-equipamento/{id}")
    public String deletarEquipamento(@PathVariable Integer id) {
        if (equipamentoService.deletarEquipamento(id)) {
            return "Equipamento removido com sucesso.";
        }
        return "Falha ao remover equipamento.";
    }

    @PostMapping("/salvar-equipamento")
    public Equipamento cadastrarEquipamento(@RequestBody Equipamento equipamento) {
        return equipamentoService.cadastrarEquipamento(equipamento);
    }

    @PutMapping("/atualizar-equipamento/{id}")
    public String atualizarEquipamento(@PathVariable Integer id, @RequestBody Equipamento equipamento) {
        if (equipamentoService.atualizarEquipamento(id, equipamento) != null) {
            return "Equipamento atualizado com sucesso.";
        }
        return "Falha ao atualizar equipamento.";
    }
}