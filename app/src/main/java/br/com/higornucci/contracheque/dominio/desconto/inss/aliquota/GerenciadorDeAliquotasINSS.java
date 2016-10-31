package br.com.higornucci.contracheque.dominio.desconto.inss.aliquota;

import br.com.higornucci.contracheque.dominio.real.Real;

public class GerenciadorDeAliquotasINSS {

    private AliquotaINSS primeiro;

    public GerenciadorDeAliquotasINSS() {
        AliquotaINSS minima = new AliquotaMinima();
        AliquotaINSS intermediaria = new AliquotaIntermediaria();
        AliquotaINSS maxima = new AliquotaMaxima();

        minima.setProximo(intermediaria);
        intermediaria.setProximo(maxima);

        primeiro = minima;
    }

    public Real calcular(Real valorDoSalarioBruto) {
        return primeiro.calcular(valorDoSalarioBruto);
    }
}
