package com.water.geektrust.commands;

import com.water.geektrust.exceptions.CommandNotFoundException;
import com.water.geektrust.services.IApartmentBillService;

import java.util.List;

public class AddGuestCommand implements ICommand{
    private final IApartmentBillService apartmentBillService;

    public AddGuestCommand(IApartmentBillService apartmentBillService){
        this.apartmentBillService = apartmentBillService;
    }

    @Override
    public void execute(List<String> tokens){
        try{
            apartmentBillService.addGuest(Integer.valueOf(tokens.get(1)));
        }catch (CommandNotFoundException e) {
            System.out.println("Invalid Command");
        } catch (Exception e){
            System.out.println(e.getMessage());
        }
    }
}
