package com.lubulwa.fallingwords.core.di.module

import android.content.Context
import com.lubulwa.fallingwords.GameApplication
import com.lubulwa.fallingwords.core.di.scope.PerApplication
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class ApplicationModule(private val application: GameApplication) {

    @Provides
    @Singleton
    @PerApplication
    fun provideApplicationContext(): Context = application

}