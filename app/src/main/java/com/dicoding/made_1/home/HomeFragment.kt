package com.dicoding.made_1.home

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.dicoding.made_1.core.data.Resource
import com.dicoding.made_1.core.ui.SportAdapter
import com.dicoding.made_1.R
import com.dicoding.made_1.databinding.FragmentHomeBinding
import com.dicoding.made_1.detail.DetailSportActivity
import org.koin.androidx.viewmodel.ext.android.viewModel

class HomeFragment : Fragment() {

    private val homeViewModel: HomeViewModel by viewModel()

    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        if (activity != null) {

            val sportAdapter = SportAdapter()
            sportAdapter.onItemClick = { selectedData ->
                val intent = Intent(activity, DetailSportActivity::class.java)
                intent.putExtra(DetailSportActivity.EXTRA_DATA, selectedData)
                startActivity(intent)
            }

            homeViewModel.sport.observe(viewLifecycleOwner, { sport ->
                if (sport != null) {
                    when (sport) {
                        is Resource.Loading -> binding.progressBar.visibility = View.VISIBLE
                        is Resource.Success -> {
                            binding.progressBar.visibility = View.GONE
                            sportAdapter.setData(sport.data)
                        }
                        is Resource.Error -> {
                            binding.progressBar.visibility = View.GONE
                            binding.viewError.root.visibility = View.VISIBLE
                            binding.viewError.tvError.text = sport.message ?: getString(R.string.something_wrong)
                        }
                    }
                }
            })

            with(binding.rvSport) {
                layoutManager = LinearLayoutManager(context)
                setHasFixedSize(true)
                adapter = sportAdapter
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}