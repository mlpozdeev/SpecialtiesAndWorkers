package com.example.specialtiesandworkers.presentation.specialty.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.specialtiesandworkers.R
import com.example.specialtiesandworkers.application.SpecialtiesAndWorkersApp
import com.example.specialtiesandworkers.databinding.FragmentSpecialtyBinding
import com.example.specialtiesandworkers.presentation.specialty.viewmodel.SpecialtyViewModel

class SpecialtyFragment : Fragment() {

    private lateinit var viewModel: SpecialtyViewModel

    private var _binding: FragmentSpecialtyBinding? = null

    private val binding get() = _binding!!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val loadSpecialtyUseCase = (requireActivity().application as SpecialtiesAndWorkersApp).applicationComponent
            .getLoadSpecialtyUseCase()

        viewModel = ViewModelProvider(this, object : ViewModelProvider.Factory {
            override fun <T : ViewModel?> create(modelClass: Class<T>): T {
                @Suppress("UNCHECKED_CAST")
                return SpecialtyViewModel(loadSpecialtyUseCase) as T
            }
        }).get(SpecialtyViewModel::class.java)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentSpecialtyBinding.inflate(inflater, container, false)

        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()

        _binding = null
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val adapter = SpecialtyRecyclerViewAdapter()
        binding.specialtyRecyclerView.adapter = adapter
        viewModel.specialtyList.observe(viewLifecycleOwner) {
            adapter.submitList(it)
        }
    }

}