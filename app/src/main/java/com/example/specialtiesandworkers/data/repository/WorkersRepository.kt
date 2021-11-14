package com.example.specialtiesandworkers.data.repository

import androidx.room.EmptyResultSetException
import com.example.specialtiesandworkers.data.database.AppDatabase
import com.example.specialtiesandworkers.data.network.api.WorkersApi
import com.example.specialtiesandworkers.data.utils.toWorker
import com.example.specialtiesandworkers.data.utils.toWorkerEntity
import com.example.specialtiesandworkers.domain.model.Worker
import io.reactivex.Single
import javax.inject.Inject

class WorkersRepository @Inject constructor(
        private val workersApi: WorkersApi,
        private val db: AppDatabase
) {

    fun getWorkers(): Single<List<Worker>> {
        return db.workersDao().getWorkers()
                .onErrorResumeNext { exception ->
                    if (exception is EmptyResultSetException) {
                        loadWorkersFromServer()
                    } else {
                        Single.error(exception)
                    }
                }
    }

    private fun loadWorkersFromServer(): Single<List<Worker>> {
        return workersApi.getWorkers()
                .flatMap { dtoWorkers ->
                    val dbWorkers = dtoWorkers.map { it.toWorkerEntity() }
                    db.workersDao().insertWorkers(dbWorkers)
                            .toSingle { dbWorkers.map { it.toWorker() } }
                }
    }

}