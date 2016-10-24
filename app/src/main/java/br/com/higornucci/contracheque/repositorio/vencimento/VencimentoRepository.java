package br.com.higornucci.contracheque.repositorio.vencimento;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import static br.com.higornucci.contracheque.repositorio.vencimento.VencimentoContract.*;

public class VencimentoRepository {

    private final VencimentoDbHelper vencimentoDbHelper;

    public VencimentoRepository(Context context) {
        vencimentoDbHelper = new VencimentoDbHelper(context);
    }

    public void salvar(Double vencimento) {
        SQLiteDatabase db = vencimentoDbHelper.getWritableDatabase();

        // Create a new map of values, where column names are the keys
        ContentValues values = new ContentValues();
        values.put(VencimentoEntry.COLUMN_DESCRICAO, "SALARIO_BRUTO");
        values.put(VencimentoEntry.COLUMN_VALOR, vencimento);

        // Insert the new row, returning the primary key value of the new row
        long newRowId = db.insert(VencimentoEntry.TABLE_NAME, null, values);
    }

    public Double buscarSalarioBruto() {
        SQLiteDatabase db = vencimentoDbHelper.getReadableDatabase();

        // Define a projection that specifies which columns from the database
        // you will actually use after this query.
        String[] projection = {
                VencimentoEntry._ID,
                VencimentoEntry.COLUMN_DESCRICAO,
                VencimentoEntry.COLUMN_VALOR
        };

        // Filter results WHERE "title" = 'My Title'
        String selection = VencimentoEntry.COLUMN_DESCRICAO + " = ?";
        String[] selectionArgs = { "SALARIO_BRUTO" };

        // How you want the results sorted in the resulting Cursor
        String sortOrder =
                VencimentoEntry.COLUMN_VALOR + " DESC";

        Cursor c = db.query(
                VencimentoEntry.TABLE_NAME,                     // The table to query
                projection,                               // The columns to return
                selection,                                // The columns for the WHERE clause
                selectionArgs,                            // The values for the WHERE clause
                null,                                     // don't group the rows
                null,                                     // don't filter by row groups
                sortOrder                                 // The sort order
        );

        if(c.getCount() > 0) {
            c.moveToFirst();
            return c.getDouble(c.getColumnIndex(VencimentoEntry.COLUMN_VALOR));
        }
        return 0d;
    }
}
