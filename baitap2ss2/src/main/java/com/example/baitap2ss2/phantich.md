1. Phân tích lỗi của ESB Simulator

Code cũ sử dụng toán tử == để so sánh chuỗi:

if (toService == "NotificationService")

Trong Java, == so sánh địa chỉ tham chiếu của hai object, không so sánh nội dung text. Vì vậy, hai chuỗi có cùng nội dung vẫn có thể cho kết quả false nếu chúng được tạo ở hai vùng nhớ khác nhau.

Ví dụ:

String serviceName = new String("NotificationService");

System.out.println(serviceName == "NotificationService");
// Có thể là false

System.out.println(serviceName.equals("NotificationService"));
// true

Do đó, ESB có thể không định tuyến được thông điệp đến NotificationService dù toService có giá trị đúng. Cách sửa là dùng .equals() hoặc Objects.equals().