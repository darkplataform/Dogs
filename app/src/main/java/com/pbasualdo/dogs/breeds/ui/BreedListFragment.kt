package com.pbasualdo.dogs.breeds.ui

import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager

import com.pbasualdo.dogs.R
import com.pbasualdo.dogs.databinding.BreedListFragmentBinding
import com.pbasualdo.dogs.databinding.BreedListItemBinding
import kotlinx.android.synthetic.main.breed_list_fragment.*




class BreedListFragment : Fragment() {

    companion object {
        fun newInstance() = BreedListFragment()
    }




    private lateinit var adapter: BreedListAdapter
    private lateinit var dataBinding : BreedListFragmentBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        dataBinding = BreedListFragmentBinding.inflate(inflater,  container, false).apply {
            viewmodel = ViewModelProviders.of(this@BreedListFragment).get(BreedsViewModel::class.java)
            lifecycleOwner= viewLifecycleOwner
        }

        return dataBinding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        setupAdapter()
        setupObservers()
    }

    private fun setupObservers() {
        dataBinding.viewmodel?.allBreeds?.observe(viewLifecycleOwner, Observer {
            if(it!=null)
            adapter.updateBreedList(it)
        })

    }

    private fun setupAdapter() {
        val viewModel = dataBinding.viewmodel
        if (viewModel != null) {
            adapter = BreedListAdapter(viewModel!!)
            val layoutManager = LinearLayoutManager(activity)
            breed_list_rv .layoutManager = layoutManager
            breed_list_rv.addItemDecoration(DividerItemDecoration(activity, layoutManager.orientation))
            breed_list_rv.adapter = adapter
        }
    }

}
