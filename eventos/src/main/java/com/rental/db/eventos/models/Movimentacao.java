package com.rental.db.eventos.models;

import java.time.LocalDate;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;



 @Entity
@Table (name = "movimentacao")
 public class Movimentacao {
     @Id
     @GeneratedValue(strategy = GenerationType.IDENTITY)
     
     @Column(name="Id")
     private Integer id;

      @Column(name="data_movimentacao")
      private LocalDate dataMovimentacao;

     
      @Column(name="Tipo_de_movimentacao")
      private String tipoDeMovimentacao;
     
      @Column(name="Modelo")
      private String modelo;

     
      @Column(name="Quantidade")
      private int quantidade;

      @OneToMany (mappedBy = "movimentacao", cascade = CascadeType.ALL)
      private List<Equipamento> equipamentos;

      @ManyToOne 
      @JoinColumn (name = "usuario_id", nullable = false)
      private Usuario usuario;

      public Movimentacao() {
      }

      public Movimentacao(Integer id, Usuario usuario, LocalDate dataMovimentacao, String tipoDeMovimentacao,
                  String modelo, int quantidade, List<Equipamento> equipamentos) {
            this.id = id;
            this.usuario = usuario;
            this.dataMovimentacao = dataMovimentacao;
            this.tipoDeMovimentacao = tipoDeMovimentacao;
            this.modelo = modelo;
            this.quantidade = quantidade;
            this.equipamentos = equipamentos;
      }

      public Integer getId() {
            return id;
      }

      public void setId(Integer id) {
            this.id = id;
      }

      public Usuario getUsuario() {
            return usuario;
      }

      public void setUsuario(Usuario usuario) {
            this.usuario = usuario;
      }

      public LocalDate getDataMovimentacao() {
            return dataMovimentacao;
      }

      public void setDataMovimentacao(LocalDate dataMovimentacao) {
            this.dataMovimentacao = dataMovimentacao;
      }

      public String getTipoDeMovimentacao() {
            return tipoDeMovimentacao;
      }

      public void setTipoDeMovimentacao(String tipoDeMovimentacao) {
            this.tipoDeMovimentacao = tipoDeMovimentacao;
      }

      public String getModelo() {
            return modelo;
      }

      public void setModelo(String modelo) {
            this.modelo = modelo;
      }

      public int getQuantidade() {
            return quantidade;
      }

      public void setQuantidade(int quantidade) {
            this.quantidade = quantidade;
      }

      public List<Equipamento> getEquipamento() {
            return equipamentos;
      }

      public void setEquipamento(List<Equipamento> equipamentos) {
            this.equipamentos = equipamentos;
      }
      
}   


