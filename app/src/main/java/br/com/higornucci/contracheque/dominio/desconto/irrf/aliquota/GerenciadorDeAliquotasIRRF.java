package br.com.higornucci.contracheque.dominio.desconto.irrf.aliquota;

import br.com.higornucci.contracheque.dominio.real.Real;

public class GerenciadorDeAliquotasIRRF {

    private AliquotaIRRF primeiro;

    public GerenciadorDeAliquotasIRRF() {
        AliquotaIRRF aliquotaZero = new AliquotaZeroIRRF();
        AliquotaIRRF aliquotaMinima = new AliquotaMinimaIRRF();
        AliquotaIRRF aliquotaIntermediaria = new AliquotaIntermediariaIRRF();
        AliquotaIRRF aliquotaMaxima = new AliquotaMaximaIRRF();
        AliquotaIRRF aliquotaAcimaDoTeto = new AliquotaAcimaDoTetoIRRF();

        aliquotaZero.setProximo(aliquotaMinima);
        aliquotaMinima.setProximo(aliquotaIntermediaria);
        aliquotaIntermediaria.setProximo(aliquotaMaxima);
        aliquotaMaxima.setProximo(aliquotaAcimaDoTeto);

        this.primeiro = aliquotaZero;
    }

    public Real calcular(Real valorDoSalarioBrutoMenosINSS) {
        return primeiro.calcular(valorDoSalarioBrutoMenosINSS);
    }
}
