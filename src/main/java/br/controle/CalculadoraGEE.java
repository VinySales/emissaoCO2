package br.controle;

import br.Carro;
import br.Combustivel;

public interface CalculadoraGEE {
    double calcula(Carro carro, Combustivel combustivel, double valor) throws IllegalArgumentException;
}
