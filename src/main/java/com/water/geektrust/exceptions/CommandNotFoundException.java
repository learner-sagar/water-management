package com.water.geektrust.exceptions;

public class CommandNotFoundException extends RuntimeException{
    public CommandNotFoundException(){
        super();
    }

    public CommandNotFoundException(String msg){
        super(msg);
    }
}
