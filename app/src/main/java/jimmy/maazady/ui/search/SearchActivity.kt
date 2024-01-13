package jimmy.maazady.ui.search

import android.os.Bundle
import android.view.View
import jimmy.maazady.R
import jimmy.maazady.base.BaseActivity
import org.koin.androidx.viewmodel.ext.android.viewModel

class SearchActivity : BaseActivity() {

    private val viewModel: SearchViewModel by viewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_search)
        findViewById<View>(R.id.anything).setOnClickListener {
            observe(viewModel.categories) {

            }
        }
    }
}