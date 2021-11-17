package com.example.specialtiesandworkers.domain.usecase

import com.example.specialtiesandworkers.data.repository.WorkersRepository
import com.example.specialtiesandworkers.domain.model.Specialty
import io.reactivex.Single
import javax.inject.Inject

class LoadSpecialtyUseCase @Inject constructor(
        private val workersRepository: WorkersRepository
) {

    fun invoke(): Single<List<Specialty>> {
        return workersRepository.getWorkers()
                .flatMap { workers ->
                    Single.just(workers.flatMap { it.specialty }.distinctBy { it.specialtyId })
                }
    }

}