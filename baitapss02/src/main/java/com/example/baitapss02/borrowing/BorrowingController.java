package com.example.baitapss02.borrowing;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/borrowings")
public class BorrowingController {

    private final BorrowingService borrowingService;

    public BorrowingController(BorrowingService borrowingService) {
        this.borrowingService = borrowingService;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Borrowing borrow(
            @Valid @RequestBody CreateBorrowingRequest request
    ) {
        return borrowingService.borrow(request);
    }
}