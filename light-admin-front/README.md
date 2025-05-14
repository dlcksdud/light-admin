# 🛠️ Admin Dashboard with React

### 📌 프로젝트 개요
이 프로젝트는 **React**를 사용하여 개발된 가벼운 **어드민(관리자) 사이트**입니다.  
사용자는 대시보드에서 데이터를 조회하고 관리할 수 있으며, UI는 직관적이고 반응형으로 설계되었습니다.

---

## 🚀 주요 기능 (Features)
✅ **대시보드** - 데이터 요약 및 시각화 제공  
✅ **사용자 관리** - 사용자 CRUD(Create, Read, Update, Delete) 기능  
✅ **권한 관리** - 관리자 및 일반 사용자의 역할(Role-Based Access Control) 적용  
✅ **반응형 UI** - 다양한 기기(PC, 태블릿, 모바일)에서 최적화된 인터페이스  
✅ **API 연동** - 백엔드와의 REST API 연동  

---

## 🏗️ 기술 스택 (Tech Stack)
### **📌 프론트엔드**
- ⚛️ **React** (기본 UI 개발)
- ⚡ **React Router** (페이지 이동)
- 🎨 **Tailwind CSS / MUI** (스타일링)
- 🔄 **Axios / React Query** (API 요청)
- 📊 **Recharts / Chart.js** (데이터 시각화)

### **📌 백엔드**
- ⚡ **Spring boot**
- **Java**

---

## 📂 프로젝트 구조 (Project Structure)
```bash
📦 light-admin
 ┣ 📂 public          # 정적 파일 (HTML, Favicon 등)
 ┣ 📂 src
 ┃ ┣ 📂 components    # UI 컴포넌트 모음
 ┃ ┣ 📂 pages         # 개별 페이지 (Dashboard, Users 등)
 ┃ ┣ 📂 hooks         # 커스텀 훅 관리
 ┃ ┣ 📂 styles        # CSS 및 스타일 파일
 ┃ ┣ 📂 services      # API 호출 및 데이터 관리
 ┃ ┣ 📜 App.js        # 메인 App 컴포넌트
 ┃ ┣ 📜 index.js      # React 진입점
 ┗ 📜 package.json    # 프로젝트 의존성 및 설정
