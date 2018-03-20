package com.example.dagger2_mvp.dagger.components

import com.example.dagger2_mvp.MyApp
import com.example.dagger2_mvp.dagger.modules.ApiCallActivityModule
import com.example.dagger2_mvp.dagger.modules.MyAppModule
import com.example.dagger2_mvp.dagger.modules.PersistentModule
import com.example.dagger2_mvp.dagger.modules.SharedPrefActivityModule
import com.example.dagger2_mvp.dagger.modules.WebServiceModule
import com.example.dagger2_mvp.dagger.scopes.ApplicationScope

import dagger.Component

@ApplicationScope
@Component(modules = arrayOf(MyAppModule::class, PersistentModule::class, WebServiceModule::class))
interface MyAppComponent {
    // Specify child components
    fun addSharedPrefActivityComponent(sharedPrefActivityModule: SharedPrefActivityModule): SharedPrefActivityComponent

    fun addApiCallActivityComponent(apiCallActivityModule: ApiCallActivityModule): ApiCallActivityComponent


    fun inject(myApp: MyApp)
}
