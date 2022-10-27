package com.water.geektrust.service;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.water.geektrust.dto.GenerateBillDto;
import com.water.geektrust.entities.Apartment;
import com.water.geektrust.services.ApartmentBillService;

import static org.mockito.Mockito.*;

@DisplayName("ApartmentBillServiceTest")
@ExtendWith(MockitoExtension.class)
public class ApartmentBillServiceTest {

    @Mock
    private ApartmentBillService apartmentBillServiceMock;

    @Test
    @DisplayName("should Generate Bill For Apartment")
    public void shouldGenerateBillForApartments(){
        //Arrange
        String corporationIsToBoreWellRatio="1:2";
        Apartment expectedApartment = new Apartment(2, corporationIsToBoreWellRatio);
        GenerateBillDto generatedBillDtoExpected=new GenerateBillDto(900,1200);
        when(apartmentBillServiceMock.calculateBill()).thenReturn(generatedBillDtoExpected);

        //Act
        GenerateBillDto generatedBillDtoActual = apartmentBillServiceMock.calculateBill();

        //Assert
        Assertions.assertEquals(generatedBillDtoExpected,generatedBillDtoActual);
        verify(apartmentBillServiceMock,times(1)).calculateBill();
    }



}