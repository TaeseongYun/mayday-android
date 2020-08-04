package com.project.mayday.ext

import android.app.Application
import com.project.mayday.BuildConfig
import org.koin.android.ext.koin.androidContext
import org.koin.android.logger.AndroidLogger
import org.koin.core.context.startKoin
import org.koin.core.logger.EmptyLogger
import org.koin.core.module.Module

fun setUpKoin(context: Application, vararg module: Module) {

    startKoin {
        logger(if (BuildConfig.DEBUG) AndroidLogger() else EmptyLogger())
        androidContext(context)
        modules(*module)
    }
}