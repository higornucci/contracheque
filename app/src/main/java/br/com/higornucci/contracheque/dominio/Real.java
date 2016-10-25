package br.com.higornucci.contracheque.dominio;

import java.math.BigDecimal;

public class Real {
    private BigDecimal valor;

    public Real(BigDecimal valor) {
        this.valor = valor.setScale(2, BigDecimal.ROUND_HALF_EVEN);
    }

    public Real multiplicarPor(double multiplicador) {
        return new Real(valor.multiply(BigDecimal.valueOf(multiplicador)));
    }

    public boolean menorOuIgualQue(BigDecimal valorASerComparado) {
        return valor.compareTo(valorASerComparado) == -1;
    }

    public BigDecimal getValor() {
        return valor;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Real real = (Real) o;
        return valor.equals(real.getValor());
    }

    @Override
    public int hashCode() {
        return valor.hashCode();
    }
}
