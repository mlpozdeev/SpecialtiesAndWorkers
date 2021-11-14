package com.example.specialtiesandworkers.data.network.api

import com.example.specialtiesandworkers.data.network.dto.WorkerDTO
import io.reactivex.Single
import retrofit2.http.GET

interface WorkersApi {

    @GET("./65gb/static/raw/master/testTask.json")
    fun getWorkers(): Single<WorkerDTO>

}