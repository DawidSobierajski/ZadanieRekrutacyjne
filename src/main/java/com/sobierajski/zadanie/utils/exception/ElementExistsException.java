package com.sobierajski.zadanie.utils.exception;

import lombok.NonNull;

public class ElementExistsException extends Exception {
    public ElementExistsException(String elementName, Throwable cause) {
        super(constructMessage(elementName), cause);
    }

    public ElementExistsException(String elementName) {
        super(constructMessage(elementName));
    }

    @NonNull
    private static String constructMessage(@NonNull String elementName) {
        StringBuilder sb = new StringBuilder();
        sb.append("Element ")
                .append(elementName)
                .append(" already exists in database");
        return sb.toString();
    }
}
