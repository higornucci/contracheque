package br.com.higornucci.contracheque.dominio.desconto.irrf.aliquota;

import java.math.BigDecimal;

import br.com.higornucci.contracheque.dominio.real.Real;

public class AliquotaMinimaIRRF implements AliquotaIRRF {

    private static final double ALIQUOTA_MINIMA = 0.075;
    private static final BigDecimal PISO_DA_ALIQUOTA = new BigDecimal(1903.99);
    private static final BigDecimal TETO_DA_ALIQUOTA = new BigDecimal(2826.65);
    private AliquotaIRRF proximo;

    @Override
    public void setProximo(AliquotaIRRF proximo) {
        this.proximo = proximo;
    }

    @Override
    public Real calcular(Real valorDoSalarioBruto) {
        if(valorDoSalarioBruto.entre(PISO_DA_ALIQUOTA, TETO_DA_ALIQUOTA)) {
            return valorDoSalarioBruto.multiplicarPor(ALIQUOTA_MINIMA);
        } else {
            return proximo.calcular(valorDoSalarioBruto);
        }
    }
}
