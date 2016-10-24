package br.com.higornucci.contracheque.repositorio.vencimento;

import android.provider.BaseColumns;

public class VencimentoContract {

    public VencimentoContract() {
    }

    public static class VencimentoEntry implements BaseColumns {
        public static final String TABLE_NAME = "vencimento";
        public static final String COLUMN_DESCRICAO = "descricao";
        public static final String COLUMN_VALOR = "valor";
        private static final String PRIMARY_KEY_TYPE = " INTEGER PRIMARY KEY";
        private static final String TEXT_TYPE = " TEXT";
        private static final String DOUBLE_TYPE = " REAL";
        private static final String COMMA_SEP = ",";
        public static final String SQL_CREATE_ENTRIES =
                "CREATE TABLE " + VencimentoEntry.TABLE_NAME + " (" +
                        VencimentoEntry._ID + PRIMARY_KEY_TYPE + COMMA_SEP +
                        VencimentoEntry.COLUMN_DESCRICAO + TEXT_TYPE + COMMA_SEP +
                        VencimentoEntry.COLUMN_VALOR + DOUBLE_TYPE + " )";

        public static final String SQL_DELETE_ENTRIES =
                "DROP TABLE IF EXISTS " + VencimentoEntry.TABLE_NAME;
    }
}
