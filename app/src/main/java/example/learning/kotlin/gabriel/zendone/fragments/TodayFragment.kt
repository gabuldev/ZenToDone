package example.learning.kotlin.gabriel.zendone.fragments

import android.content.DialogInterface
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.app.AlertDialog
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import android.widget.RadioButton
import android.widget.Switch
import android.widget.Toast
import example.learning.kotlin.gabriel.zendone.CardInfo
import example.learning.kotlin.gabriel.zendone.R
import example.learning.kotlin.gabriel.zendone.adapters.AdapterCardView
import kotlinx.android.synthetic.main.fragmet_today.*


/**
 * A simple [Fragment] subclass.
 */
class TodayFragment : Fragment() {

    var listcardview : ArrayList<CardInfo>? = ArrayList<CardInfo>()
    override fun onViewCreated(view: View?, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        var mAdapter : AdapterCardView? = null





        //CRIANDO O RECYCLER VIEW E MANDANDO PARA O ADAPTER

        var mRecyclerview = view?.findViewById<RecyclerView>(R.id.recyclerView)
        mRecyclerview?.setHasFixedSize(true)
        mRecyclerview?.layoutManager = LinearLayoutManager(activity)
        mAdapter = AdapterCardView(activity,listcardview)
        mRecyclerview?.adapter = mAdapter


            //USADO PARA CRIAR A FUNÇÃO DO FAB
            floatingActionButton.setOnClickListener {
                /*val intent = Intent(this,CardCreatActivity(listcardview)::class.java)
                startActivity(intent)*/
                val alert = AlertDialog.Builder(activity)
                val newtaskView = this.layoutInflater.inflate(R.layout.card_view_created, null, true)

                //PEGANDO OS COMANDOS CRIAR E CANCELAR
                val titulo = newtaskView.findViewById<EditText>(R.id.edittitle)
                val desc = newtaskView.findViewById<EditText>(R.id.editdescription)
                val priority = newtaskView.findViewById<Switch>(R.id.favsw)


                alert.setView(newtaskView)
                alert.setTitle("Nova Tarefa")
                alert.setPositiveButton("OK",DialogInterface.OnClickListener { dialog, which ->
                    Toast.makeText(activity,"Card criado!",Toast.LENGTH_SHORT).show()
                    


                    mAdapter!!.addItem(CardInfo(titulo.text.toString(),desc.text.toString(),priority.isChecked)) })



                alert.setNegativeButton("CANCEL",DialogInterface.OnClickListener { dialog, which -> })
                alert.show()




            floatingActionButton.setOnLongClickListener {
                Toast.makeText(activity, "CREIDO LONG", Toast.LENGTH_SHORT).show()
                true
            }
        }

    }


    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {

        var rootView = inflater!!.inflate(R.layout.fragmet_today,container,false)


        // Inflate the layout for this fragment
        return rootView
    }


    init {

    }
}// Required empty public constructor

