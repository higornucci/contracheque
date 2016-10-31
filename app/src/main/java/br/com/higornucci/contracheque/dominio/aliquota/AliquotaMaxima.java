package br.com.higornucci.contracheque.dominio.aliquota;

import java.math.BigDecimal;

import br.com.higornucci.contracheque.dominio.Real;

public class AliquotaMaxima implements Aliquota {
    private static final double ALIQUOTA_MAXIMA = 0.11;
    public static final BigDecimal PISO_ALIQUOTA = new BigDecimal(2594.93);
    public static final BigDecimal TETO_ALIQUOTA = new BigDecimal(5189.82);
    private Aliquota proximo;

    @Override
    public void setProximo(Aliquota proximo) {
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
