package br.com.higornucci.contracheque.dominio;

import org.junit.Before;
import org.junit.Test;

import java.math.BigDecimal;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class INSSTest {

    @Test
    public void deve_calcular_o_valor_do_inss_com_aliquota_minima_descontado_do_salario() throws Exception {
        Real valorDoSalarioBruto = new Real(new BigDecimal(1500));
        Real valorDescontadoEsperado = new Real(new BigDecimal(120));

        CalculadorDeDesconto calculadorDeDesconto = new CalculadorDeINSS(valorDoSalarioBruto);
        Real valorDescontado = calculadorDeDesconto.calcular();

        assertThat(valorDescontado, is(equalTo(valorDescontadoEsperado)));
    }

    @Test
    public void deve_calcular_o_valor_do_inss_com_o_valor_teto_da_aliquota_minima_descontado_do_salario() throws Exception {
        Real valorDoSalarioBruto = new Real(new BigDecimal(1556.94));
        Real valorDescontadoEsperado = new Real(new BigDecimal(124.5552));

        CalculadorDeDesconto calculadorDeDesconto = new CalculadorDeINSS(valorDoSalarioBruto);
        Real valorDescontado = calculadorDeDesconto.calcular();

        assertThat(valorDescontado, is(equalTo(valorDescontadoEsperado)));
    }

    @Test
    public void deve_calcular_o_valor_do_inss_com_o_valor_piso_da_aliquota_intermediaria_descontado_do_salario() throws Exception {
        Real valorDoSalarioBruto = new Real(new BigDecimal(1556.95));
        Real valorDescontadoEsperado = new Real(new BigDecimal(140.1255));

        CalculadorDeDesconto calculadorDeDesconto = new CalculadorDeINSS(valorDoSalarioBruto);
        Real valorDescontado = calculadorDeDesconto.calcular();

        assertThat(valorDescontado, is(equalTo(valorDescontadoEsperado)));
    }

    @Test
    public void deve_calcular_o_valor_do_inss_com_o_valor_teto_da_aliquota_intermediaria_descontado_do_salario() throws Exception {
        Real valorDoSalarioBruto = new Real(new BigDecimal(2594.92));
        Real valorDescontadoEsperado = new Real(new BigDecimal(233.5428));

        CalculadorDeDesconto calculadorDeDesconto = new CalculadorDeINSS(valorDoSalarioBruto);
        Real valorDescontado = calculadorDeDesconto.calcular();

        assertThat(valorDescontado, is(equalTo(valorDescontadoEsperado)));
    }
}