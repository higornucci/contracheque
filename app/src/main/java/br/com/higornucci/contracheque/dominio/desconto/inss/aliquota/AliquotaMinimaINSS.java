package br.com.higornucci.contracheque.dominio.desconto.inss.aliquota;

import java.math.BigDecimal;

import br.com.higornucci.contracheque.dominio.real.Real;

public class AliquotaMinimaINSS implements AliquotaINSS {
    private static final double ALIQUOTA_MINIMA = 0.08;
    private static final BigDecimal TETO_DA_ALIQUOTA = new BigDecimal(1556.94);
    private AliquotaINSS proximo;

    @Override
    public void setProximo(AliquotaINSS proximo) {
        this.proximo = proximo;
    }

    @Override
    public Real calcular(Real valorDoSalarioBruto) {
        if(valorDoSalarioBruto.menorOuIgualQue(TETO_DA_ALIQUOTA)) {
            return valorDoSalarioBruto.multiplicarPor(ALIQUOTA_MINIMA);
        } else {
            return proximo.calcular(valorDoSalarioBruto);
        }
    }
}
