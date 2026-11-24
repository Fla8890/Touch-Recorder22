package com.touchrecorder.core.di

import android.content.Context
import androidx.room.Room
import com.touchrecorder.core.data.TouchRecorderDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {
    @Provides
    @Singleton
    fun provideTouchRecorderDatabase(
        @ApplicationContext context: Context,
    ): TouchRecorderDatabase = Room.databaseBuilder(
        context,
        TouchRecorderDatabase::class.java,
        "touch_recorder.db",
    ).build()
}
