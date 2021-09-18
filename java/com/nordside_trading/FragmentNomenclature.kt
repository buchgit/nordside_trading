package com.nordside_trading

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.nordside_trading.json.NomenclatureCollection
import com.nordside_trading.model.Nomenclature
import com.nordside_trading.viewmodel.FragmentCollectionViewModel
import com.nordside_trading.viewmodel.NomenclatureViewModel

class FragmentNomenclature : Fragment(){

    private val TAG = FragmentNomenclature::class.simpleName
    private lateinit var recyclerView: RecyclerView
    private lateinit var textView: TextView
    private var adapter: ItemCollectionAdapter = ItemCollectionAdapter(emptyList())
    private val collectionViewModel by viewModels<NomenclatureViewModel>()

    companion object{
        fun newInstance():FragmentNomenclature{
            return FragmentNomenclature()
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_nomenclature,container,false)
        textView = view.findViewById(R.id.tw_fragment_nomenclature)
        recyclerView = view.findViewById(R.id.recycler_view_fragment_nomenclature) as RecyclerView
        recyclerView.layoutManager = GridLayoutManager(context,2)
        //recyclerView.layoutManager = LinearLayoutManager(context, LinearLayoutManager.VERTICAL,false)

        //код ниже - для поворота экрана
        collectionViewModel.nomenclatureList?.observe(viewLifecycleOwner, Observer{
            recyclerView.adapter = ItemCollectionAdapter(it)
        })

        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        collectionViewModel.nomenclatureList?.observe(viewLifecycleOwner,
            Observer {nomList->
                Log.v(TAG,nomList.size.toString())
                Log.v(TAG, collectionViewModel.nomenclatureList!!.value.toString())
                adapter = ItemCollectionAdapter(nomList)
            })
    }

    inner class ItemCollectionAdapter(var collectionList:List<Nomenclature>):
        RecyclerView.Adapter<ItemCollectionHolder>() {

        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemCollectionHolder {
            val inflater = LayoutInflater.from(context)
            val view = inflater.inflate(R.layout.nomenclature_view_holder,parent,false)
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
        var cardView: CardView = itemView.findViewById(R.id.card_view_fragment_nomenclature)
        var textView: TextView = itemView.findViewById(R.id.tw_nomenclature_view_holder)

        fun bind(nomenclatureCollection: Nomenclature){
            textView.setText(nomenclatureCollection.title)
        }
    }

}