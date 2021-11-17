package com.example.specialtiesandworkers.presentation.specialty.view

import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import com.example.specialtiesandworkers.domain.model.Specialty

class SpecialtyRecyclerViewAdapter : ListAdapter<Specialty, SpecialtyViewHolder>(ITEM_COMPARATOR) {

    companion object {

        private val ITEM_COMPARATOR = object : DiffUtil.ItemCallback<Specialty>() {
            override fun areItemsTheSame(oldItem: Specialty, newItem: Specialty): Boolean {
                return oldItem.specialtyId == newItem.specialtyId
            }

            override fun areContentsTheSame(oldItem: Specialty, newItem: Specialty): Boolean {
                return oldItem == newItem
            }
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SpecialtyViewHolder {
        return SpecialtyViewHolder.create(parent)
    }

    override fun onBindViewHolder(holder: SpecialtyViewHolder, position: Int) {
        holder.bind(item = currentList[position])
    }

}