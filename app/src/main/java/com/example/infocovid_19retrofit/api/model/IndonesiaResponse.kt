package com.example.infocovid_19retrofit.api.model

data class IndonesiaResponse(
    val name: String,
    val positif: String,
    val sembuh: String,
    val meninggal: String,
    val dirawat: String
)