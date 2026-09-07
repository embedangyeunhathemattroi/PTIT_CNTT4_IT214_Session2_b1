package com.example.baitap2ss2.testapi;

import com.example.baitap2ss2.esb.EsbSimulator;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/borrowings")
public class OverdueNotificationController {

    private final EsbSimulator esbSimulator;

    public OverdueNotificationController(EsbSimulator esbSimulator) {
        this.esbSimulator = esbSimulator;
    }

    @PostMapping("/overdue-notification")
    public String notifyOverdue(
            @RequestParam Long memberId,
            @RequestParam Long bookId,
            @RequestParam String dueDate
    ) {
        String payload = """
                {
                  "memberId": %d,
                  "bookId": %d,
                  "dueDate": "%s"
                }
                """.formatted(memberId, bookId, dueDate);

        esbSimulator.routeMessage(
                "NotificationService",
                "notifyOverdue",
                payload
        );

        return "Đã gửi message quá hạn đến ESB Simulator";
    }
}