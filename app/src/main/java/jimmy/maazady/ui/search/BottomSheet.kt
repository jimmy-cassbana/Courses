package jimmy.maazady.ui.search

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.TextView
import androidx.core.widget.doAfterTextChanged
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import jimmy.maazady.data.model.OptionPair
import jimmy.maazady.databinding.BottomSheetBinding

class BottomSheet(private val pairs: List<OptionPair>, val onSelection: (pair: OptionPair) -> Unit) :
    BottomSheetDialogFragment() {

    private lateinit var binding: BottomSheetBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = BottomSheetBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val adapter = ArrayAdapter(requireActivity(), android.R.layout.simple_list_item_1, pairs.map { it.value })
        binding.imgClose.setOnClickListener { dismiss() }
        binding.searchView.editText?.doAfterTextChanged {
            adapter.filter.filter(it.toString())
        }
        binding.listView.adapter = adapter
        binding.listView.setOnItemClickListener { _, tv, _, _ ->
            pairs.find { it.value == (tv as? TextView)?.text }?.let {
                onSelection(it)
                dismiss()
            }
        }
    }
}
