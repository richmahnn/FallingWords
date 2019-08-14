package com.lubulwa.fallingwords.views.home

import com.lubulwa.fallingwords.core.platform.BaseContract
import com.lubulwa.fallingwords.model.Translation

interface GameContract : BaseContract {

    interface View: BaseContract.View {
        fun showUserScore(score: Int, total: Int)
        fun resetGame()
        fun showTranslation(translation: Translation)
        fun translationCorrect(score: Int, total: Int)
        fun translationWrong(score: Int)
    }

    interface Presenter: BaseContract.Presenter<View> {
        fun loadTranslations()
        fun nextTranslation()
        fun checkTranslation(isTranslationCorrect: Boolean)
        fun getTotalTranslations(): Int
        fun translationWrong()
    }

}