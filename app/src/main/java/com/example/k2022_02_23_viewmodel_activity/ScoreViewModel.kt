package com.example.k2022_02_23_viewmodel_activity

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

const val TAG: String = "ScoreViewModel"

class ScoreViewModel: ViewModel() {

    private var _score: MutableLiveData<Int> = MutableLiveData<Int>(0)

    fun getScore() : LiveData<Int> {
        return _score
    }

    fun decrement() {
        _score.value = _score.value?.minus(1)
    }

    fun increment() {
        _score.value = _score.value?.plus(1)
    }

    fun zero() {
        _score.value = 0
    }
}