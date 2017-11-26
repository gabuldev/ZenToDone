package example.learning.kotlin.gabriel.zendone.Banco

import android.app.Activity
import android.content.ContentValues
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView

import example.learning.kotlin.gabriel.zendone.R

/**
 * Created by vitor on 26/11/17.
 */

class Control(context: Context) {
    private var db: SQLiteDatabase? = null
    private val banco: Database
    internal var resultado: Long = 0


    init {
        banco = Database(context)
    }

    fun insereDado(title: String, desc: String): String {
        val valores: ContentValues

        db = banco.writableDatabase
        valores = ContentValues()
        valores.put(Database.titulo, title)
        valores.put(Database.desc, desc)
        //  valores.put(bd.isFavo(),favo);
        resultado = db!!.insert(Database.tabela, null, valores)
        db!!.close()

        return if (resultado.toInt() == -1)
            "Erro ao inserir registro"
        else
            "Sucesso"
    }

    inner class insereDado : Activity() {
        override fun onCreate(savedInstaceState: Bundle?) {
            super.onCreate(savedInstaceState)
            setContentView(R.layout.activity_inicial)
            val botao = findViewById<View>(R.id.button) as Button
            botao.setOnClickListener {
                val crud = Control(baseContext)
                val TvTitle = findViewById<View>(R.id.tvTitle) as TextView
                val TvDes = findViewById<View>(R.id.tvDes) as TextView
                val tituloString = TvTitle.text.toString()
                val discString = TvDes.text.toString()
                resultado = crud.insereDado(tituloString, discString).toLong()
            }
        }
    }
}