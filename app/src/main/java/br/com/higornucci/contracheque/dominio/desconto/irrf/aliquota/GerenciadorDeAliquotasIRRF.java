package br.com.higornucci.contracheque.dominio.desconto.irrf.aliquota;

import br.com.higornucci.contracheque.dominio.desconto.inss.aliquota.AliquotaMinima;
import br.com.higornucci.contracheque.dominio.real.Real;

public class GerenciadorDeAliquotasIRRF {

    private AliquotaIRRF primeiro;

    public GerenciadorDeAliquotasIRRF() {
        AliquotaIRRF aliquotaZero = new AliquotaZero();
        this.primeiro = aliquotaZero;
    }

    public Real calcular(Real valorDoSalarioBruto) {
        return primeiro.calcular(valorDoSalarioBruto);
    }
}
