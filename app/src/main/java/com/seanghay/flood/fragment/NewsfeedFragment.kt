package com.seanghay.flood.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.seanghay.flood.databinding.FragmentNewsfeedBinding
import com.seanghay.flood.epoxy.FeedController

class NewsfeedFragment : Fragment() {

    private var _binding: FragmentNewsfeedBinding? = null
    private val binding: FragmentNewsfeedBinding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentNewsfeedBinding.inflate(inflater, container, false)
        val controller = FeedController()
        val linearLayoutManager = LinearLayoutManager(requireContext())
        with(binding) {
            recyclerView.layoutManager = linearLayoutManager
            recyclerView.setControllerAndBuildModels(controller)
            recyclerView.setHasFixedSize(true)
        }
        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}