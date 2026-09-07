package com.example.baitapss02.borrowing;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicLong;

@Repository
public class BorrowingRepository {

    private final AtomicLong sequence = new AtomicLong();

    private final List<Borrowing> borrowings =
            new CopyOnWriteArrayList<>();

    public long countActiveByMemberId(Long memberId) {
        return borrowings.stream()
                .filter(borrowing ->
                        borrowing.memberId().equals(memberId)
                                && !borrowing.returned())
                .count();
    }

    public Borrowing save(Borrowing borrowing) {
        Borrowing savedBorrowing = new Borrowing(
                sequence.incrementAndGet(),
                borrowing.memberId(),
                borrowing.bookId(),
                borrowing.borrowedAt(),
                borrowing.returned()
        );

        borrowings.add(savedBorrowing);
        return savedBorrowing;
    }
}
