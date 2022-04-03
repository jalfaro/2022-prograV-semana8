package gt.edu.galileo.a2022pvsemana9.view

import android.os.Bundle
import android.text.Editable
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.findNavController
import gt.edu.galileo.a2022pvsemana9.R
import gt.edu.galileo.a2022pvsemana9.databinding.FragmentIngresoBinding
import gt.edu.galileo.a2022pvsemana9.db.Hero
import gt.edu.galileo.a2022pvsemana9.viewmodel.IngresoViewModel


class IngresoFragment : Fragment() {
    private lateinit var binding: FragmentIngresoBinding
    private lateinit var model: IngresoViewModel
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentIngresoBinding.inflate(layoutInflater, container, false)
        model = ViewModelProvider(this).get(IngresoViewModel::class.java)
        binding.btnListado.setOnClickListener {
            binding.root.findNavController().navigate(R.id.action_ingresoFragment_to_listadoFragment)
        }
        binding.btnGrabar.setOnClickListener {
            model.insertHero(Hero(binding.txtNombre.text.toString(), binding.txtEditorial.text.toString()))
            binding.txtNombre.text.clear()
            binding.txtEditorial.text.clear()
            Toast.makeText(context, "Insertado satisfactoriamente", Toast.LENGTH_LONG).show()
        }
        return binding.root
    }

}