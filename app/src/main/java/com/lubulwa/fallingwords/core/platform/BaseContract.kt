package com.lubulwa.fallingwords.core.platform

interface BaseContract {

    interface Presenter<in T> {
        fun subscribe()
        fun unsubscribe()
        fun attach(view: T)
    }

    interface View {
        fun initViews()
        fun setupPresenter()
    }

}