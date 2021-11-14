package com.example.specialtiesandworkers.domain.model

import java.util.Date

data class Worker(
    val firsName: String,
    val lastName: String,
    val birthday: Date?,
    val avatarUrl: String,
    val specialty: List<Specialty>
)
