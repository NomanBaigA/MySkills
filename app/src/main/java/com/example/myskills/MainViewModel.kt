package com.example.myskills

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

// Step: 6 - create view model which interact with repository
class MainViewModel(private val skillRepository: SkillRepository) : ViewModel() {

    fun getSkills() : LiveData<List<Skill>>{
        return skillRepository.getSkills()
    }

    fun insertSkills(skill: Skill){
        viewModelScope.launch(Dispatchers.IO){
            skillRepository.insertSkills(skill)
        }
    }
}
