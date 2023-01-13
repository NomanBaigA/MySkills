package com.example.myskills

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query

// Step: 2 (Room DB) - interface

@Dao
interface SkillDao {

    @Query("SELECT id, skill from skillTable")
    fun getSkills() : LiveData<List<Skill>>

    @Insert
    suspend fun insertSkills(skillTable: Skill)
}
