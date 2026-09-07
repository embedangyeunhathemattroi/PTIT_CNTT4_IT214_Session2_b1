package com.example.baitapss02.borrowing;
import jakarta.validation.constraints.NotNull;

public record CreateBorrowingRequest(
        @NotNull Long memberId,
        @NotNull Long bookId
) {
}