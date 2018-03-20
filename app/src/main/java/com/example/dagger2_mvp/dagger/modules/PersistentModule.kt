package com.example.dagger2_mvp.dagger.modules

import android.content.Context
import android.content.SharedPreferences
import android.preference.PreferenceManager

import com.example.dagger2_mvp.dagger.scopes.ApplicationScope

import dagger.Module
import dagger.Provides

@Module
class PersistentModule {
    @Provides
    @ApplicationScope
    fun providesSharedPreferences(myAppContext: Context): SharedPreferences {
        return PreferenceManager.getDefaultSharedPreferences(myAppContext)
    }
}