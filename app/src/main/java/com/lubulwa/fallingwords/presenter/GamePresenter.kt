package com.lubulwa.fallingwords.presenter

import android.content.Context
import com.lubulwa.fallingwords.data.GameDataRepo
import com.lubulwa.fallingwords.model.Translation
import com.lubulwa.fallingwords.views.home.GameContract
import java.util.*
import javax.inject.Inject
import kotlin.collections.ArrayList

class GamePresenter @Inject constructor(private val context: Context, private val gameDataRepo: GameDataRepo) : GameContract.Presenter {

    private lateinit var translations: ArrayList<Translation>
    private lateinit var translationsRemaining: ArrayList<Translation>

    private var translationIndex = 0
    private var wordIndex = 0
    private var correctScoreCounter = 0
    private var wrongScoreCounter = 0
    private lateinit var random: Random

    private lateinit var view: GameContract.View

    override fun loadTranslations() {
        random = Random()

        translations = gameDataRepo.fetchTranslations(context)
        translationsRemaining = translations
        translationsRemaining.shuffle() //Reshuffle the translations for better user experience

        view.showUserScore(correctScoreCounter, getTotalTranslations())
    }

    override fun nextTranslation() {
        translationIndex = randomIndex()
        wordIndex = randomIndex()

        view.showTranslation(Translation(
            translationsRemaining[translationIndex].english,
            translationsRemaining[translationIndex].spanish
        ))
    }

    override fun checkTranslation(isTranslationCorrect: Boolean) {
        val translation = translationsRemaining[translationIndex]
        val translation2 = translationsRemaining[wordIndex]

        if (translation.spanish == translation2.spanish && !isTranslationCorrect ||
            translation.spanish != translation2.spanish && isTranslationCorrect) {
            view.translationCorrect(++correctScoreCounter, getTotalTranslations())
        } else {
            view.translationWrong(++wrongScoreCounter)
        }
    }

    override fun translationWrong() {
        wrongScoreCounter++
        view.translationWrong(wrongScoreCounter)
    }

    override fun subscribe() {
        // subscribe to rxjava observables
    }

    override fun unsubscribe() {
        // unsubscribe to rxjava observables
    }

    override fun attach(view: GameContract.View) {
        this.view = view
    }

    override fun getTotalTranslations(): Int {
        return translations.size
    }

    private fun randomIndex(): Int {
        return random.nextInt(translationsRemaining.size)
    }

}
