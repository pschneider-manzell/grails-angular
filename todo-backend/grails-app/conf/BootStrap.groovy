import de.psm.Todo

class BootStrap {

    def init = { servletContext ->
        (1..100).each {
            new Todo(description: "Todo number $it", done: it%2 == 0).save(failOnError: true)
        }
    }
    def destroy = {
    }
}
