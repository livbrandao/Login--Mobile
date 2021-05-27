package com.example.loginapp;

import java.io.Serializable;

public class Produto implements Serializable {
    private String codigo;
    private  String nome;
    private  Integer quant;
    private  double preco;

    public  void Produto(){

    }

    public Produto(String codigo, String nome, Integer quant, double preco) {
        this.codigo = codigo;
        this.nome = nome;
        this.quant = quant;
        this.preco = preco;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Integer getQuant() {
        return quant;
    }

    public void setQuant(Integer quant) {
        this.quant = quant;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

    @Override
    public String toString() {
        return "Código     :" + codigo + '\n' +
                "Produto   : " + nome + '\n' +
                "Quantidade: " + quant + '\n' +
                "Preço     : " + preco + '\n';
    }
}

