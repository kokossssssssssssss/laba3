package enums;

public enum Status {
    COLD ("холодные"),
    WARM ("теплые");
    private final String title;
    Status (String title){
        this.title = title;
    }

    @Override
    public String toString() {
        return title;
    }
}
