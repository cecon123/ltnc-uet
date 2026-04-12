public class Main {

    public static void main(String[] args) {
        String config = "win"; // đổi thành "mac" để test

        UIFactory factory;

        if (config.equalsIgnoreCase("win")) {
            factory = new WindowsFactory();
        } else if (config.equalsIgnoreCase("mac")) {
            factory = new MacFactory();
        } else {
            throw new IllegalArgumentException("Invalid configuration!");
        }

        Button button = factory.createButton();
        Checkbox checkbox = factory.createCheckbox();

        button.render();
        checkbox.render();
    }
}
