package com.example.example_room.room.artist

class ArtistRepository(private val artistDao: ArtistDao) {

    val allArtist = artistDao.getAllArtists()

    fun createArtist(artist: Artist) {
        artistDao.createArtist(artist)
    }

}