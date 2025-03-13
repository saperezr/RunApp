import android.app.Dialog
import android.app.DialogFragment
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AlertDialog
import androidx.fragment.app.DialogFragment

class RegistroExitosoDialog(private val onSave: (String, String) -> Unit) : DialogFragment() {

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        val builder = AlertDialog.Builder(requireContext())

        // Inflar el diseño del modal
        val inflater = LayoutInflater.from(requireContext())
        val view = inflater.inflate(R.layout.dialog_editar_ejercicio, null)

        // Referencias a los campos
        val editNombre = view.findViewById<EditText>(R.id.editNombre)
        val editDuracion = view.findViewById<EditText>(R.id.editDuracion)
        val btnGuardar = view.findViewById<Button>(R.id.btnGuardar)
        val btnCancelar = view.findViewById<Button>(R.id.btnCancelar)

        // Configurar botones
        btnGuardar.setOnClickListener {
            val nombre = editNombre.text.toString()
            val duracion = editDuracion.text.toString()
            onSave(nombre, duracion)  // Enviar datos a la actividad
            dismiss()  // Cerrar modal
        }

        btnCancelar.setOnClickListener {
            dismiss()  // Cerrar modal sin guardar
        }

        builder.setView(view)
        return builder.create()
    }
}
