package com.example.dagger2_mvp.dagger.components

import com.example.dagger2_mvp.dagger.modules.ApiCallActivityModule
import com.example.dagger2_mvp.dagger.scopes.ActivityScope
import com.example.dagger2_mvp.views.api_call.ApiCallActivity

import dagger.Subcomponent

@ActivityScope
@Subcomponent(modules = arrayOf(ApiCallActivityModule::class))
interface ApiCallActivityComponent {
    fun inject(apiCallActivity: ApiCallActivity)
}
