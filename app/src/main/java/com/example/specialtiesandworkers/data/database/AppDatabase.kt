package com.example.specialtiesandworkers.data.database

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.example.specialtiesandworkers.data.database.converters.DateConverter
import com.example.specialtiesandworkers.data.database.converters.SpecialtyConverter
import com.example.specialtiesandworkers.data.database.dao.WorkersDao
import com.example.specialtiesandworkers.data.database.entity.WorkerEntity

@Database(
    entities = [WorkerEntity::class],
    version = 1,
    exportSchema = false
)
@TypeConverters(
    DateConverter::class,
    SpecialtyConverter::class
)
abstract class AppDatabase : RoomDatabase() {

    companion object {
        const val DB_NAME = "workers.db"
    }

    abstract fun workersDao(): WorkersDao

}