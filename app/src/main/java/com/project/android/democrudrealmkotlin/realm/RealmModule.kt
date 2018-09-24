package com.project.android.democrudrealmkotlin.realm

import dagger.Module
import dagger.Provides
import javax.inject.Singleton

/**
 * Created by agung on 21/09/18.
 */

@Module
class RealmModule {

    @Provides
    @Singleton
    fun provideRealmHelper(): RealmHelper{
        return RealmHelper()
    }
}