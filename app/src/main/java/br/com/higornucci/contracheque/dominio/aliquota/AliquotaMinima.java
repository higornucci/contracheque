package br.com.higornucci.contracheque.dominio.aliquota;

import java.math.BigDecimal;

import br.com.higornucci.contracheque.dominio.Real;

public class AliquotaMinima implements Aliquota {
    private static final double ALIQUOTA_MINIMA = 0.08;
    private static final BigDecimal TETO_DA_ALIQUOTA = new BigDecimal(1556.94);
    private Aliquota proximo;

    @Override
    public void setProximo(Aliquota proximo) {
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
