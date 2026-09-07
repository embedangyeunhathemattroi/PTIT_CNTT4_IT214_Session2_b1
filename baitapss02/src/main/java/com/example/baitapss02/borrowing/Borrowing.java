package com.example.baitapss02.borrowing;

import java.time.LocalDateTime;

public record Borrowing(
        Long id,
        Long memberId,
        Long bookId,
        LocalDateTime borrowedAt,
        boolean returned
) {
}