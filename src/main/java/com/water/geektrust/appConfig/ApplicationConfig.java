package com.water.geektrust.appConfig;

import com.water.geektrust.commands.*;
import com.water.geektrust.services.ApartmentBillService;
import com.water.geektrust.services.IApartmentBillService;

public class ApplicationConfig {
    private final IApartmentBillService apartmentBillService=new ApartmentBillService();
    private final AllotWaterCommand allotWaterCommand=new AllotWaterCommand(apartmentBillService);
    private final AddGuestCommand addGuestCommand=new AddGuestCommand(apartmentBillService);
    private final BillCommand billCommand=new BillCommand(apartmentBillService);
    private final CommandInvoker commandInvoker = new CommandInvoker();

    public CommandInvoker getCommandInvoker(){
        commandInvoker.register("ALLOT_WATER",allotWaterCommand);
        commandInvoker.register("ADD_GUESTS",addGuestCommand);
        commandInvoker.register("BILL",billCommand);
        return commandInvoker;
    }
}
