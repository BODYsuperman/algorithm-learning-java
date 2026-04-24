package com.alexjava.algorithms.greedy;

public class LemonadeChange {
    public boolean lemonadeChange(int[] bills) {

        int five = 0;
        int ten = 0;
        int twenty = 0;

        for (int bill : bills){
            if(bill == 5){
                five++;
            }
            else if(bill == 10){
                if(five == 0) return false;
                five--;
                ten++;
            }
            else {
                if(five > 0 && ten >0){
                    five--;
                    ten--;
                    twenty++;
                }
                else if(five >= 3){
                    five-=3;
                    twenty++;
                }
                else{
                    return false;
                }
            }
        }
        return true;
    }
}
