package com.example.myskills

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

// Step: 7 - Factory is responsible to create your instance of ViewModel.
class MainViewModelFactory(private val skillRepository: SkillRepository) : ViewModelProvider.Factory{
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return MainViewModel(skillRepository) as T
    }
}
