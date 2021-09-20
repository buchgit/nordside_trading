package com.nordside_trading

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.webkit.WebView
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.nordside_trading.json.Nomenclature
import com.nordside_trading.viewmodel.NomenclatureItemViewModel
import java.io.Serializable


class FragmentNomenclatureItem:Fragment() {
    private val TAG = FragmentNomenclatureItem::class.simpleName
    private val viewModel by viewModels<NomenclatureItemViewModel>()
    private lateinit var currentNomenclature: Nomenclature
    private lateinit var webView:WebView
    private lateinit var textView_1: TextView
    private lateinit var textView_2: TextView

    companion object {
        fun newInstance(nomenclature: Nomenclature):FragmentNomenclatureItem{
            return FragmentNomenclatureItem().apply {
                arguments = Bundle().apply { putSerializable("NOMENCLATURE",nomenclature) }
            }
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        currentNomenclature = arguments?.getSerializable("NOMENCLATURE") as Nomenclature
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_nomenclature_item,container,false)
        textView_1 = view.findViewById(R.id.tw_fragment_nomenclature_item_1)
        textView_2 = view.findViewById(R.id.tw_fragment_nomenclature_item_2)

        textView_1.setText(currentNomenclature.fullName)
        textView_2.setText(currentNomenclature.unit)

        return view
    }

}