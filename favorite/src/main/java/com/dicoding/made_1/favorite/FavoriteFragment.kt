@file:Suppress("unused", "RedundantNullableReturnType")
package com.dicoding.made_1.favorite

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.dicoding.made_1.core.ui.SportAdapter
import com.dicoding.made_1.detail.DetailSportActivity
import com.dicoding.made_1.favorite.databinding.FragmentFavoriteBinding
import com.dicoding.made_1.favorite.di.favoriteModule
import org.koin.androidx.viewmodel.ext.android.viewModel
import org.koin.core.context.loadKoinModules
import org.koin.core.context.unloadKoinModules


class FavoriteFragment : Fragment() {

    private val favoriteViewModel: FavoriteViewModel by viewModel()

    private var _binding: FragmentFavoriteBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentFavoriteBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        loadKoinModules(favoriteModule)

        val sportAdapter = SportAdapter()
        sportAdapter.onItemClick = { selectedData ->
            val intent = Intent(activity, DetailSportActivity::class.java)
            intent.putExtra(DetailSportActivity.EXTRA_DATA, selectedData)
            startActivity(intent)
        }

        favoriteViewModel.favoriteSport.observe(viewLifecycleOwner, { dataSport ->
            sportAdapter.setData(dataSport)
        })

        with(binding.rvSport) {
            layoutManager = LinearLayoutManager(context)
            setHasFixedSize(true)
            adapter = sportAdapter
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
        unloadKoinModules(favoriteModule)
    }
}