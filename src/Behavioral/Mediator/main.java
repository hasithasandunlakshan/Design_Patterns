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
