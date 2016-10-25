package br.com.higornucci.contracheque.dominio;

import java.math.BigDecimal;

public class Real {
    private BigDecimal valor;

    public Real(BigDecimal valor) {
        this.valor = valor.setScale(2, BigDecimal.ROUND_HALF_EVEN);
    }

    public Real multiplicarPor(double multiplicador) {
        return new Real(valor.multiply(new BigDecimal(multiplicador)));
    }

    public boolean menorOuIgualQue(BigDecimal valorASerComparado) {
        return valor.compareTo(valorASerComparado) == -1;
    }

    public BigDecimal getValor() {
        return valor;
    }

    public boolean entre(BigDecimal valorInferiorLimite, BigDecimal valorSuperiorLimite) {
        return valor.compareTo(valorInferiorLimite.setScale(2, BigDecimal.ROUND_HALF_EVEN)) >= 0 && valor.compareTo(valorSuperiorLimite.setScale(2, BigDecimal.ROUND_HALF_EVEN)) <= 0;
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
