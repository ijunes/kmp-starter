package com.ijunes.newsy.di

import com.ijunes.newsy.news.data.repository.NewsRepository
import org.koin.core.module.Module
import org.koin.dsl.module

// Shared definitions (Compiler Plugin DSL)
val sharedModule = module {
    single { NewsRepository() }

}

// Platform-specific modules (defined per platform)
expect val platformModule: Module