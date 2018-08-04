package domain.model.identity

interface Identities {
    val id: Long
    val accountNumber: String
    val mailAddress: MailAddress
    fun identityType(): GroupUser
}

class User(override val id: Long, override val accountNumber: String, override val mailAddress: MailAddress) : Identities {
    override fun identityType(): GroupUser {
        return GroupUser.User
    }

}
class Group(override val id: Long, override val accountNumber: String, override val mailAddress: MailAddress) : Identities {
    override fun identityType(): GroupUser {
        return GroupUser.Group
    }
}
