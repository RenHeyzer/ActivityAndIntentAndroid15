package com.example.fragments

import android.net.Uri
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.activity.result.contract.ActivityResultContracts
import androidx.fragment.app.Fragment
import com.example.activityandintentandroid15.R
import com.example.activityandintentandroid15.databinding.FragmentSecondBinding

class SecondFragment : Fragment() {

    private var _binding: FragmentSecondBinding? = null
    private val binding: FragmentSecondBinding get() = _binding!!
    private var imageUrl: Uri? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentSecondBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        getArgs()
        goToTheThirdFragment()
        goBack()
        launchGallery()
    }

    private fun getArgs() {
        arguments?.let { args ->
            val text = args.getString(FirstFragment.TEXT_KEY)
            val value = args.getBoolean(FirstFragment.SWITCH_VALUE_KEY)
            Toast.makeText(requireContext(), "$text $value", Toast.LENGTH_SHORT).show()
        }
    }

    private fun goToTheThirdFragment() {
        binding.btnTransition.setOnClickListener {
            val thirdFragment = ThirdFragment()
            parentFragmentManager.beginTransaction()
                .add(R.id.fragment_container, thirdFragment)
                .addToBackStack(SECOND_FRAGMENT_TAG)
                .commit()
        }
    }

    private fun goBack() {
        binding.iconBack.setOnClickListener {
            val result = Bundle().apply {
                if (imageUrl != null) {
                    putString(IMAGE_KEY, imageUrl.toString())
                }
            }
            parentFragmentManager.setFragmentResult(PASS_DATA_TO_BACK_STACK_REQUEST_KEY, result)
            parentFragmentManager.popBackStack()
        }
    }

    private val getContent =
        registerForActivityResult(ActivityResultContracts.GetContent()) { uri ->
            imageUrl = uri
            binding.ivFromGallery.setImageURI(uri)
        }

    private fun launchGallery() {
        binding.ivFromGallery.setOnClickListener {
            getContent.launch("image/*")
        }
    }

    companion object {
        const val SECOND_FRAGMENT_TAG = "second"
        const val PASS_DATA_TO_BACK_STACK_REQUEST_KEY = "backstack_data"
        const val IMAGE_KEY = "image_url"
    }
}