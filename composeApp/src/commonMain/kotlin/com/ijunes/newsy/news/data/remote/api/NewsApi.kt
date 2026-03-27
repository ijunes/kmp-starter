package com.ijunes.newsy.news.data.remote.api

import de.jensklingenberg.ktorfit.http.GET
import de.jensklingenberg.ktorfit.http.Query
import de.jensklingenberg.ktorfit.http.QueryMap

interface NewsApi {
    @GET("/v2/everything")
    fun getNews(
        @QueryMap queryMap: Map<String, String>,
        @Query apiKey: String
    )
}
