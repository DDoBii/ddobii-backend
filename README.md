# DDOBII

MBTI(Myers-Briggs Type Indicator) 기반의 커뮤니티 프로젝트는 사용자들이 자신의 성격 유형을 공유하고, 비슷한 성격 유형을 가진 사람들과 소통하며 다양한 주제에 대해 토론하는 플랫폼입니다. MBTI는 성격 유형을 나타내는 16가지 유형을 정의하고, 이를 기반으로 사용자들은 서로의 성격을 이해하고 유사한 성격을 가진 사람들과 교류할 수 있습니다.

## 목차

- [공통 작업](#공통-작업)
  - [환경 설정](#환경-설정)
  - [데이터베이스 통합](#데이터베이스-통합)
- [사용자 모듈](#사용자-모듈)
  - [엔터티](#엔터티)
  - [기능](#기능)
  - [에러 처리](#에러-처리)
  - [보안](#보안)
- [커뮤니티 모듈](#커뮤니티-모듈)
- [메모](#메모)

## 공통 작업

- [ ] 환경 문제 해결
- [x] 데이터베이스 통합

## 사용자 모듈

### 엔터티

- [x] 사용자 등록 및 로그인을 위한 엔터티 구현

### 기능

- [x] 사용자 등록 및 로그인 기능 구현
- [x] 로그인 프로세스에 JWT 토큰 추가
- [x] 비밀번호 암호화 및 유효성 검사 구현

### 에러 처리

- [x] 로그인 및 등록을 위한 에러 코드 정의
- [x] 더 나은 사용자 경험을 위한 사용자 정의 에러 메시지

### 보안

- [x] 사용자 비밀번호 안전하게 암호화
- [x] 사용자 입력에 대한 유효성 검사 구현

## 커뮤니티 모듈

- [ ] 커뮤니티 모듈을 위한 기능 구현

## 메모

- 협업 - swagger 적용. link: http://localhost:8080/swagger-ui/index.html
- 엔터티 폴더 분리
- 토큰 유효성 검사
- 로그인한 회원 이름 가져오기

