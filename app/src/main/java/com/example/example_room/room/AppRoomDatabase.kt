package com.example.example_room.room

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.example_room.room.artist.Artist
import com.example.example_room.room.artist.ArtistDao

@Database(entities = [(Artist::class)], version = 2, exportSchema = false)
abstract class AppRoomDatabase : RoomDatabase() {

    companion object {
        private var DATABASE_INSTANCE: AppRoomDatabase? = null

        fun getDatabaseInstance(context: Context): AppRoomDatabase {
            if (DATABASE_INSTANCE != null) return DATABASE_INSTANCE as AppRoomDatabase
            return Room.databaseBuilder(
                context.applicationContext,
                AppRoomDatabase::class.java,
                "spotify_database"
            )
                .fallbackToDestructiveMigration()
                .build()
        }
    }

    abstract fun artistDao(): ArtistDao
}