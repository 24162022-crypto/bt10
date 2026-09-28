# Spring Boot 3 - JWT Authentication using Nimbus JOSE + JWT

## Mô tả
Dự án xác thực người dùng (Authentication & Authorization) tích hợp Spring Security 6 và sử dụng thư viện Nimbus JOSE + JWT (`com.nimbusds:nimbus-jose-jwt`) để tạo và xác thực token thay thế cho thư viện JJWT.

## Công nghệ sử dụng
- Java 17
- Spring Boot 3
- Spring Security 6
- Nimbus JOSE + JWT
- Spring Data JPA
- MySQL
- Lombok

## Cấu trúc dự án
- `src/main/java` : mã nguồn chính của ứng dụng.
- `src/main/resources` : file cấu hình ứng dụng.
- `src/test/java` : mã nguồn kiểm thử.

## API Endpoints

### Authentication
- `POST /auth/signup` : Đăng ký người dùng mới.
- `POST /auth/login` : Đăng nhập và nhận chuỗi JWT Token.

### User
- `GET /users/me` : Lấy thông tin tài khoản hiện tại (Yêu cầu Header `Authorization: Bearer <token>`).
- `GET /users/` : Lấy danh sách người dùng.

## Yêu cầu hệ thống
- JDK 17+
- Maven 3.8+
- MySQL 8+

## Cài đặt và chạy
```bash
mvn clean install
mvn spring-boot:run
```

## Cấu hình môi trường
Cập nhật các thông tin kết nối MySQL và khóa bí mật JWT trong file:

```properties
src/main/resources/application.properties
```

## Ghi chú
Dự án này sử dụng JWT theo hướng stateless, phù hợp cho các hệ thống API hiện đại với xác thực và phân quyền theo vai trò.
