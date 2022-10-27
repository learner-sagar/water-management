package com.water.geektrust.services;

import com.water.geektrust.dto.GenerateBillDto;
import com.water.geektrust.entities.Apartment;


public class ApartmentBillService implements IApartmentBillService{
    private Apartment apartment;

    public ApartmentBillService(){
    }

    @Override
    public void allotWater(int type, String corporationToBorewellRatio){
        this.apartment = new Apartment(type, corporationToBorewellRatio);
    }

    @Override
    public void addGuest(int guestCount){
        apartment.addGuest(guestCount);
    }

    @Override
    public GenerateBillDto calculateBill(){
        double totalAmount = calculateBillForCorporation() + calculateBillForBorewell() + calculateBillForTanker();
        return new GenerateBillDto(apartment.getTotalWaterConsumed(),(int) Math.ceil(totalAmount));
    }

    public double calculateBillForCorporation(){
        return apartment.getCorporationWaterAllocation() * 1;
    }

    public double calculateBillForBorewell(){
        return apartment.getBorewellWaterAllocation() * 1.5;
    }

    public double calculateBillForTanker(){
        int totalWaterForGuests = apartment.getTotalWaterConsumed() - apartment.getMonthlyWaterForTanets();
        double billForTankerWater=0.0;

        if(totalWaterForGuests <= 500){
            billForTankerWater+=totalWaterForGuests * 2;
        }else if(totalWaterForGuests > 500
                && totalWaterForGuests <= 1500){
            billForTankerWater+=((500 * 2) + (totalWaterForGuests-500) * 3);
        }else if(totalWaterForGuests > 1500 && totalWaterForGuests<=3000){
            billForTankerWater+=((500 * 2) + 1000 + (totalWaterForGuests-1500) * 5);
        }else{
            billForTankerWater+=((500*2) + (1000) + (1500 * 5) + (totalWaterForGuests - 3000) * 8);
        }
        
        return billForTankerWater;

    }

}
