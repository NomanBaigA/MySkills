package com.example.myskills

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

// Step: 1 (Room DB) - data class

@Entity(tableName = "skillTable")
data class Skill(
    @PrimaryKey(autoGenerate = true)
    val id : Int,

    // val skill: String
    // OR
    @ColumnInfo(name = "skill") var skill: String
)
