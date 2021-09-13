package com.nordside_trading

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.nordside_trading.model.Partner
import java.util.*

class FragmentPartner: Fragment() {

    private lateinit var recyclerView: RecyclerView
    private val adapter: PartnerAdapter = PartnerAdapter(emptyList())

    companion object{
        fun newInstance():FragmentPartner{
            return FragmentPartner()
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val view = inflater.inflate(R.layout.fragment_partner,container,false)
        recyclerView = view.findViewById(R.id.recycler_view_fragment_partner) as RecyclerView
        recyclerView.layoutManager = LinearLayoutManager(context,LinearLayoutManager.HORIZONTAL,false)
        recyclerView.adapter = adapter

        return view
    }

    inner class PartnerViewHolder(itemView:View):RecyclerView.ViewHolder(itemView){

        var textView:TextView = itemView.findViewById(R.id.tw_partner_view_holder)

        fun bind(partner: Partner){
            textView.setText(partner.title)
        }
    }

    inner class PartnerAdapter(var partnerList:List<Partner>):RecyclerView.Adapter<PartnerViewHolder>(){

        init {
            if (partnerList.isEmpty()) {
                partnerList = listOf(
                    Partner(UUID.randomUUID(), "partner 1"),
                    Partner(UUID.randomUUID(), "partner 2"),
                    Partner(UUID.randomUUID(), "partner 3"),
                    Partner(UUID.randomUUID(), "partner 4"),
                    Partner(UUID.randomUUID(), "partner 5")
                )
            }
        }

        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PartnerViewHolder {
            val inflater:LayoutInflater = LayoutInflater.from(context)
            val view = inflater.inflate(R.layout.partner_view_holder,parent,false)
            return PartnerViewHolder(view)
        }

        override fun onBindViewHolder(holder: PartnerViewHolder, position: Int) {
            holder.bind(partnerList[position])
        }

        override fun getItemCount(): Int {
            return partnerList.size
        }

    }
}
