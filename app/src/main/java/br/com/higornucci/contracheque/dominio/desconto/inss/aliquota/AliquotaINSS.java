package br.com.higornucci.contracheque.dominio.desconto.inss.aliquota;

import br.com.higornucci.contracheque.dominio.real.Real;

public interface AliquotaINSS {
    void setProximo(AliquotaINSS proximo);
    Real calcular(Real valorDoSalarioBruto);
}
