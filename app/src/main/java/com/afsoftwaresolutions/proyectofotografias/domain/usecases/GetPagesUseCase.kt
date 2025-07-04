package com.afsoftwaresolutions.proyectofotografias.domain.usecases

import com.afsoftwaresolutions.proyectofotografias.domain.models.Page

class GetPagesUseCase {
    operator fun invoke(): List<Page> {
        // You can inject a repository if needed
        return listOf(
            Page(R.drawable.page1),
            Page(R.drawable.page2),
            Page(R.drawable.page3)
        )
    }
}