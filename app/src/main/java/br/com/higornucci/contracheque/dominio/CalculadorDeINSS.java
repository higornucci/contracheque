package br.com.higornucci.contracheque.dominio;

import java.math.BigDecimal;

public class CalculadorDeINSS implements CalculadorDeDesconto {

    private static final double ALIQUOTA_MINIMA = 0.08;
    private static final double ALIQUOTA_INTERMEDIARIA = 0.09;
    private static final double ALIQUOTA_MAXIMA = 0.11;

    private Real valorDoSalarioBruto;

    public CalculadorDeINSS(Real valorDoSalarioBruto) {
        this.valorDoSalarioBruto = valorDoSalarioBruto;
    }

    @Override
    public Real calcular() {
        if(valorDoSalarioBruto.menorOuIgualQue(new BigDecimal(1556.94))) {
            return valorDoSalarioBruto.multiplicarPor(ALIQUOTA_MINIMA);
        } else if(valorDoSalarioBruto.entre(new BigDecimal(1556.95), new BigDecimal(2594.92))) {
            return valorDoSalarioBruto.multiplicarPor(ALIQUOTA_INTERMEDIARIA);
        } else if(valorDoSalarioBruto.entre(new BigDecimal(2594.93), new BigDecimal(5189.82))) {
            return valorDoSalarioBruto.multiplicarPor(ALIQUOTA_MAXIMA);
        }
        return new Real(new BigDecimal(5189.82)).multiplicarPor(ALIQUOTA_MAXIMA);
    }
}
