package br.com.higornucci.contracheque.dominio.desconto.inss.aliquota;

import java.math.BigDecimal;

import br.com.higornucci.contracheque.dominio.real.Real;

public class AliquotaMaxima implements AliquotaINSS {
    private static final double ALIQUOTA_MAXIMA = 0.11;
    private static final BigDecimal PISO_ALIQUOTA = new BigDecimal(2594.93);
    private static final BigDecimal TETO_ALIQUOTA = new BigDecimal(5189.82);
    private AliquotaINSS proximo;

    @Override
    public void setProximo(AliquotaINSS proximo) {
        this.proximo = proximo;
    }

    @Override
    public Real calcular(Real valorDoSalarioBruto) {
        if(valorDoSalarioBruto.entre(PISO_ALIQUOTA, TETO_ALIQUOTA)) {
            return valorDoSalarioBruto.multiplicarPor(ALIQUOTA_MAXIMA);
        } else {
            return new Real(TETO_ALIQUOTA).multiplicarPor(ALIQUOTA_MAXIMA);
        }
    }
}
