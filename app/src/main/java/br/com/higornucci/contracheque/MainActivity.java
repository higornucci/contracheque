package br.com.higornucci.contracheque;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import com.github.mikephil.charting.charts.PieChart;

import br.com.higornucci.contracheque.repositorio.vencimento.VencimentoRepository;

public class MainActivity extends AppCompatActivity {
    private Double aDouble;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        VencimentoRepository vencimentoRepository = new VencimentoRepository(this);
        EditText editText = (EditText) findViewById(R.id.edit_salario);
        aDouble = vencimentoRepository.buscarSalarioBruto();
        editText.setText(aDouble.toString());
        if(aDouble > 0d) {
            Intent intent = new Intent(this, DisplaySalarioActivity.class);
            startActivity(intent);
        }
    }

    public void enviarSalario(View view) {
        EditText editText = (EditText) findViewById(R.id.edit_salario);
        String message = editText.getText().toString();

        if(aDouble == 0d) {
            VencimentoRepository vencimentoRepository = new VencimentoRepository(this);
            vencimentoRepository.salvar(Double.valueOf(message));
        }

        Intent intent = new Intent(this, DisplaySalarioActivity.class);
        startActivity(intent);
    }
}
