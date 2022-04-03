package gt.edu.galileo.a2022pvsemana9.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import gt.edu.galileo.a2022pvsemana9.R
import gt.edu.galileo.a2022pvsemana9.databinding.FragmentListadoBinding
import gt.edu.galileo.a2022pvsemana9.viewmodel.ListadoViewModel


class ListadoFragment : Fragment() {
    private lateinit var binding: FragmentListadoBinding
    private lateinit var model: ListadoViewModel
    private val adapter = HeroAdapter(arrayListOf())
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentListadoBinding.inflate(layoutInflater, container, false)
        model = ViewModelProvider(this).get(ListadoViewModel::class.java)
        binding.rvListado.layoutManager = LinearLayoutManager(context)
        binding.rvListado.adapter = adapter
        model.heroList.observe(viewLifecycleOwner, {
            adapter.updateData(it)
        })
        model.loadHero()
        return binding.root
    }

}