import org.junit.jupiter.api.Assertions.assertFalse
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test

class GroupUserTest {
    @Test
    fun testGroup() {
        val group = GroupUser.Group;
        assertTrue(group.isGroup())
        assertFalse(group.isUser())
    }

    @Test
    fun testUser() {
        val user = GroupUser.User;
        assertFalse(user.isGroup())
        assertTrue(user.isUser())
    }
}