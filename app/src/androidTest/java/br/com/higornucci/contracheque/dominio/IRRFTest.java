package br.com.higornucci.contracheque.dominio;

import org.junit.Test;

import java.math.BigDecimal;

import br.com.higornucci.contracheque.dominio.desconto.CalculadorDeDesconto;
import br.com.higornucci.contracheque.dominio.desconto.irrf.CalculadorDeIRRF;
import br.com.higornucci.contracheque.dominio.real.Real;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class IRRFTest {

    @Test
    public void deve_calcular_o_valor_do_irrf_com_aliquota_minima_descontado_do_salario() throws Exception {
        Real valorDoSalarioBruto = new Real(new BigDecimal(1500));
        Real valorDescontadoEsperado = new Real(BigDecimal.ZERO);

        CalculadorDeDesconto calculadorDeDesconto = new CalculadorDeIRRF(valorDoSalarioBruto);
        Real valorDescontado = calculadorDeDesconto.calcular();

        assertThat(valorDescontado, is(equalTo(valorDescontadoEsperado)));
    }
}
