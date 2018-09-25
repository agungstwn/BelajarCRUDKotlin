package com.project.android.democrudrealmkotlin.bus

import android.support.annotation.IntDef
import android.support.annotation.LongDef
import java.lang.annotation.Retention
import java.lang.annotation.RetentionPolicy

/**
 * Created by agung on 21/09/18.
 */
class DataEvent(@param:Query val query: Int) {

    @LongDef (ACTION_INSERT.toLong(), ACTION_UPDATE.toLong(), ACTION_DELETE.toLong())

    @Retention(RetentionPolicy.SOURCE)

    annotation class Query

    companion object {

        const val ACTION_INSERT = 0
        const val ACTION_UPDATE = 1
        const val ACTION_DELETE = 2
    }
}