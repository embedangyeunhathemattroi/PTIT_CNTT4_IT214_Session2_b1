package com.example.baitap2ss2.esb;


import org.springframework.stereotype.Service;

@Service
public class NotificationService {

    public void handle(String operation, String payload) {

        if ("notifyOverdue".equals(operation)) {
            System.out.println("=== NOTIFICATION SERVICE ===");
            System.out.println("Đã nhận yêu cầu nhắc trả sách quá hạn");
            System.out.println("Payload: " + payload);
            System.out.println("Đã gửi thông báo cho độc giả");
        } else {
            System.out.println(
                    "NotificationService không hỗ trợ operation: " + operation
            );
        }
    }
}