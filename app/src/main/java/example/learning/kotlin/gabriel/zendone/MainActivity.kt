package example.learning.kotlin.gabriel.zendone

import android.content.Context
import android.content.DialogInterface
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.app.AlertDialog
import android.widget.EditText
import android.widget.Toast
import com.orhanobut.hawk.Hawk
import example.learning.kotlin.gabriel.zendone.R.id.toolbar_main
import example.learning.kotlin.gabriel.zendone.adapters.AdapterPager
import example.learning.kotlin.gabriel.zendone.fragments.TodayFragment
import example.learning.kotlin.gabriel.zendone.fragments.WeekFragment
import kotlinx.android.synthetic.main.activity_main.*
import java.io.FileOutputStream

class MainActivity : AppCompatActivity() {

    var listcard : ArrayList<CardInfo>?=null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(toolbar_main)

        initViewPager()//CRIA OS TABS




    }

    private fun setSupportActionBar(toolbar_main: Int) {}

    fun initViewPager(){
        var pageAdapter : AdapterPager? = null
        //CARREGANDO O TAB LAYOUT
        pageAdapter = AdapterPager(supportFragmentManager)
        pageAdapter!!.addFragments(TodayFragment(), "Today")

        pageAdapter!!.addFragments(WeekFragment(),"Week")

        //ADICIONANDO O PAGEADAPTER PARA O VIEWPAGER
        costomViewPager.adapter = pageAdapter

        //SUBINDO A CONFIG COM O TAB LAYOUT
        costomTabLayout.setupWithViewPager(costomViewPager)

        //CARREAGANDO A HAWK
        Hawk.init(this).build()
    }



}
