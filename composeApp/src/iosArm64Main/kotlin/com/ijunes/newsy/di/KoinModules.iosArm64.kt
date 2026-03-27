package com.ijunes.newsy.di

import org.koin.dsl.module

actual val platformModule = module {
    single<PlatformHelper> { IosPlatformHelper() }
    single<DatabaseDriver> { IosDatabaseDriver() }
}