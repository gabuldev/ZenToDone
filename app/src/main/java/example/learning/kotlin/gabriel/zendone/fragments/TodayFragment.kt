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

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        return inflater!!.inflate(R.layout.fragment_week, container, false)
    }

}// Required empty public constructor