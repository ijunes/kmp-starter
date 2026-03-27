package com.ijunes.newsy.di

import org.koin.dsl.module

actual val platformModule = module {
    // Classic DSL with lambda for custom construction
    single<PlatformHelper> { AndroidPlatformHelper(get()) }
    single<DatabaseDriver> { AndroidDatabaseDriver(get()) }
}