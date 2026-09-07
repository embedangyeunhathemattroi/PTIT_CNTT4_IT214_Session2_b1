package com.example.baitap2ss2.esb;
import org.springframework.stereotype.Service;

@Service
public class PaymentService {

    public void handle(String operation, String payload) {
        System.out.println("PaymentService received: " + operation);
    }
}