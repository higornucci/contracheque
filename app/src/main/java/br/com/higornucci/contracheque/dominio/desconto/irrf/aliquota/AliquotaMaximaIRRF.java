package br.com.higornucci.contracheque.dominio.desconto.irrf.aliquota;

import java.math.BigDecimal;

import br.com.higornucci.contracheque.dominio.real.Real;

public class AliquotaMaximaIRRF implements AliquotaIRRF {
    private static final double ALIQUOTA = 0.225;
    private static final Real DEDUCAO = new Real(new BigDecimal(636.13));
    private static final BigDecimal PISO_DA_ALIQUOTA = new BigDecimal(3751.06);
    private static final BigDecimal TETO_DA_ALIQUOTA = new BigDecimal(4664.68);
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
