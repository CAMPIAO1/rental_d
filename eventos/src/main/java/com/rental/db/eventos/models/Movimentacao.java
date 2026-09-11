package com.rental.db.eventos.models;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;



@Entity
@Table (name = "movimentacao")
 public class Movimentacao {
     @Id
     @GeneratedValue(strategy = GenerationType.IDENTITY)
     
     @Column(name="id")
     private Integer id;

      @Column(name="data_movimentacao")
      private LocalDate dataMovimentacao;

     
      @Column(name="Tipo_de_movimentacao")
      private String tipoDeMovimentacao;
     
      @Column(name="Modelo")
      private String modelo;

     
      @Column(name="Quantidade")
      private int quantidade;


      @ManyToOne 
      @JoinColumn (name = "usuario_id")
      private Usuario usuario;

      @ManyToOne
      @JoinColumn(name = "equipamento_id")
      private Equipamento equipamento;
      
      public Movimentacao() {

    }

    public Movimentacao(LocalDate dataMovimentacao, Integer id, String modelo, int quantidade, String tipoDeMovimentacao, Usuario usuario) {
        this.dataMovimentacao = dataMovimentacao;
        this.id = id;
        this.modelo = modelo;
        this.quantidade = quantidade;
        this.tipoDeMovimentacao = tipoDeMovimentacao;
        this.usuario = usuario;
    }

    public Integer getId() {
      return id;
    }

    public void setId(Integer id) {
      this.id = id;
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

    public Usuario getUsuario() {
      return usuario;
    }

    public void setUsuario(Usuario usuario) {
      this.usuario = usuario;
    }
     
 }