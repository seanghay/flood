package com.seanghay.flood.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.seanghay.flood.R
import com.seanghay.flood.databinding.FragmentNewsfeedBinding
import com.seanghay.flood.epoxy.FeedController
import com.seanghay.flood.http.Post

class NewsfeedFragment : Fragment() {

    private var _binding: FragmentNewsfeedBinding? = null
    private val binding: FragmentNewsfeedBinding get() = _binding!!
    private val viewModel: NewsfeedViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentNewsfeedBinding.inflate(inflater, container, false)
        val controller = FeedController(viewModel.postsArrayList, viewModel.usersArrayList)

        controller.listener = object : FeedController.FeedListener {
            override fun onPhotoItemClick(imageUrl: String, post: Post) {
                val navController = findNavController()
                navController.navigate(R.id.action_newsfeedFragment_to_photoViewFragment, bundleOf(
                    "imageUrl" to imageUrl,
                    "title" to post.title
                ))
            }
        }

        val linearLayoutManager = LinearLayoutManager(requireContext())

        with(binding) {
            recyclerView.layoutManager = linearLayoutManager
            recyclerView.setControllerAndBuildModels(controller)
            recyclerView.setHasFixedSize(true)
        }

        with(viewModel) {
            users.observe(viewLifecycleOwner, controller::users)
            posts.observe(viewLifecycleOwner, controller::posts)
        }

        binding.bottomNavigationView.setOnNavigationItemSelectedListener {
            false
        }

        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}