package domain.model.identity

import junit.framework.TestCase.assertFalse
import org.junit.Assert.assertTrue
import org.junit.Test

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