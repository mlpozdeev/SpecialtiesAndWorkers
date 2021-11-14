package com.example.specialtiesandworkers.data.network.dto

import com.google.gson.annotations.SerializedName
import java.util.Date

data class WorkerDTO(
    @SerializedName("f_name")
    val firstName: String,
    @SerializedName("l_name")
    val lastName: String,
    @SerializedName("birthday")
    val birthday: Date?,
    @SerializedName("avatar_url")
    val avatarUrl: String,
    @SerializedName("specialty")
    val specialty: List<SpecialtyDTO>
)
