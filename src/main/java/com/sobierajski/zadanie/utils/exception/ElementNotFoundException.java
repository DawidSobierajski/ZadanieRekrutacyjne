package com.sobierajski.zadanie.utils.exception;

import lombok.NonNull;

public class ElementNotFoundException extends Exception {
    public ElementNotFoundException(String elementName) {
        super(constructMessage(elementName));
    }

    public ElementNotFoundException(String elementName, Throwable cause) {
        super(constructMessage(elementName), cause);
    }

    @NonNull
    private static String constructMessage(@NonNull String elementName) {
        StringBuilder sb = new StringBuilder();
        sb.append("Element ")
                .append(elementName)
                .append(" not found in database");
        return sb.toString();
    }
}
