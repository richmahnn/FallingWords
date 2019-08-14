package com.lubulwa.fallingwords.views.home

import android.os.Bundle
import android.view.animation.Animation
import android.widget.Toast
import com.lubulwa.fallingwords.R
import com.lubulwa.fallingwords.core.platform.BaseActivity
import com.lubulwa.fallingwords.model.Translation
import javax.inject.Inject

class GameActivity : BaseActivity(), GameContract.View, Animation.AnimationListener {

    @Inject lateinit var gamePresenter: GameContract.Presenter

    override fun layoutResId(): Int {
        return R.layout.activity_main
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        initViews()
        setupPresenter()
    }

    override fun initViews() {
        activityComponent.inject(this)
        binder.tvScoreCorrect.text = getString(R.string.correct_score_place_holder, 0, 0)

        binder.tvSpanish.setAnimationListener(this)

        binder.fabCorrectTranslation.setOnClickListener {
            gamePresenter.checkTranslation(true)
        }

        binder.fabWrongTranslation.setOnClickListener {
            gamePresenter.checkTranslation(false)
        }
    }

    override fun setupPresenter() {
        gamePresenter.attach(this)

        gamePresenter.loadTranslations()
        gamePresenter.nextTranslation()
    }

    override fun showUserScore(score: Int, total: Int) {
        binder.tvScoreCorrect.text = getString(R.string.correct_score_place_holder, score, total)
    }

    override fun showTranslation(translation: Translation) {
        binder.tvEnglish.text = translation.english
        binder.tvSpanish.text = translation.spanish

        binder.tvSpanish.startFallingDown()
    }

    override fun translationCorrect(score: Int, total: Int) {
        binder.tvScoreCorrect.text = getString(R.string.correct_score_place_holder, score, total)

        gamePresenter.nextTranslation()
    }

    override fun translationWrong(score: Int) {
        binder.tvScoreFail.text = getString(R.string.wrong_score_place_holder, score)
        gamePresenter.nextTranslation()
    }

    override fun resetGame() {
        binder.tvSpanish.animation.cancel()
        binder.tvSpanish.clearAnimation()
    }

    override fun onAnimationRepeat(p0: Animation?) {

    }

    override fun onAnimationEnd(p0: Animation?) {
        Toast.makeText(this, "No answer", Toast.LENGTH_SHORT).show()
        gamePresenter.translationWrong()
        gamePresenter.nextTranslation()
    }

    override fun onAnimationStart(p0: Animation?) {

    }

    override fun onResume() {
        super.onResume()
        gamePresenter.subscribe()
    }

    override fun onDestroy() {
        super.onDestroy()
        gamePresenter.unsubscribe()
    }

}
