package com.example.specialtiesandworkers.data.network.dto

import com.google.gson.annotations.SerializedName

data class SpecialtyDTO(
    @SerializedName("specialty_id")
    val specialtyId: Int,
    @SerializedName("name")
    val specialtyName: String
)