package com.lubulwa.fallingwords.core

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.lubulwa.fallingwords.databinding.ActivityMainBinding

abstract class BaseActivity : AppCompatActivity() {

    lateinit var binder: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binder = DataBindingUtil.setContentView(this, layoutResId())
    }

    abstract fun layoutResId(): Int

}