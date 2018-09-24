package com.project.android.democrudrealmkotlin.di

import com.project.android.democrudrealmkotlin.activity.AddActivity
import com.project.android.democrudrealmkotlin.activity.MainActivity
import com.project.android.democrudrealmkotlin.bus.BusModule
import com.project.android.democrudrealmkotlin.realm.RealmModule
import dagger.Component
import javax.inject.Singleton

/**
 * Created by agung on 20/09/18.
 */

@Singleton
@Component(modules = arrayOf(AppModule::class, RealmModule::class, BusModule::class))
interface AppComponent{
    fun inject(activity: MainActivity)
    fun inject(activity: AddActivity)
}