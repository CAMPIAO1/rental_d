package com.rental.db.eventos.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;


    @Entity
    @Table (name = "equipamento")
   public class Equipamento {
     @Id
     @GeneratedValue(strategy = GenerationType.IDENTITY)

     @Column(name="id_equipamento")
     private Integer id;

     @Column(name="marca")
     private String marca;

     @Column(name="modelo")
     private String modelo;

     @Column(name="categoria")
     private String categoria;

     @Column(name="potencia")
     private int potencia;

     @Column(name="material")
     private String material;

     @Column(name="peso")
     private int peso;

      @Column(name="dimensoes")
      private int dimensoes;

      @Column(name="cor")
      private String cor;

      @Column(name="quantidade")
      private int quantidade;

      @ManyToOne
      @JoinColumn(name = "movimentacao_id", nullable = false)
      private Movimentacao movimentacao;

      public Equipamento() {
      }

      public Equipamento(Integer id, String marca, String modelo, String categoria, int potencia, String material,
            int peso, int dimensoes, String cor, int quantidade) {
        this.id = id;
        this.marca = marca;
        this.modelo = modelo;
        this.categoria = categoria;
        this.potencia = potencia;
        this.material = material;
        this.peso = peso;
        this.dimensoes = dimensoes;
        this.cor = cor;
        this.quantidade = quantidade;
      }

      public Integer getId() {
          return id;
      }

      public void setId(Integer id) {
          this.id = id;
      }

      public String getMarca() {
          return marca;
      }

      public void setMarca(String marca) {
          this.marca = marca;
      }

      public String getModelo() {
          return modelo;
      }

      public void setModelo(String modelo) {
          this.modelo = modelo;
      }

      public String getCategoria() {
          return categoria;
      }

      public void setCategoria(String categoria) {
          this.categoria = categoria;
      }

      public int getPotencia() {
          return potencia;
      }

      public void setPotencia(int potencia) {
          this.potencia = potencia;
      }

      public String getMaterial() {
          return material;
      }

      public void setMaterial(String material) {
          this.material = material;
      }

      public int getPeso() {
          return peso;
      }

      public void setPeso(int peso) {
          this.peso = peso;
      }

      public int getDimensoes() {
          return dimensoes;
      }

      public void setDimensoes(int dimensoes) {
          this.dimensoes = dimensoes;
      }

      public String getCor() {
          return cor;
      }

      public void setCor(String cor) {
          this.cor = cor;
      }

      public int getQuantidade() {
          return quantidade;
      }

      public void setQuantidade(int quantidade) {
          this.quantidade = quantidade;
      }
      
}
