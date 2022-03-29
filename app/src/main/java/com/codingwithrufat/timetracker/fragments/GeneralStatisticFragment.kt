package com.codingwithrufat.timetracker.fragments


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.codingwithrufat.timetracker.R
import com.codingwithrufat.timetracker.adapters.GenericStatisticAdapter
import com.codingwithrufat.timetracker.databinding.FragmentGeneralStatisticBinding

class GeneralStatisticFragment : Fragment() {
    lateinit var binding:FragmentGeneralStatisticBinding
    private var isClicked = false
    private var isProjectSection = true
    private var dueTo = "daily"


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {

        binding = FragmentGeneralStatisticBinding.inflate(inflater)
        setClickListeners()
        assignTheRecyclerView()

        return binding.root
    }

    private fun setClickListeners() {
        binding.projectReturnBackPro.setOnClickListener(View.OnClickListener {
            requireActivity().onBackPressed()
        })

        binding.linearChangeSectionPro.setOnClickListener(View.OnClickListener {
            if(!isClicked){
                releaseAnotherText()
            }else{
                removeAnotherText()
            }
        })

        binding.selectedTextPro.setOnClickListener(View.OnClickListener {
            removeAnotherText()

            if(isProjectSection){
                binding.selectedTextPro.setText("Prayektlər")
                binding.mainTextPro.setText("Kateqoriyalar")
                isProjectSection = false

            }else{
                binding.selectedTextPro.setText("Kateqoriyalar")
                binding.mainTextPro.setText("Prayektlər")
                isProjectSection = true
            }
            assignTheRecyclerView()
        })

        binding.daily.setOnClickListener(View.OnClickListener {
            binding.daily.setText(R.string.daily)
            binding.monthly.setText(R.string.monthly_base)
            binding.weekly.setText(R.string.weekly_base)
            dueTo = "daily"
            assignTheRecyclerView()


        })

        binding.monthly.setOnClickListener(View.OnClickListener {
            binding.daily.setText(R.string.daily_base)
            binding.monthly.setText(R.string.monthly)
            binding.weekly.setText(R.string.weekly_base)
            dueTo = "monthly"
            assignTheRecyclerView()
        })

        binding.weekly.setOnClickListener(View.OnClickListener {
            binding.daily.setText(R.string.daily_base)
            binding.monthly.setText(R.string.monthly_base)
            binding.weekly.setText(R.string.weekly)
            dueTo = "weekly"
            assignTheRecyclerView()
        })


    }

    private fun assignTheRecyclerView() {
         var adapter = GenericStatisticAdapter(requireContext(),isProjectSection,dueTo)
        binding.myRecyclerViewPro.layoutManager = LinearLayoutManager(requireContext(),LinearLayoutManager.VERTICAL,false)
        binding.myRecyclerViewPro.adapter = adapter
    }

    private fun removeAnotherText() {
        binding.arrowDirectionPro.setBackgroundDrawable(requireContext().getResources().getDrawable(R.drawable.ic_arrow_down))
        binding.selectedTextPro.visibility=View.GONE
        isClicked=false
    }

    private fun releaseAnotherText() {
        binding.arrowDirectionPro.setBackgroundDrawable(requireContext().getResources().getDrawable(R.drawable.arrow_up))
        binding.selectedTextPro.visibility=View.VISIBLE
        isClicked=true
    }



}