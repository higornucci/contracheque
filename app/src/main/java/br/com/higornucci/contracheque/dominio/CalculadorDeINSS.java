package br.com.higornucci.contracheque.dominio;

public class CalculadorDeINSS implements CalculadorDeDesconto {

    private Real valorDoSalarioBruto;

    public CalculadorDeINSS(Real valorDoSalarioBruto) {
        this.valorDoSalarioBruto = valorDoSalarioBruto;
    }

    @Override
    public Real calcular() {
        return valorDoSalarioBruto.multiplicarPor(0.08);
    }
}
