package uz.sardor.myapplication.model

data class PostData(
    val limit: Int,
    val posts: List<Post>,
    val skip: Int,
    val total: Int
)