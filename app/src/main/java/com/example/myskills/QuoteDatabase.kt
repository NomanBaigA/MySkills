package com.example.myskills

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

// Step: 3 (Room DB) - with this class room implementation is done

@Database(entities = [Skill::class], version = 1)
abstract class SkillDatabase : RoomDatabase() {
    abstract fun skillDao(): SkillDao

    companion object {
        private var INSTANCE: SkillDatabase? = null
        fun getDatabase(context: Context): SkillDatabase {
            if (INSTANCE == null) {
                synchronized(this) {
                    INSTANCE = Room.databaseBuilder(
                        context,
                        SkillDatabase::class.java,
                        "skill_database"
                    )
                        .build()
                }
            }
            return INSTANCE!!
        }
    }
}
