package com.example.nav_arch_com

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.setupWithNavController
import com.google.android.material.navigation.NavigationView
import kotlinx.android.synthetic.main.fragment_blank3.view.*

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [BlankFragment4.newInstance] factory method to
 * create an instance of this fragment.
 */
class BlankFragment4 : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // получаем ссылку на макет фрагмента
        val fragmentLayout = inflater.inflate(R.layout.fragment_blank4, container, false)

        // получаем ссылку на NavController (навигационный контроллер)
        val navController = NavHostFragment.findNavController(this)

        // включаем нижнее меню для данного фрагмента
        val bottomBar = view?.findViewById<NavigationView>(R.id.bottom_nav_view)
        bottomBar?.setupWithNavController(navController)
        fragmentLayout.bottom_nav_view.setOnNavigationItemSelectedListener { item ->
            navController.navigate(item.itemId)
            return@setOnNavigationItemSelectedListener true
        }

        // возвращаем макет фрагмента
        return fragmentLayout
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment BlankFragment4.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            BlankFragment4().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}