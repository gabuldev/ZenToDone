package example.learning.kotlin.gabriel.zendone.Banco

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

/**
 * Created by vitor on 26/11/17.
 */

class Database(context: Context) : SQLiteOpenHelper(context, ztd, null, versao) {
    override fun onCreate(db: SQLiteDatabase) {
        val sql = ("CREATE TABELA" + tabela + "("
                + id + "integer primary key autoincrement,"
                + titulo + "text,"
                + desc + "text,"
                + isFavo + "integer,"
                + ")")
        db.execSQL(sql)
    }

    override fun onUpgrade(db: SQLiteDatabase, oldVersion: Int, newVersion: Int) {
        db.execSQL("DROP TABLE IF EXISTS" + tabela)
        onCreate(db)
    }

    companion object {
        val ztd = "ztd.db"
        val id = "_id"
        val tabela = "tarefas"
        val titulo = "titulo"
        val desc = "descricao"
        val isFavo = false
        val versao = 1
    }
}