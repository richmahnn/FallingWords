package com.lubulwa.fallingwords

import android.app.Application
import com.lubulwa.fallingwords.core.di.ApplicationComponent
import com.lubulwa.fallingwords.core.di.ApplicationModule
import com.lubulwa.fallingwords.core.di.DaggerApplicationComponent

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