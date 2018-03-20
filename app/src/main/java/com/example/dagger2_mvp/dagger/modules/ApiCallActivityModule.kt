package com.example.dagger2_mvp.dagger.modules

import com.example.dagger2_mvp.dagger.scopes.ActivityScope
import com.example.dagger2_mvp.views.api_call.ApiCallScreenContract

import dagger.Module
import dagger.Provides

@Module
class ApiCallActivityModule(var mView: ApiCallScreenContract.View) {

    @Provides
    @ActivityScope
    fun providesApiCallScreenContractView(): ApiCallScreenContract.View {
        return mView
    }
}