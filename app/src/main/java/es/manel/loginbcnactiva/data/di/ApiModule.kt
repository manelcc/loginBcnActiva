package es.manel.loginbcnactiva.data.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityComponent
import dagger.hilt.android.scopes.ActivityScoped
import es.manel.loginbcnactiva.data.api.ApiLogin
import retrofit2.Retrofit

@Module
@InstallIn(ActivityComponent::class)
object ApiModule {

    @Provides
    @ActivityScoped
    fun provideApiService(retrofit: Retrofit) = retrofit.create(ApiLogin::class.java)
}