package com.example.specialtiesandworkers.data.database.converters

import androidx.room.TypeConverter
import java.util.Date

class DateConverter {

    @TypeConverter
    fun fromDate(value: Date?): Long? {
        return value?.time
    }

    @TypeConverter
    fun toDate(value: Long?): Date? {
        value?.let { return Date(it) }

        return null
    }

}