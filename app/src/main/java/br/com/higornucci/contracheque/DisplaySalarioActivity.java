package br.com.higornucci.contracheque;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.ViewGroup;
import android.widget.EditText;

import com.github.mikephil.charting.charts.PieChart;
import com.github.mikephil.charting.data.PieData;
import com.github.mikephil.charting.data.PieDataSet;
import com.github.mikephil.charting.data.PieEntry;

import java.util.Arrays;

import br.com.higornucci.contracheque.repositorio.vencimento.VencimentoRepository;

public class DisplaySalarioActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_salario);

        Intent intent = getIntent();
        VencimentoRepository vencimentoRepository = new VencimentoRepository(this);
        Double salarioBruto = vencimentoRepository.buscarSalarioBruto();

        PieEntry pieEntry = new PieEntry(Float.parseFloat(salarioBruto.toString()), "Salário Líquido");
        PieDataSet pieDataSet = new PieDataSet(Arrays.asList(pieEntry, new PieEntry(585f, "INSS"), new PieEntry(678f, "IRRF")), "Salário");
        pieDataSet.resetColors();
        pieDataSet.setValueTextSize(16);
        pieDataSet.addColor(Color.rgb(2, 136, 209));
        pieDataSet.addColor(Color.rgb(255, 82, 82));
        pieDataSet.addColor(Color.rgb(139, 195, 74));

        PieData pieData = new PieData(pieDataSet);

        PieChart pieChart = (PieChart) findViewById(R.id.piechart_salario);
        pieChart.setData(pieData);
        pieChart.setCenterText("Salário");
        pieChart.setCenterTextColor(Color.BLACK);
        pieChart.setCenterTextSize(24);
        pieChart.setHoleRadius(40);
        pieChart.setTransparentCircleRadius(45);
        pieChart.getLegend().setEnabled(false);
        pieChart.getDescription().setEnabled(false);
        pieChart.invalidate();
        pieChart.notifyDataSetChanged();
    }
}
