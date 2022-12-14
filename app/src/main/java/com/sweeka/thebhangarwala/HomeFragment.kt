package com.sweeka.thebhangarwala

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import androidx.fragment.app.Fragment


private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

class HomeFragment : Fragment() {
    private var param1: String? = null
    private var param2: String? = null

    lateinit var PAPER:ImageButton
    lateinit var BOTTLES:ImageButton
    lateinit var METALS:ImageButton
    lateinit var COMPUTER:ImageButton
    lateinit var BOOKS:ImageButton
    lateinit var OLD_ITEM:ImageButton

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_home, container, false)
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        PAPER = view.findViewById(R.id.paper_scrap)
        BOTTLES = view.findViewById(R.id.plastic_bottle_scrap)
        METALS = view.findViewById(R.id.metals)
        COMPUTER = view.findViewById(R.id.computer_scrap)
        BOOKS = view.findViewById(R.id.books_scrap)
        OLD_ITEM = view.findViewById(R.id.old_scrap)
        super.onViewCreated(view, savedInstanceState)

        PAPER.setOnClickListener {
           var i = Intent(activity,ProductListActivity::class.java)
            i.putExtra("categories","paper")
            startActivity(i)
        }
        BOTTLES.setOnClickListener {
            var i = Intent(activity,ProductListActivity::class.java)
            i.putExtra("categories","bottles")
            startActivity(i)
        }
        METALS.setOnClickListener {
            var i = Intent(activity,ProductListActivity::class.java)
            i.putExtra("categories","metals")
            startActivity(i)
        }
        COMPUTER.setOnClickListener {
            var i = Intent(activity,ProductListActivity::class.java)
            i.putExtra("categories","computer")
            startActivity(i)
        }
        BOOKS.setOnClickListener {
            var i = Intent(activity,ProductListActivity::class.java)
            i.putExtra("categories","books")
            startActivity(i)
        }
        OLD_ITEM.setOnClickListener {
            var i = Intent(activity,ProductListActivity::class.java)
            i.putExtra("categories","old_item")
            startActivity(i)
        }
    }

    companion object {
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            HomeFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}