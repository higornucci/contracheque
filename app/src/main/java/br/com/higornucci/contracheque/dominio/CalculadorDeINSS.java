package br.com.higornucci.contracheque.dominio;

import br.com.higornucci.contracheque.dominio.aliquota.GerenciadorDeAliquotas;

public class CalculadorDeINSS implements CalculadorDeDesconto {

    private Real valorDoSalarioBruto;

    public CalculadorDeINSS(Real valorDoSalarioBruto) {
        this.valorDoSalarioBruto = valorDoSalarioBruto;
    }

    @Override
    public Real calcular() {
        return new GerenciadorDeAliquotas().calcular(valorDoSalarioBruto);
    }
}
