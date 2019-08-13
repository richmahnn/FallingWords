package com.lubulwa.fallingwords.core.di

import com.lubulwa.fallingwords.GameApplication
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [
    ApplicationModule::class
])
interface ApplicationComponent {
    fun inject(application: GameApplication)
}