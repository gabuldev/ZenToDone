package example.learning.kotlin.gabriel.zendone

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.app.AlertDialog
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import example.learning.kotlin.gabriel.zendone.R.id.toolbar_main
import example.learning.kotlin.gabriel.zendone.adapters.AdapterCardView
import example.learning.kotlin.gabriel.zendone.adapters.AdapterPager
import example.learning.kotlin.gabriel.zendone.fragments.TodayFragment
import example.learning.kotlin.gabriel.zendone.fragments.WeekFragment
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    var pageAdapter : AdapterPager? = null
    var mAdapter : AdapterCardView? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(toolbar_main)

        //CARREGANDO O TAB LAYOUT
        pageAdapter = AdapterPager(supportFragmentManager)
        pageAdapter!!.addFragments(TodayFragment(),"Today")
        pageAdapter!!.addFragments(WeekFragment(),"Week")

        //ADICIONANDO O PAGEADAPTER PARA O VIEWPAGER
            costomViewPager.adapter = pageAdapter

        //SUBINDO A CONFIG COM O TAB LAYOUT
        costomTabLayout.setupWithViewPager(costomViewPager)


        //USADO PARA CRIAR A FUNÇÃO DO FAB
        fab.setOnClickListener {
            /*val intent = Intent(this,CardCreatActivity(listcardview)::class.java)
            startActivity(intent)*/
            val alert = AlertDialog.Builder(this)
            val newtaskView = this.layoutInflater.inflate(R.layout.card_view_created, null, true)
            alert.setView(newtaskView)
            alert.setTitle("CREATED CARD")
            alert.show()

            //PEGANDO OS COMANDOS CRIAR E CANCELAR
            val titulo = newtaskView.findViewById<EditText>(R.id.edittitle)
            val desc = newtaskView.findViewById<EditText>(R.id.editdescription)

            val btn = newtaskView.findViewById<Button>(R.id.btn_criar) as Button
            btn.setOnClickListener {
                Toast.makeText(this,"Card Criado!", Toast.LENGTH_SHORT).show()
                mAdapter?.addItem(titulo.text.toString(),desc.text.toString(),false)
                isFinishing
            }

        }


        fab.setOnLongClickListener {
            Toast.makeText(this, "CREADO LONG", Toast.LENGTH_SHORT).show()
            true
        }

    }

    private fun setSupportActionBar(toolbar_main: Int) {}
}
