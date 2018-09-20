package com.project.android.democrudrealmkotlin.component

import com.project.android.democrudrealmkotlin.activity.MainActivity
import dagger.Component
import javax.inject.Singleton

/**
 * Created by agung on 20/09/18.
 */

@Singleton
@Component(modules = arrayOf(AppModule::class))
interface AppComponent{
    fun inject(activity: MainActivity)
}