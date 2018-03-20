package com.example.dagger2_mvp.dagger.components

import com.example.dagger2_mvp.dagger.modules.SharedPrefActivityModule
import com.example.dagger2_mvp.dagger.scopes.ActivityScope
import com.example.dagger2_mvp.views.shared_pref.SharedPrefActivity

import dagger.Subcomponent

@ActivityScope
@Subcomponent(modules = arrayOf(SharedPrefActivityModule::class))
interface SharedPrefActivityComponent {
    fun inject(sharedPrefActivity: SharedPrefActivity)
}
