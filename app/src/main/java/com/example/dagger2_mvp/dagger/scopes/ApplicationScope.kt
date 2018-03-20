package com.example.dagger2_mvp.dagger.scopes

import java.lang.annotation.Documented
import java.lang.annotation.Retention
import java.lang.annotation.RetentionPolicy

import javax.inject.Scope

@Documented
@Scope
@Retention(RetentionPolicy.RUNTIME)
annotation class ApplicationScope