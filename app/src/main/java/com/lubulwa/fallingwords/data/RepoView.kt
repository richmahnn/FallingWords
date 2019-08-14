package com.lubulwa.fallingwords.data

import android.content.Context
import com.lubulwa.fallingwords.core.platform.BaseContract
import com.lubulwa.fallingwords.model.Translation

interface RepoView {
    fun fetchTranslations(context: Context): List<Translation>
}