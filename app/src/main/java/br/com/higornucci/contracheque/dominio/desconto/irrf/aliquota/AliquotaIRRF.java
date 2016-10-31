package br.com.higornucci.contracheque.dominio.desconto.irrf.aliquota;

import br.com.higornucci.contracheque.dominio.real.Real;

public interface AliquotaIRRF {
    void setProximo(AliquotaIRRF proximo);
    Real calcular(Real valorDoSalarioBruto);
}
