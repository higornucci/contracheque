package br.com.higornucci.contracheque;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.github.mikephil.charting.charts.PieChart;
import com.github.mikephil.charting.data.PieData;
import com.github.mikephil.charting.data.PieDataSet;
import com.github.mikephil.charting.data.PieEntry;

import java.math.BigDecimal;
import java.util.Arrays;

import br.com.higornucci.contracheque.dominio.desconto.inss.CalculadorDeINSS;
import br.com.higornucci.contracheque.dominio.desconto.irrf.CalculadorDeIRRF;
import br.com.higornucci.contracheque.dominio.real.Real;
import br.com.higornucci.contracheque.repositorio.vencimento.VencimentoRepository;

public class DisplaySalarioActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_salario);

        VencimentoRepository vencimentoRepository = new VencimentoRepository(this);
        Double salarioBruto = vencimentoRepository.buscarSalarioBruto();

        Real valorSalarioBruto = new Real(new BigDecimal(salarioBruto));
        Real descontoINSS = new CalculadorDeINSS(valorSalarioBruto).calcular();
        Real descontoIRRF = new CalculadorDeIRRF(valorSalarioBruto.menos(descontoINSS)).calcular();
        Real valorSalarioLiquido = valorSalarioBruto.menos(descontoINSS).menos(descontoIRRF);

        PieEntry inss = new PieEntry(descontoINSS.getValor().floatValue(), "INSS");
        PieEntry irrf = new PieEntry(descontoIRRF.getValor().floatValue(), "IRRF");
        PieEntry salarioLiquido = new PieEntry(valorSalarioLiquido.getValor().floatValue(), "Salário Líquido");
        PieDataSet pieDataSet = new PieDataSet(Arrays.asList(salarioLiquido, inss, irrf), "Salário");
        pieDataSet.resetColors();
        pieDataSet.setValueTextSize(16);
        pieDataSet.addColor(Color.rgb(2, 136, 209));
        pieDataSet.addColor(Color.rgb(255, 82, 82));
        pieDataSet.addColor(Color.rgb(139, 195, 74));

        PieData pieData = new PieData(pieDataSet);

        PieChart pieChart = (PieChart) findViewById(R.id.piechart_salario);
        pieChart.setData(pieData);
        pieChart.setCenterText(valorSalarioBruto.formatado());
        pieChart.setCenterTextColor(Color.BLACK);
        pieChart.setCenterTextSize(22);
        pieChart.setHoleRadius(40);
        pieChart.setTransparentCircleRadius(45);
        pieChart.getLegend().setEnabled(false);
        pieChart.getDescription().setEnabled(false);
        pieChart.invalidate();
        pieChart.notifyDataSetChanged();
    }
}
