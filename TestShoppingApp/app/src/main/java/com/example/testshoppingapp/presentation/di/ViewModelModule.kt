package com.example.testshoppingapp.presentation.di

import android.app.Application
import com.example.testshoppingapp.domain.usecase.CartUseCase
import com.example.testshoppingapp.domain.usecase.ProductUseCase
import com.example.testshoppingapp.data.util.SharedPreference
import com.example.testshoppingapp.domain.usecase.AuthUseCase
import com.example.testshoppingapp.presentation.viewmodel.*
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class ViewModelModule {

    @Singleton
    @Provides
    fun providesProductDetailViewModel(cartUseCase: CartUseCase) : ProductDetailViewModel {
        return ProductDetailViewModel(cartUseCase)
    }

    @Singleton
    @Provides
    fun providesCartViewModel(cartUseCase: CartUseCase) : CartViewModel {
        return CartViewModel(cartUseCase)
    }

    @Singleton
    @Provides
    fun providesHomeViewModel(app : Application, productUseCase: ProductUseCase) : HomeViewModel {
        return HomeViewModel(app, productUseCase)
    }

    @Singleton
    @Provides
    fun providesLoginViewModel(authUseCase: AuthUseCase, sharedPreference: SharedPreference) : LoginViewModel {
        return LoginViewModel(authUseCase,sharedPreference)
    }

    @Singleton
    @Provides
    fun providesSplashViewModel(sharedPreference: SharedPreference) : SplashViewModel {
        return SplashViewModel(sharedPreference)
    }

}