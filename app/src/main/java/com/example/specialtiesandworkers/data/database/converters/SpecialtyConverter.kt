package com.example.specialtiesandworkers.data.database.converters

import androidx.room.TypeConverter
import com.example.specialtiesandworkers.domain.model.Specialty
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

class SpecialtyConverter {

    @TypeConverter
    fun fromSpecialtyList(value: List<Specialty>): String {
        val gson = Gson()
        val type = object : TypeToken<List<Specialty>>() {}.type

        return gson.toJson(value, type)
    }

    @TypeConverter
    fun toSpecialtyList(value: String) {
        val gson = Gson()
        val type = object : TypeToken<List<Specialty>>() {}.type

        return gson.fromJson(value, type)
    }

}