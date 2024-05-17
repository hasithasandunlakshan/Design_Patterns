package Behavioral.Mediator;

interface ChatMediator {
    void showMessage(String message, User user);
}

class ChatRoom implements ChatMediator {

    @Override
    public void showMessage(String message, User user) {
        System.out.println(user.getName() + ": " + message);
    }
}

abstract class User {
    protected ChatMediator mediator;
    protected String name;

    public User(ChatMediator mediator, String name) {
        this.mediator = mediator;
        this.name = name;
    }

    public abstract void send(String message);

    public abstract String getName();
}

class ChatUser extends User {

    public ChatUser(ChatMediator mediator, String name) {
        super(mediator, name);
    }

    @Override
    public void send(String message) {
        mediator.showMessage(message, this);
    }

    @Override
    public String getName() {
        return name;
    }
}

public class main {
    public static void main(String[] args) {
        ChatMediator mediator = new ChatRoom();

        User user1 = new ChatUser(mediator, "Alice");
        User user2 = new ChatUser(mediator, "Bob");

        user1.send("Hi Bob!");
        user2.send("Hello Alice!");
    }
}
