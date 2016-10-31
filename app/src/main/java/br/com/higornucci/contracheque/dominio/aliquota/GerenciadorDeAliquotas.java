package br.com.higornucci.contracheque.dominio.aliquota;

import br.com.higornucci.contracheque.dominio.Real;

public class GerenciadorDeAliquotas {

    private Aliquota primeiro;

    public GerenciadorDeAliquotas() {
        Aliquota minima = new AliquotaMinima();
        Aliquota intermediaria = new AliquotaIntermediaria();
        Aliquota maxima = new AliquotaMaxima();

        minima.setProximo(intermediaria);
        intermediaria.setProximo(maxima);

        primeiro = minima;
    }

    public Real calcular(Real valorDoSalarioBruto) {
        return primeiro.calcular(valorDoSalarioBruto);
    }
}
