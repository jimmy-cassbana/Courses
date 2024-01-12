package jimmy.maazady

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.RecyclerView
import com.github.islamkhsh.CardSliderViewPager
import jimmy.maazady.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val binding = ActivityMainBinding.inflate(layoutInflater)
        findViewById<CardSliderViewPager>(R.id.viewPager).adapter = CourseAdapter(arrayOf(1,2,3))
        findViewById<RecyclerView>(R.id.contactsRecycler).adapter = ContactAdapter(arrayOf(1,2,3,4,5))

    }
}