package com.example.runapp

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.navigation.fragment.findNavController

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [CrearEntrenamientoFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class CrearEntrenamientoFragment : Fragment() {
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

        val root = inflater.inflate(R.layout.fragment_crear_entrenamiento, container, false)

        val btnAlarmas = root.findViewById<Button>(R.id.buttonGuardarEntrenamiento)

        btnAlarmas.setOnClickListener {
            val dialog = EntrenamientoCreadoDialog()
            dialog.show(parentFragmentManager, "EntrenamientoCreadoDialog")
        }
        val btnEjercicio = root.findViewById<Button>(R.id.buttonAgregarEjercicio1)
        val btnEjercicio2 = root.findViewById<Button>(R.id.buttonAgregarEjercicio2)
        val btnFase = root.findViewById<Button>(R.id.buttonAgregarFase)

        btnEjercicio.setOnClickListener{
            val dialog2 = AgregarEjercicioDialog()
            dialog2.show(parentFragmentManager, "AgregarEjercicioDialog")
        }

        btnEjercicio2.setOnClickListener{
            val dialog2 = AgregarEjercicioDialog()
            dialog2.show(parentFragmentManager, "AgregarEjercicioDialog")
        }

        btnFase.setOnClickListener{
            val dialog3 = AgregarFaseDialog()
            dialog3.show(parentFragmentManager, "AgregarFaseDialog")
        }

        val btnVolver = root.findViewById<Button>(R.id.buttonVolverEntrenamiento2)
        btnVolver.setOnClickListener{
            findNavController().navigateUp()
        }

        return root
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment CrearEntrenamientoFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            CrearEntrenamientoFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}