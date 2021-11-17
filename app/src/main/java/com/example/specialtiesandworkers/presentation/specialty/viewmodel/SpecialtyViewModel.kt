package com.example.specialtiesandworkers.presentation.specialty.viewmodel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.specialtiesandworkers.domain.model.Specialty
import com.example.specialtiesandworkers.domain.usecase.LoadSpecialtyUseCase
import io.reactivex.disposables.CompositeDisposable

class SpecialtyViewModel(
    private val loadSpecialtyUseCase: LoadSpecialtyUseCase
) : ViewModel() {

    init {
        load()
    }

    private val compositeDisposable: CompositeDisposable = CompositeDisposable()

    private val _specialtyList: MutableLiveData<List<Specialty>> = MutableLiveData()
    val specialtyList: LiveData<List<Specialty>> = _specialtyList

    override fun onCleared() {
        super.onCleared()

        compositeDisposable.dispose()
    }

    private fun load() {
        compositeDisposable.add(
            loadSpecialtyUseCase.invoke()
                .subscribe({
                    _specialtyList.postValue(it)
                }, {
                    Log.e("SpecialtyViewModel", it.message ?: "")
                })
        )
    }

}