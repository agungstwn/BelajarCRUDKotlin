package com.project.android.democrudrealmkotlin.bus

import android.support.annotation.IntDef

/**
 * Created by agung on 21/09/18.
 */
class DataEvent(@param:Query val query: Int) {

    @IntDef(ACTION_INSERT, ACTION_UPDATE, ACTION_DELETE)
    @Retention(AnnotationRetention.SOURCE)
    annotation class Query

    companion object {
        const val ACTION_INSERT = 0
        const val ACTION_UPDATE = 1
        const val ACTION_DELETE = 2
    }
}