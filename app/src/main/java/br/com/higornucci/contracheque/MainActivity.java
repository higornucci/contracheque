package br.com.higornucci.contracheque;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import com.github.mikephil.charting.charts.PieChart;

import br.com.higornucci.contracheque.repositorio.vencimento.VencimentoRepository;

public class MainActivity extends AppCompatActivity {
    public final static String EXTRA_MESSAGE = "br.com.higornucci.contracheque.EXTRA_MESSAGE";
    private Double aDouble;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        VencimentoRepository vencimentoRepository = new VencimentoRepository(this);
        EditText editText = (EditText) findViewById(R.id.edit_salario);
        aDouble = vencimentoRepository.buscarSalarioBruto();
        editText.setText(aDouble.toString());
    }

    public void enviarSalario(View view) {
        Intent intent = new Intent(this, DisplaySalarioActivity.class);
        EditText editText = (EditText) findViewById(R.id.edit_salario);
        String message = editText.getText().toString();
        intent.putExtra(EXTRA_MESSAGE, message);

        if(aDouble == 0d) {
            VencimentoRepository vencimentoRepository = new VencimentoRepository(this);
            vencimentoRepository.salvar(Double.valueOf(message));
        }

        startActivity(intent);
    }
}
