package com.example.myskills

import androidx.lifecycle.LiveData

// Step: 4 - create repository which talks with data sources it can be database or external api

class SkillRepository(private val skillDao: SkillDao) {

    fun getSkills(): LiveData<List<Skill>>{
        return skillDao.getSkills()
    }

    suspend fun insertSkills(skill: Skill){
        skillDao.insertSkills(skill)
    }
}