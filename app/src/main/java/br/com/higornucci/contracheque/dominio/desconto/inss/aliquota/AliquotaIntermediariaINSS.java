package br.com.higornucci.contracheque.dominio.desconto.inss.aliquota;

import java.math.BigDecimal;

import br.com.higornucci.contracheque.dominio.real.Real;

public class AliquotaIntermediariaINSS implements AliquotaINSS {
    private static final double ALIQUOTA_INTERMEDIARIA = 0.09;
    private static final BigDecimal PISO_ALIQUOTA = new BigDecimal(1556.95);
    private static final BigDecimal TETO_ALIQUOTA = new BigDecimal(2594.92);
    private AliquotaINSS proximo;

    @Override
    public void setProximo(AliquotaINSS proximo) {
        this.proximo = proximo;
    }

    @Override
    public Real calcular(Real valorDoSalarioBruto) {
        if(valorDoSalarioBruto.entre(PISO_ALIQUOTA, TETO_ALIQUOTA)) {
            return valorDoSalarioBruto.multiplicarPor(ALIQUOTA_INTERMEDIARIA);
        } else {
            return proximo.calcular(valorDoSalarioBruto);
        }
    }
}
