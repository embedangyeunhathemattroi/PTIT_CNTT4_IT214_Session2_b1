1. Phân tích lỗi code cũ
   Lỗi điều kiện giới hạn mượn sách

Code cũ:

if (currentBorrowedByMember > 5) {
return false;
}
return true;

Sai vì khi độc giả đang mượn đúng 5 cuốn:

5 > 5 // false

Hàm vẫn trả về true, nên độc giả được mượn cuốn thứ 6, trái với quy định tối đa 5 cuốn.

Sửa đúng:

public boolean canBorrowBook(long currentBorrowedByMember) {
return currentBorrowedByMember < 5;
}
Đang mượn 0–4 cuốn: được mượn thêm.
Đang mượn 5 cuốn: không được mượn thêm.
Vấn đề của static totalBorrowedBooks
private static int totalBorrowedBooks = 0;

Biến này dùng chung cho toàn bộ độc giả. Nó chỉ đếm tổng số lượt mượn của cả thư viện, không cho biết mỗi người đang mượn bao nhiêu cuốn.

Ví dụ:

Member 1 mượn 5 cuốn.
Member 2 mượn 1 cuốn.
totalBorrowedBooks = 6.

Biến này không thể dùng để kiểm tra giới hạn của từng member. Đây là lỗi shared mutable state: nhiều request cùng thay đổi một biến chung, dễ sai dữ liệu khi ứng dụng có nhiều người dùng.

Cách xử lý: xóa biến static, lưu từng lượt mượn trong BorrowingRepository, sau đó đếm số lượt mượn chưa trả theo memberId.