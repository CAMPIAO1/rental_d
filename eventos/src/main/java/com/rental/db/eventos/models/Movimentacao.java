package com.rental.db.eventos.models;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;


 @Entity
@Table (name = "movimentacao")
 public class Movimentacao {
     @Id
     @GeneratedValue(strategy = GenerationType.IDENTITY)
     
     @Column(name="Id")
     private Integer id;

     @Column(name="Usuario")
     private String usuario;

      @Column(name="data_movimentacao")
      private LocalDate dataMovimentacao;

     
      @Column(name="Tipo_de_movimentacao")
      private String tipoDeMovimentacao;
     
      @Column(name="Modelo")
      private String modelo;

     
      @Column(name="Quantidade")
      private int quantidade;


      public Movimentacao() {
      }


      public Movimentacao(Integer id, String usuario, LocalDate dataMovimentacao, String tipoDeMovimentacao,
                  String modelo, int quantidade) {
            this.id = id;
            this.usuario = usuario;
            this.dataMovimentacao = dataMovimentacao;
            this.tipoDeMovimentacao = tipoDeMovimentacao;
            this.modelo = modelo;
            this.quantidade = quantidade;
      }


      public Integer getId() {
            return id;
      }


      public void setId(Integer id) {
            this.id = id;
      }


      public String getUsuario() {
            return usuario;
      }


      public void setUsuario(String usuario) {
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


   
}   

