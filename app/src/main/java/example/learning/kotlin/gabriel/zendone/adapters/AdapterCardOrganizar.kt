package example.learning.kotlin.gabriel.zendone.adapters

/**
 * Created by vitor on 26/11/17.
 */
import android.content.Context
import android.content.DialogInterface
import android.support.design.widget.Snackbar
import android.support.v7.app.AlertDialog
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import example.learning.kotlin.gabriel.zendone.CardInfo
import example.learning.kotlin.gabriel.zendone.R
import java.util.*


class AdapterCardOrganizar(val context: Context, private val mNotificationListModelArrayList: ArrayList<CardInfo>?) : RecyclerView.Adapter<AdapterCardOrganizar.ViewHolder>() {

    var cardinfo: CardInfo? = null


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val itemLayoutView = LayoutInflater.from(parent.context).inflate(
                R.layout.card_view_organizar, parent, false)

// create ViewHolder
        val viewHolder = ViewHolder(itemLayoutView)
        return viewHolder
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        if (mNotificationListModelArrayList != null) {
            holder.tvTitle.text = mNotificationListModelArrayList.get(position).title
            holder.tvDes.text = mNotificationListModelArrayList.get(position).description
            holder.swFav.isChecked = mNotificationListModelArrayList.get(position).priorite
        }

//        var btn : Button? = null
//        btn!!.setOnClickListener(View.OnClickListener {
//
//        })

        /**
         * **
         * *
         * *
         * *
         * *
         * *
         * *
         * *
         * *
         * *
         * *
         * *
         * *
         * *
         * *
         * *
         * **
         * *
         * *
         * *
         * *
         *
         */

        holder.itemView.setOnClickListener {

            var alertEdit = AlertDialog.Builder(context)
            var inflater: View = LayoutInflater.from(context).inflate(R.layout.card_view_edited,null)


            alertEdit.setView(inflater)



            //TEM QUE VERIFICAR SE TA INDO
            var titulo = inflater.findViewById<EditText>(R.id.edittitle)
            var desc = inflater.findViewById<EditText>(R.id.editdescription)
            var swfav = inflater.findViewById<Switch>(R.id.favsw)
            titulo.setText(mNotificationListModelArrayList!!.get(position).title)
            desc.setText(mNotificationListModelArrayList!!.get(position).description)
            swfav.setChecked(mNotificationListModelArrayList!!.get(position).priorite)


            alertEdit.setTitle("Editar Tarefa")
            alertEdit.setPositiveButton("OK", DialogInterface.OnClickListener { dialog, which ->


                this!!.addItem(CardInfo(titulo.text.toString(),desc.text.toString(),swfav.isChecked))
                this!!.removeItem(position)


            })

            alertEdit.setNegativeButton("CANCEL", DialogInterface.OnClickListener { dialog, which -> })
            alertEdit.show()

        }

        //FUNCOES PARA CLICK DEMORADO
        holder.itemView.setOnLongClickListener {


            var alertDel = AlertDialog.Builder(context)

            alertDel.setTitle("Excluir")
            alertDel.setMessage("Tem certeza que deseja excluir essa tarefa?")
            alertDel.setPositiveButton("SIM", DialogInterface.OnClickListener { dialog, which ->
                var snackbar = Snackbar.make(holder.itemView, "Card Removido", Snackbar.LENGTH_LONG)
                cardinfo = mNotificationListModelArrayList?.get(position)
                removeItem(position)
                snackbar.setAction("DESFAZER", View.OnClickListener { addItem(this.cardinfo!!) })
                snackbar.show()
            })

            alertDel.setNegativeButton("CANCELAR", DialogInterface.OnClickListener { dialog, which -> })
            alertDel.show()
            true
        }
    }

    override fun getItemCount(): Int {
        return mNotificationListModelArrayList!!.size
    }

    fun addItem(cardInfo: CardInfo) {
        mNotificationListModelArrayList?.add(cardInfo)
        if (mNotificationListModelArrayList != null) {
            notifyItemInserted(mNotificationListModelArrayList.size)
        }
        notifyDataSetChanged()
    }

    fun addItem(title: String, description: String, fav: Boolean) {
        mNotificationListModelArrayList?.add(CardInfo(title, description, fav))
        if (mNotificationListModelArrayList != null) {
            notifyItemInserted(mNotificationListModelArrayList.size)
            notifyDataSetChanged()
        }
    }

    fun removeItem(position: Int) {
        if (mNotificationListModelArrayList != null) {
            mNotificationListModelArrayList.removeAt(position)
            notifyItemRemoved(position)
            notifyItemRangeChanged(position, mNotificationListModelArrayList.size)
        }
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        var tvTitle: TextView
        var tvDes: TextView
        var swFav: Switch

        init {
            tvTitle = itemView.findViewById<TextView>(R.id.tvTitle) as TextView
            tvDes = itemView.findViewById<TextView>(R.id.tvDes) as TextView
            swFav = itemView.findViewById<Switch>(R.id.favsw) as Switch
        }
    }
}