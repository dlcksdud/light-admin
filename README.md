# 가벼운 관리자 (Light Admin)

**가벼운 관리자**는 빠르고 효율적인 관리 기능을 제공하기 위해 설계된 경량화 관리자 페이지입니다.  
React 기반의 프론트엔드와 Spring Boot 기반의 백엔드로 구성되어, 간편한 유지보수와 높은 생산성을 목표로 합니다.

---

## 📚 프로젝트 구조
```
light-admin-home/
├── light-admin-front/ # 프론트엔드 (React)
└── light-admin-back/ # 백엔드 (Spring Boot)
```


---

## 🚀 기술 스택

- **Frontend**
  - React
  - JavaScript (ES6+)
  - MUI (Material UI)
  - Axios (API 통신)
  
- **Backend**
  - Spring Boot
  - Java 11
  - RESTful API
  - MariaDB
  - Gradle

---

## 📌 주요 기능

- 사용자 관리 (CRUD)
- 권한 및 역할 관리
- 로그인 및 인증 처리 (JWT 등)
- 공통 코드 관리
- 감사 로그 기록 (Audit Log)
- 반응형 UI 제공 (MUI 기반)

---

## 📂 프로젝트 실행 방법

### Backend

```bash
cd light-admin-back
./gradlew build
java -jar build/libs/*.jar
```

### Frontend
```bash
cd light-admin-front
npm install
npm start
```

---

## 🛠️ 환경 변수 설정
- Backend: application.yml 또는 .env 파일에서 DB, 보안 관련 설정
- Frontend: .env 파일에서 API 서버 주소 설정


