package com.spacemooncake.filmapp

import com.spacemooncake.filmapp.model.repository.Repository
import com.spacemooncake.filmapp.model.repository.RepositoryImpl
import com.spacemooncake.filmapp.ui.main.MainViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val appModule = module {
    single<Repository> { RepositoryImpl() }

    viewModel { MainViewModel(get()) }

}