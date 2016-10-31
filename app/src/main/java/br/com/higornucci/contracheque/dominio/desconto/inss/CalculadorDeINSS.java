package br.com.higornucci.contracheque.dominio.desconto.inss;

import br.com.higornucci.contracheque.dominio.real.Real;
import br.com.higornucci.contracheque.dominio.desconto.CalculadorDeDesconto;
import br.com.higornucci.contracheque.dominio.desconto.inss.aliquota.GerenciadorDeAliquotasINSS;

public class CalculadorDeINSS implements CalculadorDeDesconto {

    private Real valorDoSalarioBruto;

    public CalculadorDeINSS(Real valorDoSalarioBruto) {
        this.valorDoSalarioBruto = valorDoSalarioBruto;
    }

    @Override
    public Real calcular() {
        return new GerenciadorDeAliquotasINSS().calcular(valorDoSalarioBruto);
    }
}
