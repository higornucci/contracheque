package br.com.higornucci.contracheque.dominio.desconto.irrf;

import br.com.higornucci.contracheque.dominio.desconto.CalculadorDeDesconto;
import br.com.higornucci.contracheque.dominio.desconto.irrf.aliquota.GerenciadorDeAliquotasIRRF;
import br.com.higornucci.contracheque.dominio.real.Real;

public class CalculadorDeIRRF implements CalculadorDeDesconto {
    private Real valorDoSalarioBruto;

    public CalculadorDeIRRF(Real valorDoSalarioBruto) {
        this.valorDoSalarioBruto = valorDoSalarioBruto;
    }

    @Override
    public Real calcular() {
        return new GerenciadorDeAliquotasIRRF().calcular(valorDoSalarioBruto);
    }
}
