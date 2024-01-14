package Enums;

public enum Status {
    COLD ("холодные"),
    WARM ("теплые");
    private String title;
    Status (String title){
        this.title = title;
    }
    public String getTitle(){
        return this.title;
    }

    @Override
    public String toString() {
        return title;
    }
}
