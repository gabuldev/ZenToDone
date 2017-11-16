package example.learning.kotlin.gabriel.zendone.fragments

import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import example.learning.kotlin.gabriel.zendone.CardInfo
import example.learning.kotlin.gabriel.zendone.R
import example.learning.kotlin.gabriel.zendone.adapters.AdapterCardView


/**
 * A simple [Fragment] subclass.
 */
class TodayFragment : Fragment() {


    override fun onViewCreated(view: View?, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        var listcardview : ArrayList<CardInfo>? = ArrayList<CardInfo>()
        var mAdapter : AdapterCardView? = null




        listcardview?.add(CardInfo("Algebra","Fazer a atividade numero 1",true))
        listcardview?.add(CardInfo("Matematica","Fazer a prova",false))
        listcardview?.add(CardInfo("Calculo I","Fazer a atividade numero 4",false))
        listcardview?.add(CardInfo("Calculo 2","Fazer a atividade numero 5",false))
        listcardview?.add(CardInfo("Fisica 1","Fazer a atividade numero 6",false))
        listcardview?.add(CardInfo("Bispo","Fazer o mousse",false))
        listcardview?.add(CardInfo("Carro","Lavar o carro today",true))


        //CRIANDO O RECYCLER VIEW E MANDANDO PARA O ADAPTER

        var mRecyclerview = view?.findViewById<RecyclerView>(R.id.recyclerView)
        mRecyclerview?.setHasFixedSize(true)
        mRecyclerview?.layoutManager = LinearLayoutManager(activity)
        mAdapter = AdapterCardView(activity,listcardview)
        mRecyclerview?.adapter = mAdapter


    }



    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {

        var rootView = inflater!!.inflate(R.layout.fragmet_today,container,false)

        // Inflate the layout for this fragment
        return rootView
    }

}// Required empty public constructor

