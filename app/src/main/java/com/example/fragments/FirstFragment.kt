package com.example.fragments

import android.content.Context
import android.net.Uri
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.activityandintentandroid15.R
import com.example.activityandintentandroid15.databinding.FragmentFirstBinding

class FirstFragment : Fragment() {

    // Срабатывает при привязке фрагмента к Activity
    override fun onAttach(context: Context) {
        super.onAttach(context)
    }

    // Фрагмент создаётся
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    private var _binding: FragmentFirstBinding? = null
    private val binding: FragmentFirstBinding get() = _binding!!

    // Все view в layout файле фрагмента создаются
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentFirstBinding.inflate(inflater, container, false)
        return binding.root
    }

    // Все view в layout файле фрагмента уже созданы и готовы к работе
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        transition()
        getDataFromSecondFragment()
        getDataFromThirdFragment()
        goToTheRecyclerViewFragment()
    }

    private fun transition() = with(binding) {
        fabTransition.setOnClickListener {

            val text = etInput.text.toString().trim()
            val switchValue = mySwitch.isChecked

            val bundle = Bundle().apply {
                putString(TEXT_KEY, text)
                putBoolean(SWITCH_VALUE_KEY, switchValue)
            }

            parentFragmentManager.beginTransaction()
                .add(R.id.fragment_container, SecondFragment::class.java, bundle)
                .addToBackStack(FIRST_FRAGMENT_TAG)
                .commit()
        }
    }

    private fun getDataFromSecondFragment() {
        parentFragmentManager.setFragmentResultListener(
            SecondFragment.PASS_DATA_TO_BACK_STACK_REQUEST_KEY,
            viewLifecycleOwner
        ) { _, result ->
            val image = result.getString(SecondFragment.IMAGE_KEY)
            image?.let { url ->
                binding.ivFromGallery.setImageURI(Uri.parse(url))
            }
        }
    }

    private fun getDataFromThirdFragment() {
        parentFragmentManager.setFragmentResultListener(
            ThirdFragment.PASS_DATA_KEY,
            viewLifecycleOwner
        ) { _, result ->
            val text = result.getCharSequence(ThirdFragment.EDIT_TEXT_KEY)
            text?.let {
                binding.tvText.text = it
            }
        }
    }

    private fun goToTheRecyclerViewFragment() {
        binding.btnGoToRecyclerView.setOnClickListener {
            parentFragmentManager.beginTransaction()
                .add(R.id.fragment_container, RecyclerViewFragment::class.java, null)
                .addToBackStack(FIRST_FRAGMENT_TAG)
                .commit()
        }
    }

    // Фрагмент запускается
    override fun onStart() {
        super.onStart()
    }

    // Фрагмент работает
    override fun onResume() {
        super.onResume()
    }

    // Фрагмент на паузе
    override fun onPause() {
        super.onPause()
    }

    // Фрагмент остановлен
    override fun onStop() {
        super.onStop()
    }

    // Все view в layout файле фрагмента уничтожаются
    override fun onDestroyView() {
        super.onDestroyView()
    }

    // Фрагмент уничтожается
    override fun onDestroy() {
        super.onDestroy()
    }

    // Фрагмент отвязывается от Activity
    override fun onDetach() {
        super.onDetach()
    }

    companion object {
        const val FIRST_FRAGMENT_TAG = "first"
        const val TEXT_KEY = "text"
        const val SWITCH_VALUE_KEY = "value"
    }
}