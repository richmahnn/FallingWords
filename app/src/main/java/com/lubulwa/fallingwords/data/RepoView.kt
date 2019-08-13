package com.lubulwa.fallingwords.data

import com.lubulwa.fallingwords.model.Translation

interface RepoView {
    fun fetchTranslations(): List<Translation>
}