package example.learning.kotlin.gabriel.zendone.adapters

import android.content.Context
import android.support.design.widget.Snackbar
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import example.learning.kotlin.gabriel.zendone.CardInfo
import example.learning.kotlin.gabriel.zendone.R
import java.util.ArrayList


class AdapterCardView(val context: Context, private val mNotificationListModelArrayList: ArrayList<CardInfo>?) : RecyclerView.Adapter<AdapterCardView.ViewHolder>() {

    var cardinfo : CardInfo?=null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val itemLayoutView = LayoutInflater.from(parent.context).inflate(
                R.layout.card_view_notification, parent, false)

// create ViewHolder
        val viewHolder = ViewHolder(itemLayoutView)
        return viewHolder
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {


        if (mNotificationListModelArrayList != null) {
            holder.tvTitle.text = mNotificationListModelArrayList.get(position).title
            holder.tvDes.text = mNotificationListModelArrayList.get(position).description
        }

        //FUNÇOES REFERENT A CLICK NO CARD

        //FUNÇOES DE CLICK PARA CLICK RAPIDO
        holder.itemView.setOnClickListener {
            Toast.makeText(context,"Positon eh: " + position, Toast.LENGTH_SHORT).show()
        }

        //FUNCOES PARA CLICK DEMORADO
        holder.itemView.setOnLongClickListener {
            val snackbar = Snackbar.make(holder.itemView,"Card Removido",Snackbar.LENGTH_LONG)
            cardinfo = mNotificationListModelArrayList?.get(position)
            removeItem(position)
            snackbar.setAction("UNDO", View.OnClickListener {addItem(this!!.cardinfo!!) })
            snackbar.show()
            true
        }

    }

    override fun getItemCount(): Int {
        return mNotificationListModelArrayList!!.size
    }

    fun addItem(cardInfo: CardInfo){
        mNotificationListModelArrayList?.add(cardInfo)
        if (mNotificationListModelArrayList != null) {
            notifyItemInserted(mNotificationListModelArrayList.size)
        }
        notifyDataSetChanged()
    }

    fun addItem(title : String,description: String , fav : Boolean){
        mNotificationListModelArrayList?.add(CardInfo(title,description,fav))
        if (mNotificationListModelArrayList != null) {
            notifyItemInserted(mNotificationListModelArrayList.size)
            notifyDataSetChanged()
        }
    }

    fun removeItem(position: Int){
        if (mNotificationListModelArrayList != null) {
            mNotificationListModelArrayList.removeAt(position)
            notifyItemRemoved(position)
            notifyItemRangeChanged(position,mNotificationListModelArrayList.size)
        }
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        var tvTitle: TextView
        var tvDes: TextView

        init {
            tvTitle = itemView.findViewById<TextView>(R.id.tvTitle) as TextView
            tvDes = itemView.findViewById<TextView>(R.id.tvDes) as TextView
        }
    }
}
