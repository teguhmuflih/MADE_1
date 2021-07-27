package com.dicoding.made_1.di


import com.dicoding.made_1.core.domain.usecase.SportInteractor
import com.dicoding.made_1.core.domain.usecase.SportUseCase
import com.dicoding.made_1.detail.DetailSportViewModel
import com.dicoding.made_1.home.HomeViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val useCaseModule = module {
    factory<SportUseCase> { SportInteractor(get()) }
}

val viewModelModule = module {
    viewModel { HomeViewModel(get()) }
    viewModel { DetailSportViewModel(get()) }
}