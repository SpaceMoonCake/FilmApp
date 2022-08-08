package com.spacemooncake.filmapp.ui.main

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import com.spacemooncake.filmapp.R
import com.spacemooncake.filmapp.databinding.FragmentMainBinding
import com.spacemooncake.filmapp.model.AppState
import com.spacemooncake.filmapp.model.entities.api_entities.Film
import com.spacemooncake.filmapp.ui.adapters.MainFragmentAdapter
import com.spacemooncake.filmapp.ui.details.DetailsFragment
import org.koin.androidx.viewmodel.ext.android.viewModel

class MainFragment : Fragment() {

    private val mainViewModel: MainViewModel by viewModel()
    private var _binding: FragmentMainBinding? = null
    private val binding get() = _binding!!
    private var adapter: MainFragmentAdapter? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentMainBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.recyclerView.adapter = adapter
        val observer = Observer<AppState> { renderData(it) }
        mainViewModel.liveData.observe(viewLifecycleOwner, observer)
        mainViewModel.getFilmsData()

    }

    private fun renderData(appState: AppState) = with(binding) {
        when (appState) {
            is AppState.Success -> {
                adapter = MainFragmentAdapter(object : OnItemViewClickListener {
                    override fun onItemViewClick(film: Film) {
                        val manager = activity?.supportFragmentManager
                        manager?.let { manager ->
                            val bundle = Bundle().apply {
                                putParcelable(DetailsFragment.BUNDLE_EXTRA, film)
                            }
                            manager.beginTransaction()
                                .add(R.id.container, DetailsFragment.newInstance(bundle))
                                .addToBackStack("")
                                .commitAllowingStateLoss()
                        }
                    }
                }).apply {
                    setFilms(appState.filmData)
                }
                recyclerView.adapter = adapter
            }

        }

    }


    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    interface OnItemViewClickListener {
        fun onItemViewClick(film: Film)
    }

    companion object {
        fun newInstance() = MainFragment()
    }
}