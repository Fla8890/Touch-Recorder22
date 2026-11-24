package com.touchrecorder.core.data

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(
    entities = [Macro::class, Profile::class],
    version = 1,
    exportSchema = false,
)
abstract class TouchRecorderDatabase : RoomDatabase()
