package com.example.specialtiesandworkers.data.utils

import com.example.specialtiesandworkers.data.database.entity.WorkerEntity
import com.example.specialtiesandworkers.data.network.dto.SpecialtyDTO
import com.example.specialtiesandworkers.data.network.dto.WorkerDTO
import com.example.specialtiesandworkers.domain.model.Specialty
import com.example.specialtiesandworkers.domain.model.Worker

fun WorkerDTO.toWorkerEntity(): WorkerEntity {
    return WorkerEntity(
            firstName = this.firstName,
            lastName = this.lastName,
            birthday = this.birthday,
            avatarUrl = this.avatarUrl,
            specialty = this.specialty.map {
                it.toSpecialty()
            }
    )
}

fun SpecialtyDTO.toSpecialty(): Specialty {
    return Specialty(
            specialtyId = this.specialtyId,
            specialtyName = this.specialtyName
    )
}

fun WorkerEntity.toWorker(): Worker {
    return Worker(
            firstName = this.firstName,
            lastName = this.lastName,
            birthday = this.birthday,
            avatarUrl = this.avatarUrl,
            specialty = this.specialty
    )
}