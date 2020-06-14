package com.sobierajski.zadanie.utils.exception;

public class RunScriptException extends Exception{
    public RunScriptException(String elementName) {
        super(constructMessage(elementName));
    }

    public RunScriptException(String elementName, Throwable cause) {
        super(constructMessage(elementName), cause);
    }

    private static String constructMessage(String elementName){
        StringBuilder sb = new StringBuilder();
        sb.append("Something went wrong when trying to run script :\"");
        sb.append(elementName);
        sb.append("\"");
        return sb.toString();
    }
}
