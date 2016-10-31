package br.com.higornucci.contracheque.dominio.aliquota;

import java.math.BigDecimal;

import br.com.higornucci.contracheque.dominio.Real;

public interface Aliquota {
    void setProximo(Aliquota proximo);
    Real calcular(Real valorDoSalarioBruto);
}
