package com.project.android.democrudrealmkotlin.component

import android.content.Context
import com.project.android.democrudrealmkotlin.App
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

/**
 * Created by agung on 20/09/18.
 */

@Module
class AppModule(private val app: App) {
    @Provides
    @Singleton
    fun provideContext(): Context {
        return app
    }
}