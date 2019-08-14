package com.lubulwa.fallingwords.core.platform

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.lubulwa.fallingwords.core.di.component.ActivityComponent
import com.lubulwa.fallingwords.core.di.component.DaggerActivityComponent
import com.lubulwa.fallingwords.core.di.module.ActivityModule
import com.lubulwa.fallingwords.databinding.ActivityMainBinding

abstract class BaseActivity : AppCompatActivity() {

    lateinit var binder: ActivityMainBinding
    lateinit var activityComponent: ActivityComponent

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binder = DataBindingUtil.setContentView(this, layoutResId())

        // Inject dependency
        activityComponent = DaggerActivityComponent
            .builder()
            .activityModule(ActivityModule(this))
            .build()
    }

    abstract fun layoutResId(): Int

}