package jimmy.maazady.base

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.LiveData
import jimmy.maazady.data.remote.Resource
import jimmy.maazady.util.snack

open class BaseActivity: AppCompatActivity() {

    var rootView: View? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        rootView = findViewById(android.R.id.content)
    }

    fun start(activity: Class<out BaseActivity>, extras: Bundle? = null) {
        val intent = Intent(this, activity)
        extras?.let { intent.putExtras(it) }
        startActivity(intent)
    }

    fun <T> observe(liveData: LiveData<Resource<T>>, result: (data: T) -> Unit) {
        liveData.removeObservers(this)
        liveData.observe(this) {
            when (it) {
                is Resource.Loading -> {}
                is Resource.Success -> { result(it.data ?: Any() as T) }
                is Resource.Error -> { it.message?.let { e -> if (e != "") rootView?.snack(e) } }
            }
        }
    }
}