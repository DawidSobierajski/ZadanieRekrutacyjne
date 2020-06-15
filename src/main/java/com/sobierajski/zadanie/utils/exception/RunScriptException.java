package com.sobierajski.zadanie.utils.exception;

public class RunScriptException extends Exception {
    public RunScriptException(String elementName, String reason) {
        super(constructMessage(elementName,reason));
    }

    public RunScriptException(String elementName, String reason, Throwable cause) {
        super(constructMessage(elementName,reason), cause);
    }

    private static String constructMessage(String elementName, String reason) {
        StringBuilder sb = new StringBuilder();
        sb.append("Something went wrong when trying to run script :\"");
        sb.append(elementName);
        sb.append("\"");
        sb.append(" Reason: ").append(reason);
        return sb.toString();
    }
}
