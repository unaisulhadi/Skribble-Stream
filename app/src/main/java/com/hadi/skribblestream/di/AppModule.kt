package com.hadi.skribblestream.di

import android.content.Context
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import com.hadi.skribblestream.data.AppPreferences
import com.hadi.skribblestream.data.RandomWordsApi
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideAppPreferences(@ApplicationContext context: Context) = AppPreferences(context)

    @Provides
    @Singleton
    fun provideRandomWordsApi(): RandomWordsApi = RandomWordsApi.invoke()

}
