package com.example.prueb1.ui.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.prueb1.interfaces.OnServiceClickListener
import com.example.prueb1.R
import com.example.prueb1.ui.adapters.ServiceAdapter
import com.example.prueb1.data.models.ServiceItemModel
import com.example.prueb1.databinding.FragmentHomeBinding


class HomeFragment : Fragment() {

    private var _binding: FragmentHomeBinding? = null
    private val binding: FragmentHomeBinding get() = _binding!!
    private lateinit var serviceAdapter: ServiceAdapter


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentHomeBinding.inflate(layoutInflater,container,false)
        return binding.root

    }

    override fun onStart() {
        super.onStart()
        serviceAdapter = ServiceAdapter(listOf(
            ServiceItemModel(
           "2","General","Los mejores especialistas en medicina general", R.drawable.ico_general.toString()

       ),
            ServiceItemModel(
                "1","Especialista","Los mejores medicos especialistas ", R.drawable.ico_especialidad.toString()

            ),

            ServiceItemModel(
                "3","Odontologia","Los mejores especialistas en odontologia", R.drawable.ico_odontologia.toString()

            ),

            ServiceItemModel(
                "4","Dermatologia","Los mejores medicos especialistas en dermatologia", R.drawable.ico_dermatologia.toString()

            ),
            ServiceItemModel(
                "5","Pediatria","Los mejores medicos especialistas en pediatria", R.drawable.ico_pediatria.toString()

            )
        )

       )
        serviceAdapter.listener = object : OnServiceClickListener {
            override fun onClick(item: ServiceItemModel) {
                val direction =
                    HomeFragmentDirections.actionHomeFragmentToSpecialistFragment()
                direction.name= item.title
                direction.description= item.description
                direction.search = false
                findNavController().navigate(direction)
            }

        }
        binding.homeFragmentRecycler.apply {
            adapter = serviceAdapter
            layoutManager = LinearLayoutManager(requireContext())
        }
    }

}