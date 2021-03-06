package br.com.higornucci.contracheque.dominio.desconto.irrf.aliquota;

import java.math.BigDecimal;

import br.com.higornucci.contracheque.dominio.real.Real;

public class AliquotaMinimaIRRF implements AliquotaIRRF {
    private static final double ALIQUOTA = 0.075;
    private static final Real DEDUCAO = new Real(new BigDecimal(142.8));
    private static final BigDecimal PISO_DA_ALIQUOTA = new BigDecimal(1903.99);
    private static final BigDecimal TETO_DA_ALIQUOTA = new BigDecimal(2826.65);
    private AliquotaIRRF proximo;

    @Override
    public void setProximo(AliquotaIRRF proximo) {
        this.proximo = proximo;
    }

    @Override
    public Real calcular(Real valorDoSalarioBrutoMenosINSS) {
        if(valorDoSalarioBrutoMenosINSS.entre(PISO_DA_ALIQUOTA, TETO_DA_ALIQUOTA)) {
            return valorDoSalarioBrutoMenosINSS.multiplicarPor(ALIQUOTA).menos(DEDUCAO);
        } else {
            return proximo.calcular(valorDoSalarioBrutoMenosINSS);
        }
    }
}
