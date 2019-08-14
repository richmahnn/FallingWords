package com.lubulwa.fallingwords.core.di.component

import com.lubulwa.fallingwords.core.di.module.ActivityModule
import com.lubulwa.fallingwords.core.di.scope.PerActivity
import com.lubulwa.fallingwords.views.home.GameActivity
import dagger.Component

@PerActivity
@Component(modules = [ActivityModule::class])
interface ActivityComponent {
    fun inject(gameActivity: GameActivity)
}