import kotlin.random.Random

data class Post(
    var id: Int,
    val owner_id: Int,
    val from_id: Int,
    val created_by: Int,
    val like: Int,
    val text: String,
    val reply_owner_id: Int,
    val reply_post_id: Int,
    val friends_only: Boolean = true,
    val is_pinned: Boolean = true
) {}

object Likes {
    fun add(count: Int, user_likes: Boolean, can_like: Boolean, can_publish: Boolean) {
        val count = count
        val user_likes = user_likes
        val can_like = can_like
        val can_publish = can_publish
    }
}

object WallService {
    private var posts = emptyArray<Post>()
    fun add(post: Post, id: Int): Post {
        var post = post
        posts += post
        post.id = id + 1
        return posts.last()
    }

    fun update(post: Post, id: Int): Boolean {
        for ((index, post) in posts.withIndex()) {
            if (post.id == id) {
                posts[index] = post.copy(
                    owner_id = post.owner_id + 1,
                    from_id = post.from_id + 1,
                    created_by = post.created_by + 1,
                    like = post.like + 1,
                    reply_owner_id = post.reply_owner_id + 1,
                    reply_post_id = post.reply_post_id + 1
                )
            }
        }
        if (post.id == id) {return true
        } else return false
    }
}

fun main(args: Array<String>) {
    val post = Post(1, 15, 10, 12, 10, "hello", 1, 1)
    println(WallService.add(post, 1))
    println(WallService.update(post, 2))
}