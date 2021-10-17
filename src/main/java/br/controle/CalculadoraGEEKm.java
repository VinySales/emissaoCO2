package br.controle;

import br.Carro;
import br.Combustivel;
import br.GasEfeitoEstufa;

public class CalculadoraGEEKm implements CalculadoraGEE {

    @Override
    public double calcula(Carro carro, Combustivel combustivel, double valor) throws IllegalArgumentException{
        if(valor <= 0){
            throw new IllegalArgumentException("Não é possível efetuar o calculo com um valor negativo");
        }

        GasEfeitoEstufa gee = carro.getGees()
                .stream()
                .filter(gasEfeitoEstufa -> gasEfeitoEstufa.getCombustivel().equals(combustivel))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("Valor emitido pelo combustivel não encontrado"));

        return gee.getValor() * valor;
    }
}
