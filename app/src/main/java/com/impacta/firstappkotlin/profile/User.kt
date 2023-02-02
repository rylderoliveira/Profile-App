package com.impacta.firstappkotlin.profile

import com.impacta.firstappkotlin.R

data class User(
    val name: String,
    val age: Int,
    val city: String,
    val email: String,
    val photos: MutableList<Photo>,
    val curiosities: MutableList<Curiosity>,
)

data class Photo(
    val image: String,
    val description: String,
)

data class Curiosity(
    val title: String,
    val description: String,
)

fun getUser(): User {
    return User(
        name = "Rylder Oliveira",
        age = 25,
        city = "Araxá",
        email = "rylder@gmail.com",
        photos = mutableListOf(),
        curiosities = mutableListOf(
            Curiosity(
                title = "Curiosidade 1",
                description = "Descrição 1",
            ),
            Curiosity(
                title = "Curiosidade 2",
                description = "Descrição 2",
            ),
            Curiosity(
                title = "Curiosidade 3",
                description = "Descrição 3",
            ),
            Curiosity(
                title = "Curiosidade 4",
                description = "Descrição 4",
            ),
            Curiosity(
                title = "Curiosidade 5",
                description = "Descrição 5",
            ),
        ),
    )
}

fun generatePhotos() {
    val urlList = listOf(
        "https://i.pinimg.com/236x/8b/ee/9a/8bee9a0f5485ac940546c6009bfb679e.jpg",
        "https://i.pinimg.com/236x/fe/96/88/fe968866d54d5ca867a613c2ddb2b3a4--soccer-memes-funny-photoshop.jpg",
        "https://pbs.twimg.com/profile_images/1337764119596896256/oBLxrSLC_400x400.jpg",
        "https://pbs.twimg.com/media/Epy6Tq0XEAE9Q-X.jpg",
        "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRt-TrMyumPcB56kArfbfJ7Zy-sokjqB8rF9Hnpir3fTDvDeKLgqIgM69f1obJJw_EQXew&usqp=CAU",
    )
}