package com.ray.demo.gitstuff.di

import java.lang.annotation.Documented
import java.lang.annotation.Retention
import java.lang.annotation.RetentionPolicy.RUNTIME
import javax.inject.Scope

//Custom Scope
@Scope
@Documented
@Retention(RUNTIME)
annotation class AuthScope {

}