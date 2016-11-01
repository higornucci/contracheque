package br.com.higornucci.contracheque.dominio;

import org.junit.Ignore;
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
    public void deve_calcular_o_valor_do_irrf_sem_desconto_do_salario() throws Exception {
        Real valorDoSalarioBruto = new Real(new BigDecimal(1500));
        Real valorDescontadoEsperado = new Real(BigDecimal.ZERO);

        CalculadorDeDesconto calculadorDeDesconto = new CalculadorDeIRRF(valorDoSalarioBruto);
        Real valorDescontado = calculadorDeDesconto.calcular();

        assertThat(valorDescontado, is(equalTo(valorDescontadoEsperado)));
    }

    @Test
    public void deve_calcular_o_valor_do_irrf_sem_desconto_para_teto_do_salario() throws Exception {
        Real valorDoSalarioBruto = new Real(new BigDecimal(1903.98));
        Real valorDescontadoEsperado = new Real(BigDecimal.ZERO);

        CalculadorDeDesconto calculadorDeDesconto = new CalculadorDeIRRF(valorDoSalarioBruto);
        Real valorDescontado = calculadorDeDesconto.calcular();

        assertThat(valorDescontado, is(equalTo(valorDescontadoEsperado)));
    }

    @Test
    public void deve_calcular_o_valor_do_irrf_para_piso_da_aliquota_minima_a_partir_do_salario_bruto() throws Exception {
        Real valorDoSalarioBruto = new Real(new BigDecimal(1903.99));
        Real valorDescontadoEsperado = new Real(new BigDecimal(142.80));

        CalculadorDeDesconto calculadorDeDesconto = new CalculadorDeIRRF(valorDoSalarioBruto);
        Real valorDescontado = calculadorDeDesconto.calcular();

        assertThat(valorDescontado, is(equalTo(valorDescontadoEsperado)));
    }

    @Test
    public void deve_calcular_o_valor_do_irrf_para_teto_da_aliquota_minima_a_partir_do_salario_bruto() throws Exception {
        Real valorDoSalarioBruto = new Real(new BigDecimal(2826.65));
        Real valorDescontadoEsperado = new Real(new BigDecimal(212));

        CalculadorDeDesconto calculadorDeDesconto = new CalculadorDeIRRF(valorDoSalarioBruto);
        Real valorDescontado = calculadorDeDesconto.calcular();

        assertThat(valorDescontado, is(equalTo(valorDescontadoEsperado)));
    }

    @Test
    public void deve_calcular_o_valor_do_irrf_para_piso_da_aliquota_intermediaria_a_partir_do_salario_bruto() throws Exception {
        Real valorDoSalarioBruto = new Real(new BigDecimal(2826.66));
        Real valorDescontadoEsperado = new Real(new BigDecimal(424));

        CalculadorDeDesconto calculadorDeDesconto = new CalculadorDeIRRF(valorDoSalarioBruto);
        Real valorDescontado = calculadorDeDesconto.calcular();

        assertThat(valorDescontado, is(equalTo(valorDescontadoEsperado)));
    }

    @Test
    public void deve_calcular_o_valor_do_irrf_para_teto_da_aliquota_intermediaria_a_partir_do_salario_bruto() throws Exception {
        Real valorDoSalarioBruto = new Real(new BigDecimal(3751.05));
        Real valorDescontadoEsperado = new Real(new BigDecimal(562.66));

        CalculadorDeDesconto calculadorDeDesconto = new CalculadorDeIRRF(valorDoSalarioBruto);
        Real valorDescontado = calculadorDeDesconto.calcular();

        assertThat(valorDescontado, is(equalTo(valorDescontadoEsperado)));
    }
}
