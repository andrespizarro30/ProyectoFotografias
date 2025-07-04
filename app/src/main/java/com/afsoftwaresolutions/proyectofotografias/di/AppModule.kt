package com.afsoftwaresolutions.proyectofotografias.di

import com.afsoftwaresolutions.proyectofotografias.domain.usecases.GetPagesUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    fun provideGetPagesUseCase(): GetPagesUseCase = GetPagesUseCase()
}