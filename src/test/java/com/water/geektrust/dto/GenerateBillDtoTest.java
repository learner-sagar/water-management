package com.water.geektrust.dto;



import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("GeneratedBillDtoTest")
public class GenerateBillDtoTest {
    @Test
    @DisplayName("should create a GeneratedBillDto Object")
    public void shouldCreateAGeneratedBillDtoObject() {
        GenerateBillDto generatedBillDto=new GenerateBillDto(900,1200);
        String expectedString="900 1200";
        String acutalString=generatedBillDto.toString();
        assertEquals(expectedString,acutalString);
    }
}