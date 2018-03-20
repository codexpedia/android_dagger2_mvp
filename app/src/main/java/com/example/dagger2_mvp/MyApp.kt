package com.example.dagger2_mvp

import android.app.Application

import com.example.dagger2_mvp.dagger.components.DaggerMyAppComponent
import com.example.dagger2_mvp.dagger.components.MyAppComponent
import com.example.dagger2_mvp.dagger.modules.MyAppModule
import com.example.dagger2_mvp.dagger.modules.WebServiceModule
import com.example.dagger2_mvp.dagger.modules.PersistentModule

class MyApp : Application() {

    var myAppComponent: MyAppComponent? = null
        private set

    override fun onCreate() {
        super.onCreate()

        myAppComponent = DaggerMyAppComponent.builder()
                .myAppModule(MyAppModule(this))
                .persistentModule(PersistentModule())
                .webServiceModule(WebServiceModule(Constants.BASE_URL))
                .build()
        myAppComponent!!.inject(this)
    }


}