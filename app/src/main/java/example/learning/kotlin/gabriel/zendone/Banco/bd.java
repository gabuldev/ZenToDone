package example.learning.kotlin.gabriel.zendone.Banco;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by vitor on 26/11/17.
 */


import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

class bd extends SQLiteOpenHelper {
    private static final String ztd = "ztd.db";
    private static final String ID = "_id";
    private static final String tabela = "tarefas";
    private static final String titulo = "titulo";
    private static final String desc = "descricao";
    private static final boolean favo = false;
    private static final int VERSAO = 1;

    public bd(Context context) {
        super(context, getZtd(), null, getVERSAO());
    }

    public static String getZtd() {
        return ztd;
    }

    public static String getID() {
        return ID;
    }

    public static String getTabela() {
        return tabela;
    }

    public static String getTitulo() {
        return titulo;
    }

    public static String getDesc() {
        return desc;
    }

    public static boolean isFavo() {
        return favo;
    }

    public static int getVERSAO() {
        return VERSAO;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String sql = "CREATE TABELA" + getTabela() + "("
                + getID() + "integer primary key autoincrement,"
                + getTitulo() + "text,"
                + getDesc() + "text,"
                + isFavo() + "integer,"
                + ")";
        db.execSQL(sql);

    }


    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS" + getTabela());
        onCreate(db);

    }


}