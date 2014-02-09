package br.com.sistema;

import java.math.BigDecimal;

public class Conta {

    private Long id;
    private String nome;
    private BigDecimal saldoInicial = BigDecimal.ZERO;

    public Conta() {
    }

    public Conta(Long id, String nome, BigDecimal saldoInicial) {
	this.id = id;
	this.nome = nome;
	this.saldoInicial = saldoInicial;
    }

    public Long getId() {
	return id;
    }

    public void setId(Long id) {
	this.id = id;
    }

    public String getNome() {
	return nome;
    }

    public void setNome(String nome) {
	this.nome = nome;
    }

    public BigDecimal getSaldoInicial() {
	return saldoInicial;
    }

    public void setSaldoInicial(BigDecimal saldoInicial) {
	this.saldoInicial = saldoInicial;
    }

}
