data class Post(
    val id: Int,
    val ownerId: Int,
    val fromId: Int,
    val createdBy: Int,
    val like: Int,
    val text: String,
    val replyOwnerId: Int,
    val replyPostId: Int,
    val friendsOnly: Boolean = true,
    val isPinned: Boolean = true,
    val date: Long
) {}

data class Likes(
    val count: Int,
    val userLikes: Boolean,
    val canLike: Boolean,
    val canPublish: Boolean
) {}

object WallService {
    private var posts = emptyArray<Post>()
    private var nextId = 1
    fun add(post: Post): Post {
        posts += post.copy(id = nextId++)
        return posts.last()
    }

    fun update(newPost: Post): Boolean {
        for ((index, post) in posts.withIndex()) {
            if (post.id == newPost.id) {
                posts[index] = newPost.copy(
                    ownerId = post.ownerId,
                    date = post.date
                )
                return true
            }
        }
        return false
    }
}

fun main(args: Array<String>) {
    val post = Post(1, 15, 10, 12, 10, "hello", 1, 1, date = 16688636)
    val posts = Post(2, 15, 10, 12, 10, "hello", 1, 1, date = 116688637)
    println(WallService.add(post))
    println(WallService.add(posts))
    println(WallService.update(posts))
}