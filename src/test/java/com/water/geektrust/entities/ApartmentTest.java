package com.water.geektrust.entities;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("ApartmentTest")
public class ApartmentTest {

    @Test
    @DisplayName("checkIfApartment is assigning correct water allocation for Two Bhk")
    public void testCheckingAllotWaterToCorporateAndBoreWellForTwoBhk(){
        int apartmentType=2;
        String corporationIsToBoreWellRatio="3:7";
        Apartment apartment=new Apartment(apartmentType,corporationIsToBoreWellRatio);
        assertEquals(900,apartment.getMonthlyWaterForTanets());
        assertEquals(270,apartment.getCorporationWaterAllocation());
        assertEquals(630,apartment.getBorewellWaterAllocation());
    }
    @Test
    @DisplayName("should create a default Apartment")
    public void shouldCreateADefaultApartment() {
        Apartment apartment = new Apartment();
        assertNotNull(apartment);
    }

    @Test
    @DisplayName("checkIfApartment is assigning correct water allocation for Three Bhk")
    public void testCheckingAllotWaterToCorporateAndBoreWellForThreeBhk(){
        int apartmentType=3;
        String corporationIsToBoreWellRatio="3:7";
        Apartment apartment=new Apartment(apartmentType,corporationIsToBoreWellRatio);
        assertEquals(1500,apartment.getMonthlyWaterForTanets());
        assertEquals(450,apartment.getCorporationWaterAllocation());
        assertEquals(1050,apartment.getBorewellWaterAllocation());
    }

    @Test
    @DisplayName("addGuestToApartment is assigning correct no of guest and total water consumed")
    public void testCheckingAddGuestToApartment(){
        int apartmentType=2;
        String corporationIsToBoreWellRatio="3:7";
        Apartment apartment=new Apartment(apartmentType,corporationIsToBoreWellRatio);
        apartment.addGuest(2);
        assertEquals(2,apartment.getAdditionalGuests());
        assertEquals(1500,apartment.getTotalWaterConsumed());
    }


}