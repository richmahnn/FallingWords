package com.lubulwa.fallingwords.core.di

import android.content.Context
import com.lubulwa.fallingwords.GameApplication
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class ApplicationModule(private val application: GameApplication) {

    @Provides
    @Singleton
    fun provideApplicationContext(): Context = application

}