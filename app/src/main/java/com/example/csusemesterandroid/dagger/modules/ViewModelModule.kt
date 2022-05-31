package com.example.csusemesterandroid.dagger.modules

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.csusemesterandroid.dagger.ViewModelFactory
import com.example.csusemesterandroid.dagger.ViewModelKey
import com.example.csusemesterandroid.ui.viewmodel.BrandsViewModel
import com.example.csusemesterandroid.ui.viewmodel.DetailsViewModel
import com.example.csusemesterandroid.ui.viewmodel.PhonesViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
abstract class ViewModelModule {
    @Binds
    abstract fun bindViewModelFactory(factory: ViewModelFactory): ViewModelProvider.Factory
    @Binds @IntoMap @ViewModelKey(BrandsViewModel::class)
    abstract fun brandsViewModel(viewModel: BrandsViewModel): ViewModel
    @Binds @IntoMap @ViewModelKey(PhonesViewModel::class)
    abstract fun phonesViewModel(viewModel: PhonesViewModel): ViewModel
    @Binds @IntoMap @ViewModelKey(DetailsViewModel::class)
    abstract fun detailsViewModel(viewModel: DetailsViewModel): ViewModel
}