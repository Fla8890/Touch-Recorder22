package com.touchrecorder.core.data

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "macros")
data class Macro(
    @PrimaryKey(autoGenerate = true) val id: Long = 0,
    val name: String,
    val actionsJson: String = "[]",
    val createdAt: Long = System.currentTimeMillis(),
)
