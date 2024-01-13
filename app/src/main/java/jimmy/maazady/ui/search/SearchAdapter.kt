package jimmy.maazady.ui.search

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.FragmentManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.textfield.TextInputEditText
import com.google.android.material.textfield.TextInputLayout
import jimmy.maazady.R
import jimmy.maazady.data.model.OptionPair
import jimmy.maazady.data.model.Property

class SearchAdapter(
    private val dataSet: ArrayList<Property>,
    private val fragmentManager: FragmentManager,
    private val fetchChilds: (property: Property) -> Unit
) :
    RecyclerView.Adapter<SearchAdapter.ViewHolder>() {

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val inputLayout: TextInputLayout = view.findViewById(R.id.inputLayout)
        val inputEditText: TextInputEditText = view.findViewById(R.id.inputEditText)
    }

    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(viewGroup.context)
            .inflate(R.layout.dropdown_item, viewGroup, false)

        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.inputLayout.hint = dataSet[position].name
        holder.inputEditText.setText(dataSet[position].text)
        holder.inputEditText.setOnClickListener {
            BottomSheet(dataSet[position].options.map { OptionPair(it.id, it.name) }) { pair ->
                dataSet[position].text = pair.value
                holder.inputEditText.setText(pair.value)
                dataSet[position].options.find { it.id == pair.id }?.let { property ->
                    if (property.child) fetchChilds(property)
                }
            }.show(fragmentManager, null)
        }
    }

    override fun getItemCount() = dataSet.size

    fun insert(properties: List<Property>, property: Property, context: Context) {
        val index = dataSet.indexOfFirst { it.id == property.parent } + 1
        dataSet.addAll(index, properties)
        notifyItemRangeInserted(index, properties.size)
    }

}
