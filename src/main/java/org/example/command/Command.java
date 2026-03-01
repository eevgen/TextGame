package org.example.command;

/**
 * Base command interface - all game commands implement this.
 * Uses Command design pattern for consistency.
 * @author Text Game Team
 */
public interface Command {

    /**
     * Executes the command action.
     */
    void execute();

    /**
     * Undoes the command (not implemented yet).
     */
    void undo();
}
