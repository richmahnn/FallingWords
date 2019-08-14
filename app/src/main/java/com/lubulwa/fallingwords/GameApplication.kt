package com.lubulwa.fallingwords

import android.app.Application
import com.lubulwa.fallingwords.core.di.component.ApplicationComponent
import com.lubulwa.fallingwords.core.di.component.DaggerApplicationComponent
import com.lubulwa.fallingwords.core.di.module.ApplicationModule

class GameApplication : Application() {

    private val applicationComponent: ApplicationComponent by lazy(mode = LazyThreadSafetyMode.NONE) {
        DaggerApplicationComponent
            .builder()
            .applicationModule(ApplicationModule(this))
            .build()
    }

    override fun onCreate() {
        super.onCreate()
        this.injectMembers()
    }

    private fun injectMembers() = applicationComponent.inject(this)

}