package br.com.higornucci.contracheque;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.ViewGroup;

import com.github.mikephil.charting.charts.PieChart;
import com.github.mikephil.charting.data.PieData;
import com.github.mikephil.charting.data.PieDataSet;
import com.github.mikephil.charting.data.PieEntry;

import java.util.Arrays;

public class DisplaySalarioActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_salario);

        Intent intent = getIntent();
        String message = intent.getStringExtra(MainActivity.EXTRA_MESSAGE);
        float salarioBruto = Float.valueOf(message);

        PieEntry pieEntry = new PieEntry(salarioBruto, "Salário Líquido");
        PieDataSet pieDataSet = new PieDataSet(Arrays.asList(pieEntry, new PieEntry(65f, "Imposto")), "Salário");
        pieDataSet.addColor(Color.GREEN);
        pieDataSet.addColor(Color.CYAN);

        PieData pieData = new PieData(pieDataSet);

        PieChart pieChart = (PieChart) findViewById(R.id.piechart_salario);
        pieChart.setData(pieData);
        pieChart.invalidate();
        pieChart.notifyDataSetChanged();
    }
}
