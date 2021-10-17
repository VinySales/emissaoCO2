package br.modelo;

import java.util.Objects;

public class Consumo {

    private Combustivel combustivel;
    private double kmLitro;

    public Consumo() {}

    public Combustivel getCombustivel() {
        return combustivel;
    }

    public void setCombustivel(Combustivel combustivel) {
        this.combustivel = combustivel;
    }

    public double getKmLitro() {
        return kmLitro;
    }

    public void setKmLitro(double kmLitro) {
        this.kmLitro = kmLitro;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Consumo consumo = (Consumo) o;
        return Double.compare(consumo.kmLitro, kmLitro) == 0 &&
                combustivel == consumo.combustivel;
    }

    @Override
    public int hashCode() {
        return Objects.hash(combustivel, kmLitro);
    }

    @Override
    public String toString() {
        return "Consumo{" +
                "combustivel=" + combustivel +
                ", kmLitro=" + kmLitro +
                '}';
    }
}
