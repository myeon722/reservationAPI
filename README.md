# reservationAPI
프로젝트 개요 : 사내 회의실 예약을 위한 Restful API 서버 구현

[개발환경] <br>
언어: Java <br>
프레임워크: Spring Boot 3.x <br>
데이터베이스: MySQL(Docker 컨테이너) <br>
ORM: Spring Data JPA <br>
API 문서화: Swagger (OpenAPI 3.0) - springdoc-openapi <br>
컨테이너: Docker + Docker Compos <br>
빌드: Maven

[실행방법] <br>
-- 전체 환경 실행<br>
1. 빌드 & jar 생성
 : ./mvnw clean package -DskipTets (해당 프로젝트 경로 하위에서 실행)
2. 컨테이너 실행
 : docker-compose up --build

-- Swagger UI 접속<br>
: http://localhost:8080/swagger-ui/index.html

해당 과제 덕분에 그동안의 개발 환경과 다른 jpa나 swagger api등을 접하는 좋은 경험을 하게 되었습니다.<br>
본 코드가 정상적으로 동작하지 않아 죄송한 마음이 크지만 덕분에 새로운 부분을 공부하게되어 좋았습니다!<br>
감사합니다.
