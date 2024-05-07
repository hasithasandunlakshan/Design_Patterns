package Creational.AbstractFractory.AnotherExample;

interface Button {
    String render();
}

interface Checkbox {
    String render();
}

class WindowsButton implements Button {
    @Override
    public String render() {
        return "Windows-style button";
    }
}

class WindowsCheckbox implements Checkbox {
    @Override
    public String render() {
        return "Windows-style checkbox";
    }
}

class MacButton implements Button {
    @Override
    public String render() {
        return "Mac-style button";
    }
}

class MacCheckbox implements Checkbox {
    @Override
    public String render() {
        return "Mac-style checkbox";
    }
}

interface UIFactory {
    Button createButton();

    Checkbox createCheckbox();
}

class WindowsFactory implements UIFactory {
    @Override
    public Button createButton() {
        return new WindowsButton();
    }

    @Override
    public Checkbox createCheckbox() {
        return new WindowsCheckbox();
    }
}

class MacFactory implements UIFactory {
    @Override
    public Button createButton() {
        return new MacButton();
    }

    @Override
    public Checkbox createCheckbox() {
        return new MacCheckbox();
    }
}

public class Main {
    public static void main(String[] args) {
        UIFactory windowsFactory = new WindowsFactory();
        Button windowsButton = windowsFactory.createButton();
        Checkbox windowsCheckbox = windowsFactory.createCheckbox();
        System.out.println(windowsButton.render()); // Output: Windows-style button
        System.out.println(windowsCheckbox.render()); // Output: Windows-style checkbox

        UIFactory macFactory = new MacFactory();
        Button macButton = macFactory.createButton();
        Checkbox macCheckbox = macFactory.createCheckbox();
        System.out.println(macButton.render()); // Output: Mac-style button
        System.out.println(macCheckbox.render()); // Output: Mac-style checkbox
    }
}
