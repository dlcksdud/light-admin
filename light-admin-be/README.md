# 🌟 관리자 사이트 백엔드 프로젝트

![Java](https://img.shields.io/badge/Java-11-blue) ![Spring Boot](https://img.shields.io/badge/Spring%20Boot-2.7.5-brightgreen) ![MariaDB](https://img.shields.io/badge/Database-MariaDB-orange) ![MyBatis](https://img.shields.io/badge/ORM-MyBatis-yellow)

Spring Boot 2.7.5 기반의 **관리자 사이트 백엔드 프로젝트**입니다. 
이 프로젝트는 **MariaDB**, **MyBatis**, **Gradle**, **GitHub**를 사용하여 개발되었으며, API 문서는 `springdoc-openapi-ui 1.6.14`를 활용하여 자동 생성 및 공유됩니다.

---

## 📌 프로젝트 개요
- **Framework:** Spring Boot 2.7.5
- **Java Version:** Java 11
- **Database:** MariaDB
- **ORM:** MyBatis
- **Build Tool:** Gradle
- **Version Control:** GitHub
- **API 문서화:** `springdoc-openapi-ui 1.6.14`

---

## 🚀 프로젝트 실행 방법

### 1️⃣ **IntelliJ에서 GitHub 프로젝트 Clone 받기**
1. IntelliJ IDEA 실행
2. `File` → `New` → `Project from Version Control` 선택
3. **GitHub Repository URL 입력** (`https://gitlab.dreamsecurity.com/light-admin/light-admin-be.git`)
4. 로컬 저장소 경로 선택 후 `Clone` 클릭
5. 프로젝트가 IntelliJ에 불러와짐

### 2️⃣ **Gradle 빌드 및 실행**
1. IntelliJ에서 `Gradle` 탭 열기
2. `Tasks` → `build` → `build` 더블클릭하여 프로젝트 빌드
3. `Tasks` → `application` → `bootRun` 더블클릭하여 실행
4. 또는, `Application.java` 파일에서 `Run` 버튼 클릭하여 실행

### 1️⃣ **GitHub에서 프로젝트 Clone 받기**
```bash
git clone https://gitlab.dreamsecurity.com/light-admin/light-admin-be.git
cd light-admin-back
```

### 2️⃣ **환경 설정**
#### **2.1 Java 11 설치 확인**
```bash
java -version
```
출력 예시:
```
openjdk version "11.0.22" 2024-02-21
OpenJDK Runtime Environment (build 11.0.22+7)
```

#### **2.2 Gradle 설치 확인**
```bash
gradle -v
```
출력 예시:
```
Gradle 7.x.x
```

#### **2.3 MariaDB 설정 (`application.yml`)**
프로젝트의 `src/main/resources/application.yml` 파일에서 데이터베이스 연결 정보를 설정하세요.
```yaml
spring:
  datasource:
    url: jdbc:mariadb://10.20.110.138:13306/light_admin
    username: light_admin
    password: emfla1004!@
    driver-class-name: org.mariadb.jdbc.Driver
mybatis:
  configuration:
    map-underscore-to-camel-case: true  # snake_case → camelCase 자동 변환
    cache-enabled: false  # 캐시 설정
  mapper-locations: classpath:mappers/**/*.xml  # XML Mapper 파일 위치
  type-aliases-package: com.dreamsecurity.light_admin_be.domain  # 엔티티 패키지 설정
``` 

### 3️⃣ **프로젝트 빌드 및 실행**
#### **Gradle 빌드**
```bash
./gradlew build
```

#### **애플리케이션 실행**
```bash
./gradlew bootRun
```
또는
```bash
java -jar build/libs/light-admin-back.jar
```

---

## 📡 API 문서 (Swagger UI)
이 프로젝트의 API 문서는 `springdoc-openapi-ui 1.6.14`를 사용하여 자동 생성됩니다.

- **Swagger UI 접속:** [http://localhost:8080/swagger-ui.html](http://localhost:8080/swagger-ui.html)
- **API 문서 JSON:** [http://localhost:8080/v3/api-docs](http://localhost:8080/v3/api-docs)

---

## 📂 프로젝트 구조
```
light-admin-back/
 ├── src/
 │   ├── main/
 │   │   ├── java/com/dreamsecurity/lightadminback/
 │   │   │   ├── common        # 공통
 │   │   │   │   ├── aspect/      # aop
 │   │   │   │   ├── config/      # 설정 파일
 │   │   │   │   ├── enums/       # 공통 코드
 │   │   │   │   ├── exception/   # 예외처리
 │   │   │   │   ├── jwt/         # jwt
 │   │   │   ├── controller/   # API 컨트롤러
 │   │   │   ├── dto/        # 엔티티 및 DTO
 │   │   │   ├── repository/   # 데이터 접근 (MyBatis Mapper 사용)
 │   │   │   ├── service/      # 서비스 레이어
 │   │   │   ├── LightAdminBackApplication.java # 메인 애플리케이션
 │   │   ├── resources/
 │   │   │   ├── application.yml  # 환경설정 파일
 │   │   │   ├── mappers/         # MyBatis 매퍼 XML
 │   ├── test/   # 테스트 코드
 ├── build.gradle  # Gradle 빌드 설정
 ├── README.md  # 프로젝트 설명 파일
 ├── .gitignore  # Git에 올리지 않을 파일 목록
```

---

## 🤝 기여 방법 (Contributing)
1. 이 프로젝트를 **Fork** 합니다.
2. 새로운 브랜치를 생성합니다. (`git checkout -b feature/new-feature`)
3. 변경사항을 커밋합니다. (`git commit -m 'Add new feature'`)
4. 브랜치를 푸시합니다. (`git push origin feature/new-feature`)
5. Pull Request를 생성합니다.

---

## 📜 라이선스
이 프로젝트는 `MIT License`를 따릅니다. 자세한 내용은 `LICENSE` 파일을 참고하세요.

---

