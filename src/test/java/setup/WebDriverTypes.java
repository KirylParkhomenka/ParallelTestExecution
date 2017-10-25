package setup;

public enum WebDriverTypes {

    chrome("chrome"),
    firefox("firefox");

    private final String browserName;

    WebDriverTypes(final String text) {
        this.browserName = text;
    }

    @Override
    public String toString() {
        return this.browserName;
    }
}