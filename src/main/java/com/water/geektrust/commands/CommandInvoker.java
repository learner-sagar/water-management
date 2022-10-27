package com.water.geektrust.commands;

import com.water.geektrust.exceptions.CommandNotFoundException;
import java.util.List;
import java.util.Map;
import java.util.HashMap;

public class CommandInvoker {
    private static final Map<String, ICommand> commandMap = new HashMap<String, ICommand>();

    //Register the command into map
    public void register(String commandName, ICommand command){
        commandMap.put(commandName, command);
    }

    //Get the registered command
    public ICommand get(String commandName){
        return commandMap.get(commandName);
    }

    //Execute the command
    public void executeCommand(String commandName, List<String> tokens) throws CommandNotFoundException{
        ICommand command = get(commandName);    
        if(command == null){
            throw new CommandNotFoundException();
        }
        command.execute(tokens);
    }
}
