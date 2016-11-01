package br.com.higornucci.contracheque.dominio.desconto.irrf.aliquota;

import java.math.BigDecimal;

import br.com.higornucci.contracheque.dominio.real.Real;

public class AliquotaAcimaDoTetoIRRF implements AliquotaIRRF {
    private static final double ALIQUOTA = 0.275;
    private static final Real DEDUCAO = new Real(new BigDecimal(869.36));

    @Override
    public void setProximo(AliquotaIRRF proximo) {
        new UnsupportedOperationException();
    }

    @Override
    public Real calcular(Real valorDoSalarioBrutoMenosINSS) {
        return valorDoSalarioBrutoMenosINSS.multiplicarPor(ALIQUOTA).menos(DEDUCAO);
    }
}
