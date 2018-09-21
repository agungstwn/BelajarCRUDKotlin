package com.project.android.democrudrealmkotlin

import android.app.Application
import com.project.android.democrudrealmkotlin.di.AppComponent
import com.project.android.democrudrealmkotlin.di.DaggerAppComponent
import io.realm.Realm

/**
 * Created by agung on 20/09/18.
 */

class App : Application(){
    val component: AppComponent by lazy {
        DaggerAppComponent
                .builder()
                .build()
    }
    override fun onCreate() {
        super.onCreate()
        Realm.init(this)
    }
}
