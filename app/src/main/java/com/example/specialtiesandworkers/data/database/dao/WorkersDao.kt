package com.example.specialtiesandworkers.data.database.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.example.specialtiesandworkers.data.database.entity.WorkerEntity
import com.example.specialtiesandworkers.domain.model.Worker
import io.reactivex.Completable
import io.reactivex.Single

@Dao
interface WorkersDao {

    @Insert
    fun insertWorkers(workers: List<WorkerEntity>): Completable

    @Query("SELECT * FROM worker")
    fun getWorkers(): Single<List<WorkerEntity>>

}