import org.junit.Test

import org.junit.Assert.*

class WallServiceTest {

    @Test
    fun add() {
        val post = Post(0, 15, 10, 12, 10, "hello", 1, 1)
        WallService.add(post, 0)
        val result = Post(1, 15, 10, 12, 10, "hello", 1, 1)
        if (post.id != 0) assertEquals(result, post)
    }

    @Test
    fun updateTrue() {
        val post = Post(0, 15, 10, 12, 10, "hello", 1, 1)
        val result = true
        assertEquals(result, WallService.update(post,0))

    }

    @Test
    fun updateFalse() {
        val post = Post(1, 15, 10, 12, 10, "hello", 1, 1)
        val result = false
        assertEquals(result, WallService.update(post,0))
    }
}