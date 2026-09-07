package com.example.baitap2ss2.esb;
import org.springframework.stereotype.Component;

@Component
public class EsbSimulator {

    private final NotificationService notificationService;
    private final PaymentService paymentService;

    public EsbSimulator(
            NotificationService notificationService,
            PaymentService paymentService
    ) {
        this.notificationService = notificationService;
        this.paymentService = paymentService;
    }

    public void routeMessage(
            String toService,
            String operation,
            String payload
    ) {
        // Dùng .equals(), không dùng ==
        if ("NotificationService".equals(toService)) {

            System.out.println(
                    "ESB đang chuyển message đến NotificationService..."
            );

            notificationService.handle(operation, payload);

        } else if ("PaymentService".equals(toService)) {

            System.out.println(
                    "ESB đang chuyển message đến PaymentService..."
            );

            paymentService.handle(operation, payload);

        } else {
            // Không để message bị mất im lặng
            System.out.println(
                    "CẢNH BÁO: Không tìm thấy service có tên: "
                            + toService
            );
        }
    }
}