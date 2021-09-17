package com.nordside_trading

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.nordside_trading.json.Category
import com.nordside_trading.viewmodel.FragmentCategoryViewModel
import java.util.*
import androidx.lifecycle.Observer

class FragmentCategory: Fragment() {
    private lateinit var recyclerView: RecyclerView
    private val EMPTY_TITLE = "empty title of category"
    private val adapter: CategoryAdapter = CategoryAdapter(emptyList())
    private val categoryViewModel by viewModels<FragmentCategoryViewModel>()

    companion object{
        fun newInstance():FragmentCategory{
            return FragmentCategory()
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_category,container,false)
        recyclerView = view.findViewById(R.id.recycler_view_fragment_category) as RecyclerView
        recyclerView.layoutManager = LinearLayoutManager(context,LinearLayoutManager.HORIZONTAL,false)
        categoryViewModel.categoryList.observe(viewLifecycleOwner,
        Observer {
            recyclerView.adapter = CategoryAdapter(it)
        })

        return view
    }



    //сюда прилетает вьюха (через конструктор) и модель (через bind), вьюху заполняем по модели
    inner class CategoryHolder(view: View) : RecyclerView.ViewHolder(view) {

        private var cardView:CardView = itemView.findViewById(R.id.card_view_fragment_category)
        private var textView:TextView = itemView.findViewById(R.id.tw_category_view_holder)

        fun bind(category: Category?){
            textView.text = category?.title ?: EMPTY_TITLE
        }
    }

    //adapter
    inner class CategoryAdapter(var categoryList: List<Category>): RecyclerView.Adapter<CategoryHolder>() {

//        init {
//            if (categoryList.isEmpty()){
//                categoryList = listOf(
//                    Category("first category","any description"),
//                    Category("second category","any description"),
//                    Category("third category","any description")
//                )
//            }
//        }

        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CategoryHolder {
            val inflater = LayoutInflater.from(context)
            val view:View = inflater.inflate(R.layout.category_view_holder,parent,false)
            return CategoryHolder(view)
        }

        override fun onBindViewHolder(holder: CategoryHolder, position: Int) {
            holder.bind(categoryList[position])
        }

        override fun getItemCount(): Int {
            return categoryList.size
        }

    }

}