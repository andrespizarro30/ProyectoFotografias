package com.afsoftwaresolutions.proyectofotografias.ui

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.afsoftwaresolutions.proyectofotografias.R
import com.afsoftwaresolutions.proyectofotografias.databinding.ActivityBookBinding
import com.afsoftwaresolutions.proyectofotografias.ui.viewmodels.BookViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class BookActivity : AppCompatActivity() {

    lateinit var binding: ActivityBookBinding

    private val viewModel: BookViewModel by viewModels()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityBookBinding.inflate(layoutInflater)

        setContentView(binding.root)

        viewModel.pages.observe(this) { pages ->
            val provider = object : CurlView.PageProvider {
                override fun getPageCount(): Int = pages.size

                override fun updatePage(page: CurlPage?, width: Int, height: Int, index: Int) {
                    val bitmap = BitmapFactory.decodeResource(resources, pages[index].imageResId)
                    page?.setTexture(bitmap, CurlPage.SIDE_BOTH)
                }
            }
            binding.curlView.setPageProvider(provider)
            curlView.setSizeChangedObserver { w, h -> curlView.setViewMode(CurlView.SHOW_ONE_PAGE) }
        }



    }
}