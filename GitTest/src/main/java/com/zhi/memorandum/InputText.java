package com.zhi.memorandum;

public class InputText {
    private final StringBuilder inputText = new StringBuilder();

    public String getText() {
        return inputText.toString();
    }

    public void append(String text) {
        inputText.append(text);
    }

    public SnapShot createSnapShot() {
        return new SnapShot(inputText.toString());
    }

    public void restoreSnapShot(SnapShot snapShot) {
        this.inputText.replace(0, inputText.length(), snapShot.getText());
    }
}