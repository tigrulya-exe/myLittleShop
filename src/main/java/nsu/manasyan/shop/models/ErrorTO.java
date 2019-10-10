package nsu.manasyan.shop.models;

public class ErrorTO {
    private String errorMessage;

    public ErrorTO(){}

    public ErrorTO(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }
}