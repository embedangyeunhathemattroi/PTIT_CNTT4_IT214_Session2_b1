package com.example.baitapss02.borrowing;

import com.example.baitapss02.Book.BookService;
import com.example.baitapss02.member.MemberService;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class BorrowingService {

    private static final int MAX_ACTIVE_BORROWINGS = 5;

    private final BorrowingRepository borrowingRepository;
    private final MemberService memberService;
    private final BookService bookService;

    public BorrowingService(
            BorrowingRepository borrowingRepository,
            MemberService memberService,
            BookService bookService
    ) {
        this.borrowingRepository = borrowingRepository;
        this.memberService = memberService;
        this.bookService = bookService;
    }

    public boolean canBorrowBook(long currentBorrowedByMember) {
        return currentBorrowedByMember < MAX_ACTIVE_BORROWINGS;
    }

    public Borrowing borrow(CreateBorrowingRequest request) {
        memberService.getById(request.memberId());
        bookService.getById(request.bookId());

        long currentBorrowedBooks =
                borrowingRepository.countActiveByMemberId(request.memberId());

        if (!canBorrowBook(currentBorrowedBooks)) {
            throw new IllegalStateException(
                    "Each member can borrow at most 5 books"
            );
        }

        Borrowing borrowing = new Borrowing(
                null,
                request.memberId(),
                request.bookId(),
                LocalDateTime.now(),
                false
        );

        return borrowingRepository.save(borrowing);
    }
}