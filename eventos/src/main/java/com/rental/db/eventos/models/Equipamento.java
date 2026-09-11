package com.rental.db.eventos.models;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
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
      private String dimensoes;

      @Column(name="cor")
      private String cor;

      @Column(name="quantidade")
      private int quantidade;

      @OneToMany(mappedBy = "equipamento")
      private List<Movimentacao> movimentacoes;

      public Equipamento() {
        
      }

    public Equipamento(String categoria, String cor, String dimensoes, Integer id, String marca, String material, String modelo, List<Movimentacao> movimentacoes, int peso, int potencia, int quantidade) {
        this.categoria = categoria;
        this.cor = cor;
        this.dimensoes = dimensoes;
        this.id = id;
        this.marca = marca;
        this.material = material;
        this.modelo = modelo;
        this.movimentacoes = movimentacoes;
        this.peso = peso;
        this.potencia = potencia;
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

    public String getDimensoes() {
        return dimensoes;
    }

    public void setDimensoes(String dimensoes) {
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

    public List<Movimentacao> getMovimentacoes() {
        return movimentacoes;
    }

    public void setMovimentacoes(List<Movimentacao> movimentacoes) {
        this.movimentacoes = movimentacoes;
    }

    
      
   }
