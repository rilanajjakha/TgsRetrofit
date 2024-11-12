package com.example.tgsretrofit.model

import com.google.gson.annotations.SerializedName

data class ApiData(
    @SerializedName("tracks") val tracks: Tracks
)

data class Tracks(
    @SerializedName("data") val data: List<Track>
)

data class Track(
    @SerializedName("id") val id: Long,
    @SerializedName("title") val title: String,
    @SerializedName("artist") val artist: Artist,
    @SerializedName("album") val album: Album
)

data class Artist(
    @SerializedName("name") val name: String
)

data class Album(
    @SerializedName("cover_medium") val coverUrl: String,
)














//
//data class ApiData(
//    @SerializedName("tracks") val tracks: Tracks
//)
//
//data class Tracks(
//    @SerializedName("data") val data: List<Track>
//)
//
//data class Track(
//    @SerializedName("id") val id: Long,
//    @SerializedName("title") val title: String,
//    @SerializedName("link") val link: String,
//    @SerializedName("duration") val duration: Int,
//    @SerializedName("explicit_lyrics") val explicitLyrics: Boolean,
//    @SerializedName("preview") val previewUrl: String,
//    @SerializedName("position") val position: Int,
//    @SerializedName("artist") val artist: Artist,
//    @SerializedName("album") val album: Album
//)
//
//data class Artist(
//    @SerializedName("id") val id: Int,
//    @SerializedName("name") val name: String,
//    @SerializedName("link") val link: String,
//    @SerializedName("picture_medium") val pictureUrl: String
//)
//
//data class Album(
//    @SerializedName("id") val id: Long,
//    @SerializedName("title") val title: String,
//    @SerializedName("cover_medium") val coverUrl: String
//)
