package jimmy.maazady.ui.search

import android.os.Bundle
import com.google.android.material.textfield.TextInputEditText
import jimmy.maazady.R
import jimmy.maazady.base.BaseActivity
import jimmy.maazady.data.model.CategoriesResponse
import jimmy.maazady.data.model.OptionPair
import org.koin.androidx.viewmodel.ext.android.viewModel

class SearchActivity : BaseActivity() {

    private val viewModel: SearchViewModel by viewModel()
    private var selectedCategoryId = 0
    private var selectedSubCategoryId = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_search)
        observe(viewModel.categories) { populateSpinners(it) }
    }

    private fun populateSpinners(data: CategoriesResponse) {
        val edtCategory = findViewById<TextInputEditText>(R.id.edtCategory)
        val edtSubCategory = findViewById<TextInputEditText>(R.id.edtSubcategory)

        edtCategory.setOnClickListener { view ->
            BottomSheet(data.categories.map { OptionPair(it.id, it.name) }) {
                selectedCategoryId = it.id
                selectedSubCategoryId = 0
                edtSubCategory.text = null
                (view as TextInputEditText).setText(it.value)
            }.show(supportFragmentManager, null)
        }

        edtSubCategory.setOnClickListener { view ->
            data.categories.find { it.id == selectedCategoryId }?.children
                ?.map { OptionPair(it.id, it.name) }?.let {
                    BottomSheet(it) { option ->
                        selectedSubCategoryId = option.id
                        (view as TextInputEditText).setText(option.value)
                    }.show(supportFragmentManager, null)
                }
        }
    }
}
