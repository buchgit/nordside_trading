package com.nordside_trading

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.nordside_trading.model.ItemCollection
import java.util.*

class FragmentCollection:Fragment() {

    private lateinit var recyclerView: RecyclerView
    private val adapter: ItemCollectionAdapter = ItemCollectionAdapter(emptyList())

    companion object{
        fun newInstance():FragmentCollection{
            return FragmentCollection()
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_collection,container,false)
        recyclerView = view.findViewById(R.id.recycler_view_fragment_collection) as RecyclerView
        //recyclerView.layoutManager = GridLayoutManager(context,2)
        recyclerView.layoutManager = LinearLayoutManager(context,LinearLayoutManager.VERTICAL,false)
        recyclerView.adapter = adapter
        return view
    }

    inner class ItemCollectionAdapter(var collectionList:List<ItemCollection>):
        RecyclerView.Adapter<ItemCollectionHolder>() {

        init {
            if (collectionList.isEmpty()){
                collectionList = listOf(ItemCollection(UUID.randomUUID(),"0 collection")
                    ,ItemCollection(UUID.randomUUID(),"1 collection")
                    ,ItemCollection(UUID.randomUUID(),"2 collection")
                    ,ItemCollection(UUID.randomUUID(),"3 collection")
                    ,ItemCollection(UUID.randomUUID(),"4 collection")
                    ,ItemCollection(UUID.randomUUID(),"5 collection")
                    ,ItemCollection(UUID.randomUUID(),"6 collection"))
            }
        }

        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemCollectionHolder {
            val inflater = LayoutInflater.from(context)
            val view = inflater.inflate(R.layout.item_collection_view_holder,parent,false)
            return ItemCollectionHolder(view)
        }

        override fun onBindViewHolder(holder: ItemCollectionHolder, position: Int) {
            return holder.bind(collectionList[position])
        }

        override fun getItemCount(): Int {
            return collectionList.size
        }

    }

    inner class ItemCollectionHolder(itemView: View): RecyclerView.ViewHolder(itemView){

        var textView:TextView = itemView.findViewById(R.id.tw_item_collection_view_holder)

        fun bind(itemCollection: ItemCollection){
            textView.setText(itemCollection.title)
        }
    }

}