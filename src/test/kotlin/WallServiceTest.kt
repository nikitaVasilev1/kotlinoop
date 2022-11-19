import org.junit.Test

import org.junit.Assert.*

class WallServiceTest {

    @Test
    fun add() {
        val post = Post(0, 15, 10, 12, 10, "hello", 1, 1,date = 16688636)
        val result = WallService.add(post)
        assertNotEquals(post.id,result.id)
    }

    @Test
    fun updateTrue() {
        val post = Post(0, 15, 10, 12, 10, "hello", 1, 1, date = 16688636)
        val addedId = WallService.add(post).id
        val updatePost = Post( addedId,15, 10, 12, 10, "hello", 1, 1, date = 16688636)
        val result = WallService.update(updatePost)
        assertEquals(true,result)
    }
    @Test
    fun updateFalse() {
        val post = Post(0, 15, 10, 12, 10, "hello", 1, 1, date = 16688636)
        val addedId = WallService.add(post).id
        val updatePost = Post( addedId + 1,15, 10, 12, 10, "hello", 1, 1, date = 16688636)
        val result = WallService.update(updatePost)
        assertEquals(false,result)
    }
}