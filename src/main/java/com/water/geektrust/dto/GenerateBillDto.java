package com.water.geektrust.dto;

public class GenerateBillDto {
    private int totalWaterConsumed;
    private int totalAmount;

    public GenerateBillDto(int totalWaterConsumed, int totalAmount){
        this.totalWaterConsumed = totalWaterConsumed;
        this.totalAmount = totalAmount;
    }

    @Override
    public String toString(){
        return totalWaterConsumed +" " + totalAmount;
    }
}
