package com.water.geektrust.commands;

import com.water.geektrust.exceptions.CommandNotFoundException;
import com.water.geektrust.services.IApartmentBillService;

import java.util.List;

public class AllotWaterCommand implements ICommand{
    private final IApartmentBillService apartmentBillService;

    public AllotWaterCommand(IApartmentBillService apartmentBillService) {
        this.apartmentBillService = apartmentBillService;
    }

    @Override
    public void execute(List<String> tokens) {
        try {
            apartmentBillService.allotWater(Integer.valueOf(tokens.get(1)),tokens.get(2));
        } catch (CommandNotFoundException e) {
            System.out.println("Invalid Command");
        } catch (Exception e){
            System.out.println(e.getMessage());
        } 
    }
}