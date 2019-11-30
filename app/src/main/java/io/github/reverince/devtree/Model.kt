package io.github.reverince.devtree

data class InProgressBoard(val boardName: String, val startDay: String, val clearTask: String, val todoTask: String)

data class IntroduceBoard(val image: Int, val boardName: String, val boardDescription: String)