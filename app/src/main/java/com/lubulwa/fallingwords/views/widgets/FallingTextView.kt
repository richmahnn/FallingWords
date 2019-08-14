package com.lubulwa.fallingwords.views.widgets

import android.annotation.TargetApi
import android.content.Context
import android.os.Build
import android.util.AttributeSet
import android.util.DisplayMetrics
import android.view.WindowManager
import android.view.animation.Animation
import android.view.animation.TranslateAnimation
import android.widget.TextView

class FallingTextView : TextView {
    private lateinit var txtAnimation: Animation

    constructor(context: Context) : super(context) {
        setup(context)
    }

    constructor(context: Context, attrs: AttributeSet) : super(context, attrs) {
        setup(context)
    }

    constructor(context: Context, attrs: AttributeSet, defStyleAttr: Int) : super(context, attrs, defStyleAttr) {
        setup(context)
    }

    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    constructor(context: Context, attrs: AttributeSet, defStyleAttr: Int, defStyleRes: Int) : super(
        context,
        attrs,
        defStyleAttr,
        defStyleRes
    ) {
        setup(context)
    }

    private fun setup(context: Context) {
        val wm = context.getSystemService(Context.WINDOW_SERVICE) as WindowManager
        val metrics = DisplayMetrics()
        wm.defaultDisplay.getMetrics(metrics)
        val deltaY = metrics.heightPixels - height
        txtAnimation = TranslateAnimation(0f, 0f, 0f, deltaY.toFloat())
        txtAnimation.duration = ANIM_DURATION_IN_MILLIS
    }

    fun setAnimationListener(listener: Animation.AnimationListener) {
        txtAnimation.setAnimationListener(listener)
    }

    fun startFallingDown() {
        startAnimation(txtAnimation)
    }

    companion object {

        private const val ANIM_DURATION_IN_MILLIS: Long = 7000
    }
}
