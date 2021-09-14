package com.nordside_trading

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.nordside_trading.model.NomenclatureCollection
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

    inner class ItemCollectionAdapter(var collectionList:List<NomenclatureCollection>):
        RecyclerView.Adapter<ItemCollectionHolder>() {

        init {
            if (collectionList.isEmpty()){
                collectionList = listOf(NomenclatureCollection(UUID.randomUUID(),"0 collection")
                    ,NomenclatureCollection(UUID.randomUUID(),"1 collection")
                    ,NomenclatureCollection(UUID.randomUUID(),"2 collection")
                    ,NomenclatureCollection(UUID.randomUUID(),"3 collection")
                    ,NomenclatureCollection(UUID.randomUUID(),"4 collection")
                    ,NomenclatureCollection(UUID.randomUUID(),"5 collection")
                    ,NomenclatureCollection(UUID.randomUUID(),"6 collection")
                    ,NomenclatureCollection(UUID.randomUUID(),"7 collection")
                    ,NomenclatureCollection(UUID.randomUUID(),"8 collection")
                    ,NomenclatureCollection(UUID.randomUUID(),"9 collection")
                    ,NomenclatureCollection(UUID.randomUUID(),"10 collection")
                    ,NomenclatureCollection(UUID.randomUUID(),"11 collection")
                    ,NomenclatureCollection(UUID.randomUUID(),"12 collection")
                    ,NomenclatureCollection(UUID.randomUUID(),"13 collection")
                    ,NomenclatureCollection(UUID.randomUUID(),"14 collection")
                    ,NomenclatureCollection(UUID.randomUUID(),"15 collection")
                    ,NomenclatureCollection(UUID.randomUUID(),"16 collection")
                    ,NomenclatureCollection(UUID.randomUUID(),"17 collection")
                    ,NomenclatureCollection(UUID.randomUUID(),"18 collection")
                    ,NomenclatureCollection(UUID.randomUUID(),"19 collection")
                    ,NomenclatureCollection(UUID.randomUUID(),"20 collection")
                    ,NomenclatureCollection(UUID.randomUUID(),"21 collection"))
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
        var cardView: CardView = itemView.findViewById(R.id.card_view_fragment_item_collection)
        var textView:TextView = itemView.findViewById(R.id.tw_item_collection_view_holder)

        fun bind(nomenclatureCollection: NomenclatureCollection){
            textView.setText(nomenclatureCollection.title)
        }
    }

}