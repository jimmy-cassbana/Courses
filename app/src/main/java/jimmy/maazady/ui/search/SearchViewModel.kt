package jimmy.maazady.ui.search

import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import jimmy.maazady.data.repository.SearchRepository

class SearchViewModel(private val repository: SearchRepository) : ViewModel() {

    val categories = liveData { emit(repository.getCategories()) }
    fun getProperties(catId: Int) = liveData { emit(repository.getProperties(catId)) }
    fun getOptions(propertyId: Int) = liveData { emit(repository.getOptions(propertyId)) }
}