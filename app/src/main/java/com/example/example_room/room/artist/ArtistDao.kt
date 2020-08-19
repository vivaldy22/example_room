package com.example.example_room.room.artist

import androidx.lifecycle.LiveData
import androidx.room.*

@Dao
interface ArtistDao {
    @Insert
    fun createArtist(artist: Artist)

    @Query(value = "SELECT * FROM Artist")
    fun getAllArtists(): LiveData<List<Artist>>

    @Query(value = "SELECT * FROM Artist WHERE id = :id")
    fun getArtistById(id: Int): Artist

    @Delete
    fun deleteArtist(artist: Artist)

    @Update
    fun updateArtist(artist: Artist)
}