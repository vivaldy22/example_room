package com.example.example_room

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.activity.viewModels
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.example_room.room.artist.Artist
import com.example.example_room.viewmodel.artist.ArtistViewModel
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private val artistViewModel by viewModels<ArtistViewModel>()
    lateinit var artistRecyclerViewAdapter: ArtistRecyclerViewAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        artistRecyclerView.layoutManager = LinearLayoutManager(this)
        artistViewModel.allArtist.observe(this, Observer {
            artistRecyclerViewAdapter = ArtistRecyclerViewAdapter(it)
            artistRecyclerView.adapter = artistRecyclerViewAdapter
        })
    }

    fun addNewArtist(v: View) {
        val name = artistNameInputText.text.toString()
        val debut = debutInputText.text.toString()
        artistViewModel.createNewArtist(Artist(name = name, debut = debut, originPlace = ""))
    }

}