package br.modelo;

import java.util.Set;

public class Carro {

    private String categoria;
    private String marca;
    private String modelo;
    private String versao;
    private String motor;
    private String transmissao;
    private Poluentes poluentes;

    private Set<Combustivel> combustivel;
    private Set<GasEfeitoEstufa> gees;
    private Set<Consumo> consumos;

    public Carro() {}

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
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

    public String getVersao() {
        return versao;
    }

    public void setVersao(String versao) {
        this.versao = versao;
    }

    public String getMotor() {
        return motor;
    }

    public void setMotor(String motor) {
        this.motor = motor;
    }

    public String getTransmissao() {
        return transmissao;
    }

    public void setTransmissao(String transmissao) {
        this.transmissao = transmissao;
    }

    public Set<GasEfeitoEstufa> getGees() {
        return gees;
    }

    public void setGees(Set<GasEfeitoEstufa> gees) {
        this.gees = gees;
    }

    public Set<Consumo> getConsumos() {
        return consumos;
    }

    public void setConsumos(Set<Consumo> consumos) {
        this.consumos = consumos;
    }

    public Poluentes getPoluentes() {
        return poluentes;
    }

    public void setPoluentes(Poluentes poluentes) {
        this.poluentes = poluentes;
    }

    public Set<Combustivel> getCombustivel() {
        return combustivel;
    }

    public void setCombustivel(Set<Combustivel> combustivel) {
        this.combustivel = combustivel;
    }

    @Override
    public String toString() {
        return "Carro{" +
                "categoria='" + categoria + '\'' +
                ", marca='" + marca + '\'' +
                ", modelo='" + modelo + '\'' +
                ", versao='" + versao + '\'' +
                ", motor='" + motor + '\'' +
                ", transmissao='" + transmissao + '\'' +
                ", poluentes=" + poluentes +
                ", gees=" + gees +
                ", consumos=" + consumos +
                '}';
    }
}
