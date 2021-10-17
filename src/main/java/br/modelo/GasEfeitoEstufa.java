package br.modelo;

import java.util.Objects;

public class GasEfeitoEstufa {

    private Combustivel combustivel;
    private double valor;

    public GasEfeitoEstufa() {}

    public Combustivel getCombustivel() {
        return combustivel;
    }

    public void setCombustivel(Combustivel combustivel) {
        this.combustivel = combustivel;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        GasEfeitoEstufa that = (GasEfeitoEstufa) o;
        return Double.compare(that.valor, valor) == 0 &&
                combustivel == that.combustivel;
    }

    @Override
    public int hashCode() {
        return Objects.hash(combustivel, valor);
    }

    @Override
    public String toString() {
        return "GasEfeitoEstufa{" +
                "combustivel=" + combustivel +
                ", valor=" + valor +
                '}';
    }
}
