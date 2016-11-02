package br.com.higornucci.contracheque.view;

import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;

import java.math.BigDecimal;
import java.text.NumberFormat;

public class MascaraMonetaria implements TextWatcher {
    private EditText mEditText;
    private NumberFormat mNF = NumberFormat.getCurrencyInstance();

    public MascaraMonetaria(EditText mEditText) {
        super();
        this.mEditText = mEditText;
    }

    @Override
    public void beforeTextChanged(CharSequence cs, int start, int count, int after) {
    }

    @Override
    public void onTextChanged(CharSequence cs, int start, int before, int count) {
        String str;
        try {
            double value = valorSemMascara(cs.toString());
            str = mNF.format(value);
            mEditText.removeTextChangedListener(this);
            mEditText.setText(str);
            mEditText.addTextChangedListener(this);
            mEditText.setSelection(str.length());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void afterTextChanged(Editable s) {
    }

    public Double valorSemMascara() {
        return valorSemMascara(this.mEditText.getText().toString());
    }

    private Double valorSemMascara(String valor) {
        BigDecimal parsed;
        try {
            String cleanString = valor.replaceAll("[R,$,.]", "");
            parsed = new BigDecimal(cleanString).setScale(2,
                    BigDecimal.ROUND_FLOOR).divide(new BigDecimal(100),
                    BigDecimal.ROUND_FLOOR);
        } catch (Exception e) {
            parsed = new BigDecimal("0.0");
        }
        return parsed.doubleValue();
    }
}
