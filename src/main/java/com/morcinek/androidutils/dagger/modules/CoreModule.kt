package com.morcinek.androidutils.dagger.modules

import android.app.Application
import android.content.Context
import android.preference.PreferenceManager
import com.morcinek.androidutils.dagger.ForApplication
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

/**
 * Copyright 2015 Tomasz Morcinek. All rights reserved.
 */
@Module
class CoreModule(private val application: Application) {

    @Provides
    @Singleton
    fun provideContext(): Context {
        return application
    }

    @Provides
    @Singleton
    fun provideSharedPreferences() = PreferenceManager.getDefaultSharedPreferences(application)
}