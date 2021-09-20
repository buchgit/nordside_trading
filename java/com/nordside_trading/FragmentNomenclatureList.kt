package com.nordside_trading

import android.content.Context
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
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.nordside_trading.json.Nomenclature
import com.nordside_trading.viewmodel.NomenclatureListViewModel

class FragmentNomenclatureList : Fragment(), FragmentCollection.Callback {

    private val TAG = FragmentNomenclatureList::class.simpleName
    private lateinit var recyclerView: RecyclerView
    private lateinit var textView: TextView
    private var adapter: ItemCollectionAdapter = ItemCollectionAdapter(emptyList())
    private val collectionViewModel by viewModels<NomenclatureListViewModel>()
    private lateinit var collectionId: String
    private var callbacks:CallbackNomenclature?=null

    companion object {
        fun newInstance(id: String): FragmentNomenclatureList {
            val args = Bundle().apply { putString("id", id) }
            return FragmentNomenclatureList().apply { arguments = args }
        }
    }

    interface CallbackNomenclature{
        fun onNomenclatureSelected(nomenclature: Nomenclature)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        collectionId = arguments?.getString("id") ?: "100008" //TODO    подумать, убрать ли хардкор
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_nomenclature_list, container, false)
        textView = view.findViewById(R.id.tw_fragment_nomenclature)
        recyclerView = view.findViewById(R.id.recycler_view_fragment_nomenclature) as RecyclerView
        //recyclerView.layoutManager = GridLayoutManager(context,2)
        recyclerView.layoutManager =
            LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)

        //код ниже - для поворота экрана
        collectionViewModel.getNomenclatureByCollection(collectionId)
            .observe(viewLifecycleOwner, Observer {
                recyclerView.adapter = ItemCollectionAdapter(it)
            })

        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        collectionViewModel.getNomenclatureByCollection(collectionId).observe(viewLifecycleOwner,
            Observer { nomList ->
                //Log.v(TAG, nomList.size.toString())
//                Log.v(
//                    TAG,
//                    collectionViewModel.getNomenclatureByCollection(collectionId).value.toString()
//                )
                adapter = ItemCollectionAdapter(nomList)
            })
    }

    inner class ItemCollectionAdapter(var collectionList: List<Nomenclature>) :
        RecyclerView.Adapter<ItemCollectionHolder>() {

        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemCollectionHolder {
            val inflater = LayoutInflater.from(context)
            val view = inflater.inflate(R.layout.nomenclature_list_view_holder, parent, false)
            return ItemCollectionHolder(view)
        }

        override fun onBindViewHolder(holder: ItemCollectionHolder, position: Int) {
            return holder.bind(collectionList[position])
        }

        override fun getItemCount(): Int {
            return collectionList.size
        }

    }

    inner class ItemCollectionHolder(itemView: View) : RecyclerView.ViewHolder(itemView), View.OnClickListener {
        var cardView: CardView = itemView.findViewById(R.id.card_view_fragment_nomenclature)
        private var textView_title: TextView = itemView.findViewById(R.id.tw_nomenclature_view_holder_1)
        private var textView_lenght: TextView = itemView.findViewById(R.id.tw_nomenclature_view_holder_2)
        private lateinit var currentNomenclature:Nomenclature
        fun bind(nomenclature: Nomenclature) {
            currentNomenclature = nomenclature
            textView_title.setText(currentNomenclature.title)
            textView_lenght.setText(currentNomenclature.length.toString())
        }

        init {
            itemView.setOnClickListener(this)
        }

        override fun onClick(v: View?) {
            callbacks?.onNomenclatureSelected(currentNomenclature)
        }

    }

    override fun onCollectionSelected(id: String) {
        collectionViewModel.getNomenclatureByCollection(id).observe(viewLifecycleOwner,
            Observer { nomList ->
                Log.v(TAG, nomList.size.toString())
                Log.v(TAG, collectionViewModel.getNomenclatureByCollection(id).value.toString())
                adapter = ItemCollectionAdapter(nomList)
            })
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        callbacks = context as CallbackNomenclature
    }

    override fun onDetach() {
        super.onDetach()
        callbacks = null
    }

}