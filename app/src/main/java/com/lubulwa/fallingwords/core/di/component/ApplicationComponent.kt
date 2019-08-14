package com.lubulwa.fallingwords.core.di.component

import com.lubulwa.fallingwords.GameApplication
import com.lubulwa.fallingwords.core.di.module.ActivityModule
import com.lubulwa.fallingwords.core.di.module.ApplicationModule
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [
    ApplicationModule::class
])
interface ApplicationComponent {
    fun inject(application: GameApplication)

}