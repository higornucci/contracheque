package br.com.higornucci.contracheque.dominio.desconto.irrf.aliquota;

import java.math.BigDecimal;

import br.com.higornucci.contracheque.dominio.real.Real;

public class AliquotaZeroIRRF implements AliquotaIRRF {
    private AliquotaIRRF proximo;

    @Override
    public void setProximo(AliquotaIRRF proximo) {
        this.proximo = proximo;
    }

    @Override
    public Real calcular(Real valorDoSalarioBrutoMenosINSS) {
        if(valorDoSalarioBrutoMenosINSS.menorOuIgualQue(new BigDecimal(1903.98))) {
            return new Real(BigDecimal.ZERO);
        } else {
            return proximo.calcular(valorDoSalarioBrutoMenosINSS);
        }
    }
}
