package com.example.specialtiesandworkers.data.database.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.specialtiesandworkers.domain.model.Specialty
import java.util.Date

@Entity(tableName = "worker")
data class WorkerEntity(
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id")
    var id: Int = 0,
    @ColumnInfo(name = "f_name")
    val firstName: String,
    @ColumnInfo(name = "l_name")
    val lastName: String,
    @ColumnInfo(name = "birthday")
    val birthday: Date?,
    @ColumnInfo(name = "avatar_url")
    val avatarUrl: String,
    @ColumnInfo(name = "specialty")
    val specialty: List<Specialty>
)
