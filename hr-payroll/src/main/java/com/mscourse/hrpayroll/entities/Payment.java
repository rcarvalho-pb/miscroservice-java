package com.mscourse.hrpayroll.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Payment {

    private String name;
    private Double dailyIncome;
    private Integer days;


    public Double getTotal(){
        return days*dailyIncome;
    }

}
