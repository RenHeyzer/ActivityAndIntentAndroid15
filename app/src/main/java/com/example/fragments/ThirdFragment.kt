package com.example.fragments

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import com.example.activityandintentandroid15.R
import com.example.activityandintentandroid15.databinding.FragmentThirdBinding

class ThirdFragment : Fragment() {

    private var _binding: FragmentThirdBinding? = null
    private val binding: FragmentThirdBinding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentThirdBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        goBack()
        setupListener()
    }

    private fun goBack() {
        binding.iconBack.setOnClickListener {
            parentFragmentManager.popBackStack(
                FirstFragment.FIRST_FRAGMENT_TAG,
                FragmentManager.POP_BACK_STACK_INCLUSIVE
            )
        }
    }

    private fun setupListener() {
        binding.etInput.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {

            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                s?.let { text ->
                    binding.tvText.text = text
                }
            }

            override fun afterTextChanged(s: Editable?) {
                s?.let { editable ->
                    val bundle = Bundle().apply {
                        putCharSequence(EDIT_TEXT_KEY, editable)
                    }
                    parentFragmentManager.setFragmentResult(PASS_DATA_KEY, bundle)
                }
            }
        })
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    companion object {
        const val PASS_DATA_KEY = "backstack_text"
        const val EDIT_TEXT_KEY = "edit_text"
    }
}