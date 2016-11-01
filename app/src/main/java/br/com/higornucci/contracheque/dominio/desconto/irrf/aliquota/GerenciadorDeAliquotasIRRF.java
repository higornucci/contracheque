package br.com.higornucci.contracheque.dominio.desconto.irrf.aliquota;

import br.com.higornucci.contracheque.dominio.real.Real;

public class GerenciadorDeAliquotasIRRF {

    private AliquotaIRRF primeiro;

    public GerenciadorDeAliquotasIRRF() {
        AliquotaIRRF aliquotaZero = new AliquotaZeroIRRF();
        AliquotaIRRF aliquotaMinima = new AliquotaMinimaIRRF();
        AliquotaIRRF aliquotaIntermediaria = new AliquotaIntermediariaIRRF();

        aliquotaZero.setProximo(aliquotaMinima);
        aliquotaMinima.setProximo(aliquotaIntermediaria);

        this.primeiro = aliquotaZero;
    }

    public Real calcular(Real valorDoSalarioBruto) {
        return primeiro.calcular(valorDoSalarioBruto);
    }
}
