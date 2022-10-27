package com.water.geektrust.entities;


public class Apartment {
    private int type;
    private int additionalGuests;
    private int tenants;
    private double corporationWaterAllocation;
    private double borewellWaterAllocation;
    private int totalWaterConsumed;
    private int monthlyWaterForTanets;

    public Apartment(){
        
    }
    public Apartment(int type, String corporationToBorewellRatio){
        this.type = type;
        this.tenants = 0;
        this.additionalGuests = 0;
        this.totalWaterConsumed = 0;
        this.corporationWaterAllocation = 0.0;
        this.borewellWaterAllocation = 0.0;
        this.monthlyWaterForTanets = 0;
        setTotalTanents();
        setWaterAllocationAndConsumed();
        setCorporationAndBorewellWater(corporationToBorewellRatio);
    }

    private void setCorporationAndBorewellWater(String corporationToBorewellRatio){
        String[] ratio = corporationToBorewellRatio.split(":");
        int corporationMultiplier = Integer.parseInt(ratio[0]);
        int borewellMultiplier = Integer.parseInt(ratio[1]);
        int sum = corporationMultiplier + borewellMultiplier;
        this.corporationWaterAllocation = (double)(totalWaterConsumed * corporationMultiplier) / sum;
        this.borewellWaterAllocation = (double)(totalWaterConsumed * borewellMultiplier)/sum;
    }
    
    private void setWaterAllocationAndConsumed(){
        monthlyWaterForTanets = tenants * 10 * 30;
        totalWaterConsumed = monthlyWaterForTanets;
    }

    public void setTotalTanents(){
        if(type == 2){
            tenants = 3;
        }else if(type == 3){
            tenants = 5;
        }
    }

    public void addGuest(int guestCount){
        additionalGuests += guestCount;
        totalWaterConsumed += guestCount * 30 * 10;
    }

    public int getAdditionalGuests(){
        return additionalGuests;
    }
    
    public int getTotalWaterConsumed(){
        return totalWaterConsumed;
    }

    public double getCorporationWaterAllocation(){
        return corporationWaterAllocation;

    }

    public double getBorewellWaterAllocation(){
        return borewellWaterAllocation;
    }

    public int getMonthlyWaterForTanets(){
        return monthlyWaterForTanets;
    }
    
}
