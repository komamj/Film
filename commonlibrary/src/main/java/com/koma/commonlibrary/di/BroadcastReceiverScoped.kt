package com.koma.commonlibrary.di

import javax.inject.Scope

/**
 * The BroadcastReceiverScoped custom scoping annotation specifies that the lifespan of a dependency be
 * the same as that of a BroadcastReceiver. This is used to annotate dependencies that behave like a
 * singleton within the lifespan of a BroadcastReceiver.
 */
@Scope
@Retention(AnnotationRetention.RUNTIME)
@Target(AnnotationTarget.TYPE, AnnotationTarget.CLASS, AnnotationTarget.FUNCTION)
annotation class BroadcastReceiverScoped