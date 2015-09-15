package com.nuriskandarz.praktikum_2;

/**
 * Created by Nur Iskandar Z on 15/09/2015.
 * c=(f-32)*5/9
 */

public class UnitConverter {
    public  static double celcius2Fahrenheit(double f){
        return (f-32)*5/9;
    }

    public  static double fahrenheit2Celcius (double c){
        return 32+c*5/9;
    }

}
