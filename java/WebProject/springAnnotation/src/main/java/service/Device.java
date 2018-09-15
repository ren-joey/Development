package service;

import org.springframework.beans.factory.annotation.Autowired;

public class Device {

    @Autowired
    private Card card;

    public void callCardInfomation(){
        System.out.println("it works!");
        card.showInfomation();
    }

}
