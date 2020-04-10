package io.hikari.labs.gof23.behavioral.command;

/**
 * Command Pattern
 *
 * @author Noa Swartz
 * @date 2018-06-15
 */
public class CommandPattern {

    public static void main(String[] args) {
        Door door = new Door();
        Command openCommand = new OpenCommand(door);
        Command closeCommand = new CloseCommand(door);
        Person person = new Person(openCommand, closeCommand);
        person.handleOpen();
        person.handleClose();
    }

}

interface Command {
    void execute();
}

class Door {
    public void open() {
        System.err.println("Open door.");
    }
    public void close() {
        System.err.println("Close door.");
    }
}

class OpenCommand implements Command {
    private Door door;
    public OpenCommand(Door door) {
        this.door = door;
    }
    @Override
    public void execute() {
        door.open();
    }
}

class CloseCommand implements Command {
    private Door door;
    public CloseCommand(Door door) {
        this.door = door;
    }
    @Override
    public void execute() {
        door.close();
    }
}

class Person {
    private Command openCommand;
    private Command closeCommand;
    public Person(Command openCommand, Command closeCommand) {
        this.openCommand = openCommand;
        this.closeCommand = closeCommand;
    }
    public void handleOpen() {
        System.err.print("Person ");
        openCommand.execute();
    }
    public void handleClose() {
        System.err.print("Person ");
        closeCommand.execute();
    }
}