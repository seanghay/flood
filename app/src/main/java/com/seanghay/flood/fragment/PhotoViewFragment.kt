package com.seanghay.flood.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.bumptech.glide.Glide
import com.seanghay.flood.common.load
import com.seanghay.flood.databinding.FragmentPhotoViewBinding

class PhotoViewFragment : Fragment() {

    private var _binding: FragmentPhotoViewBinding? = null
    private val binding: FragmentPhotoViewBinding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentPhotoViewBinding.inflate(inflater, container, false)
        Glide.with(this).load(arguments?.getString("imageUrl")!!).into(
            binding.photoView
        )

        binding.materialToolbar.title = arguments?.getString("title")!!
        binding.materialToolbar.setNavigationOnClickListener {
            findNavController().navigateUp()
        }
        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}