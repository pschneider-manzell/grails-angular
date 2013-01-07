package de.psm

/**
 * @author Peter Schneider-Manzell
 */
class Todo {
    boolean done
    String description

    static constraints = {
        description(blank: false)
    }
}
