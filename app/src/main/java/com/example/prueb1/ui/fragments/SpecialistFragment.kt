package com.example.prueb1.ui.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import androidx.navigation.fragment.navArgs
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.prueb1.ui.adapters.DoctorAdapter
import com.example.prueb1.data.models.DoctorItemModel
import com.example.prueb1.R
import com.example.prueb1.data.models.ServiceItemModel
import com.example.prueb1.databinding.FragmentSpecialistBinding


class SpecialistFragment : Fragment() {

    private var _binding: FragmentSpecialistBinding? = null
    private val binding: FragmentSpecialistBinding get() = _binding!!
    private val args: SpecialistFragmentArgs by navArgs()
    private lateinit var doctorAdapter: DoctorAdapter
    private lateinit var categories: MutableList<String>

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentSpecialistBinding.inflate(layoutInflater,container,false)
        return binding.root
        // Inflate the layout for this fragment
    }

    override fun onStart() {
        super.onStart()

        doctorAdapter= DoctorAdapter(listOf())
        binding.specialistFragmentRecycler.apply {
            adapter = doctorAdapter
            layoutManager = LinearLayoutManager(requireContext())
        }

        val services = listOf(
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

        categories = services.map { it.title }.toMutableList()
        categories.add(0,"Todos")

        val specialists = listOf(
            DoctorItemModel("1", "Dr Maria Gutierres","Especialista",
                R.drawable.doc4.toString(),5,"El mejor doctor que puedes encontrar","300+ pacientes"),
            DoctorItemModel("2", "Dr Antonia Santos","Pediatria",
                R.drawable.doc3.toString(),4,"El mejor doctor que puedes encontrar","200+ pacientes"),
            DoctorItemModel("3", "Dr Miguel Gonzales","Odontologia",
                R.drawable.doc1.toString(),1,"El mejor doctor que puedes encontrar","500+ pacientes"),
            DoctorItemModel("4", "Dr Elkin Elif","Dermatologia",
                R.drawable.doc1.toString(),2,"El mejor doctor que puedes encontrar","300+ pacientes") ,
            DoctorItemModel("5", "Dr Daniela Clif","General",
                R.drawable.doc4.toString(),3,"El mejor doctor que puedes encontrar","300+ pacientes")


        )

        if(args.search){

            binding.specialistFragmentRecyclerSearchLayout.visibility = View.VISIBLE
            binding.specialistFragmentRecyclerTitle.visibility = View.GONE
            binding.specialistFragmentTitle.text = getString(R.string.specialist_title)
            binding.specialistFragmentSubtitle.text = getString(R.string.specialist_subtitle)
            doctorAdapter.updateDataset(specialists)
            binding.specialistFragmentRecyclerSearch.setAdapter(ArrayAdapter(requireContext(),android.R.layout.simple_dropdown_item_1line,categories))
            binding.specialistFragmentRecyclerSearch.setOnItemClickListener { parent, view, position, id ->
                if (position == 0) {
                    doctorAdapter.updateDataset(specialists)
                } else {
                    val category = categories[position]
                    doctorAdapter.updateDataset(specialists.filter { it -> it.Speciality == category })
                }
            }
        } else {
            binding.specialistFragmentRecyclerSearchLayout.visibility = View.GONE
            binding.specialistFragmentRecyclerTitle.visibility = View.VISIBLE
            binding.specialistFragmentTitle.text = args.name
            binding.specialistFragmentSubtitle.text = args.description
            doctorAdapter.updateDataset(specialists.filter {it -> it.Speciality == args.name})
        }
    }

}