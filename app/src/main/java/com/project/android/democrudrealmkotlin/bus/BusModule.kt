package com.project.android.democrudrealmkotlin.bus

import com.squareup.otto.Bus
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

/**
 * Created by agung on 21/09/18.
 */

@Module

class BusModule {
    @Provides
    @Singleton
    fun provideBus(): Bus {
        return Bus()
    }
}