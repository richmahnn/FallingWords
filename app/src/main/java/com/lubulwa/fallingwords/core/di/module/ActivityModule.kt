package com.lubulwa.fallingwords.core.di.module

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import com.lubulwa.fallingwords.core.di.ActivityContext
import com.lubulwa.fallingwords.data.GameDataRepo
import com.lubulwa.fallingwords.presenter.GamePresenter
import com.lubulwa.fallingwords.views.home.GameContract
import dagger.Module
import dagger.Provides

@Module
class ActivityModule(private val context: Context) {

    @Provides
    fun provideActivity(): AppCompatActivity {
        return context as AppCompatActivity
    }

    @Provides
    @ActivityContext
    fun provideContext(): Context {
        return context
    }

    @Provides
    fun provideGameDataRepo(): GameDataRepo {
        return GameDataRepo()
    }

    @Provides
    fun providePresenter(): GameContract.Presenter {
        return GamePresenter(provideContext(), provideGameDataRepo())
    }

}