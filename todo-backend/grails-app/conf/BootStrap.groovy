import de.psm.Role
import de.psm.Todo
import de.psm.User
import de.psm.UserRole

class BootStrap {

    def init = { servletContext ->
        (1..100).each {
            new Todo(description: "Todo number $it", done: it%2 == 0).save(failOnError: true)
        }

        Role userRole = new Role(authority:"ROLE_USER").save(failOnError: true)
        Role adminRole = new Role(authority:"ROLE_ADMIN").save(failOnError: true)

        User user = new User(username: "user",password: "testpass",enabled: true).save(failOnError: true)
        User admin = new User(username: "admin",password: "testpass",enabled: true).save(failOnError: true)
        UserRole.create(user,userRole)
        UserRole.create(admin,userRole)
        UserRole.create(admin,adminRole)

    }
    def destroy = {
    }
}
