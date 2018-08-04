package domain.model.identity

enum class GroupUser {
    Group {
        override fun isGroup(): Boolean {
            return true
        }
    },
    User {
        override fun isUser(): Boolean {
            return true
        }
    };

    open fun isGroup(): Boolean {
        return false
    }

    open fun isUser(): Boolean {
        return false
    }

}