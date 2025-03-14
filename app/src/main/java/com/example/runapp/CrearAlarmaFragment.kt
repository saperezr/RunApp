package com.example.runapp

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.LinearLayout
import android.widget.Switch
import androidx.navigation.fragment.findNavController

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [CrearAlarmaFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class CrearAlarmaFragment : Fragment() {
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
        // Inflate the layout for this fragment
        val root = inflater.inflate(R.layout.fragment_crear_alarma, container, false)

        val btnAlarmas = root.findViewById<Button>(R.id.buttonContinuar)

        btnAlarmas.setOnClickListener{
            findNavController().navigate(R.id.action_crearAlarmaFragment_to_crearAlarma2Fragment)
        }
        val btnVolver = root.findViewById<Button>(R.id.buttonVolverCrearAlarma)
        btnVolver.setOnClickListener{
            findNavController().navigateUp()
        }


        return root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val switchToggle = view.findViewById<Switch>(R.id.switch1)
        val linearLayoutOpciones = view.findViewById<LinearLayout>(R.id.linearLayoutFechaEntrenamiento)

        switchToggle.setOnCheckedChangeListener { _, isChecked ->
            if (isChecked) {
                linearLayoutOpciones.visibility = View.GONE // Oculta el LinearLayout
            } else {
                linearLayoutOpciones.visibility = View.VISIBLE // Lo muestra
            }
        }
    }


    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment CrearAlarmaFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            CrearAlarmaFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}