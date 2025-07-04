package com.afsoftwaresolutions.proyectofotografias.ui.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.afsoftwaresolutions.proyectofotografias.domain.models.Page
import com.afsoftwaresolutions.proyectofotografias.domain.usecases.GetPagesUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class BookViewModel @Inject constructor(
    private val getPagesUseCase: GetPagesUseCase
) : ViewModel() {

    private val _pages = MutableLiveData<List<Page>>()
    val pages: LiveData<List<Page>> get() = _pages

    init {
        loadPages()
    }

    private fun loadPages() {
        _pages.value = getPagesUseCase()
    }
}