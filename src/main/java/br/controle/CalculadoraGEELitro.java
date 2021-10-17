package br.controle;

import br.Carro;
import br.Combustivel;
import br.modelo.Consumo;
import br.modelo.GasEfeitoEstufa;

public class CalculadoraGEELitro implements CalculadoraGEE {

    @Override
    public double calcula(Carro carro, Combustivel combustivel, double valor) throws IllegalArgumentException {
        if(valor <= 0){
            throw new IllegalArgumentException("Não é possível efetuar o calculo com um valor negativo");
        }

        GasEfeitoEstufa gee = carro.getGees()
                .stream()
                .filter(gasEfeitoEstufa -> gasEfeitoEstufa.getCombustivel().equals(combustivel))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("Valor emitido pelo combustivel não encontrado"));

        Consumo consumo = carro.getConsumos()
                .stream()
                .filter(c -> c.getCombustivel().equals(combustivel))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("Valor consumido por KM não encotrado"));


        return consumo.getKmLitro() * valor * gee.getValor();
    }

}
