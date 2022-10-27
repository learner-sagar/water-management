package com.water.geektrust.services;

import com.water.geektrust.dto.GenerateBillDto;

public interface IApartmentBillService{
    public void allotWater(int type, String corporationToBorewellRatio);
    public void addGuest(int guestCount);

    public GenerateBillDto calculateBill();

}