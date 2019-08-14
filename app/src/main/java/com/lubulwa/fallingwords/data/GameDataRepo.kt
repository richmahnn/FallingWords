package com.lubulwa.fallingwords.data

import android.content.Context
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.lubulwa.fallingwords.R
import com.lubulwa.fallingwords.model.Translation
import java.io.InputStreamReader

class GameDataRepo : RepoView {

    override fun fetchTranslations(context: Context): ArrayList<Translation> {

        val inputStream = context.resources.openRawResource(R.raw.words)
        val reader = InputStreamReader(inputStream)
        val type = object : TypeToken<List<Translation>>() {}.type

        return Gson().fromJson<ArrayList<Translation>>(reader, type)
    }

//    @SuppressLint("CheckResult")
//    override fun fetchTranslations(): List<Translation> {
//        Observable.fromCallable(object : Callable<List<Translation>> {
//            @Throws(Exception::class)
//            override fun call(): List<Translation> {
//                Type type = new TypeToken<List<Option>>() {}
//                    .getType();
//                List<Option> optionList = gson.fromJson(
//                        CommonUtils.loadJSONFromAsset(mContext,
//                            AppConstants.SEED_DATABASE_OPTIONS),
//                type);
//
//                return mDaoSession.getUserDao().loadAll()
//            }
//        })
//    }

}