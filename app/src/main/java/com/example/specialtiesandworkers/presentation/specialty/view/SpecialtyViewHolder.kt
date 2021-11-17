package com.example.specialtiesandworkers.presentation.specialty.view

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.specialtiesandworkers.R
import com.example.specialtiesandworkers.domain.model.Specialty

class SpecialtyViewHolder(view: View) : RecyclerView.ViewHolder(view) {

    companion object {

        fun create(parent: ViewGroup): SpecialtyViewHolder {
            val view = LayoutInflater
                .from(parent.context)
                .inflate(R.layout.item_specialty, parent, false)

            return SpecialtyViewHolder(view)
        }

    }

    private val specialtyNameTextView: TextView = view.findViewById(R.id.specialty_name_text_view)

    fun bind(item: Specialty) {
        specialtyNameTextView.text = item.specialtyName
    }

}