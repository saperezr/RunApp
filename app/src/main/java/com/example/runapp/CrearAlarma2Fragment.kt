package com.example.runapp

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.AutoCompleteTextView
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
 * Use the [CrearAlarma2Fragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class CrearAlarma2Fragment : Fragment() {
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
        val root = inflater.inflate(R.layout.fragment_crear_alarma2, container, false)

        val btnAlarmas = root.findViewById<Button>(R.id.buttonGuardarAlarma)

        btnAlarmas.setOnClickListener {
            val dialog = AlarmaCreadaDialog()
            dialog.show(parentFragmentManager, "AlarmaCreadaDialog")
        }
        val btnVolver = root.findViewById<Button>(R.id.buttonVolverCrearAlarma2)
        btnVolver.setOnClickListener{
            findNavController().navigateUp()
        }
        return root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val opciones = listOf("Entrenamiento 1", "Entrenamiento 2", "Entrenamiento 3")
        val autoCompleteTextView: AutoCompleteTextView = view.findViewById(R.id.spinnerOpciones)
        val adapter = ArrayAdapter(requireContext(), android.R.layout.simple_list_item_1, opciones)

        autoCompleteTextView.setAdapter(adapter)

        // Abre la lista cuando el usuario toca el campo
        autoCompleteTextView.setOnClickListener {
            autoCompleteTextView.showDropDown()
        }

        val switchToggle = view.findViewById<Switch>(R.id.switchEntrenamientoPredefinido)

        val linearLayoutOpciones = view.findViewById<LinearLayout>(R.id.linearLayoutTiempoEjercicio)
        val entrenamientosPredefinidos = view.findViewById<LinearLayout>(R.id.textInputLayout)
        switchToggle.setOnCheckedChangeListener { _, isChecked ->
            if (isChecked) {
                entrenamientosPredefinidos.visibility = View.GONE
                linearLayoutOpciones.visibility = View.VISIBLE
            } else {
                entrenamientosPredefinidos.visibility = View.VISIBLE
                linearLayoutOpciones.visibility = View.GONE

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
         * @return A new instance of fragment CrearAlarma2Fragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            CrearAlarma2Fragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}