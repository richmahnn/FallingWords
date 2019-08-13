package com.lubulwa.fallingwords.views

import android.os.Bundle
import com.lubulwa.fallingwords.R
import com.lubulwa.fallingwords.core.BaseActivity
import com.lubulwa.fallingwords.presenter.GamePresenter

class GameActivity : BaseActivity() {

    private lateinit var gamePresenter: GamePresenter

    override fun layoutResId(): Int {
        return R.layout.activity_main
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setupViews()
        setupPresenter()
    }

    private fun setupViews() {

    }

    private fun setupPresenter() {

    }
}