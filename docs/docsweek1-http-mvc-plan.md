# 1주차(HTTP, MVC, 요청-응답 흐름) 구현 시작 가이드

이 문서는 **"이 프로젝트에서 무엇부터 생성해야 하는가"**에 대한 실행 순서를 제공합니다.
목표는 브라우저 → 컨트롤러 → 서비스 → DAO → DB → 응답 흐름을 4개 기능(목록/상세/폼/등록처리)으로 직접 체득하는 것입니다.

---

## 0) 가장 먼저 할 일: 패키지/폴더 뼈대 생성

아래 구조를 먼저 만들면 이후 구현이 흔들리지 않습니다.

```text
src/main/java/com/practice/
  web/
    controller/
    dto/
  domain/
    post/
      Post.java
      PostRepository.java
      PostService.java
src/main/resources/
  templates/ (Thymeleaf를 쓸 경우)
  static/
```

> JSP를 꼭 써야 한다면 `src/main/webapp/WEB-INF/views/` 구조를 함께 만드세요.

---

## 1) 4개 결과물을 기준으로 URL 먼저 고정

가장 먼저 엔드포인트를 계약처럼 확정하세요.

- `GET /posts` : 목록 조회
- `GET /posts/{id}` : 상세 조회
- `GET /posts/new` : 등록 폼 이동
- `POST /posts` : 등록 처리

이 4개 URL을 문서에 먼저 적고 시작하면,
`GET/POST`, `폼 submit/fetch`, `MVC/REST` 비교가 자연스럽게 연결됩니다.

---

## 2) DTO와 도메인부터 생성 (컨트롤러 전에)

컨트롤러부터 만들면 파라미터 바인딩이 헷갈리기 쉽습니다.
먼저 아래를 만드세요.

- `Post` (id, title, content, createdAt)
- `PostCreateRequest` (title, content)
- `PostResponse` (id, title, content)

그 다음 바인딩 실습을 위해 요청 모델을 2개 준비하면 좋습니다.

- `PostForm` : `@ModelAttribute` 실습용 (form submit)
- `PostCreateRequest` : `@RequestBody` 실습용 (fetch JSON)

---

## 3) Repository(DAO)와 Service 생성

DB 연결 전에는 인메모리로 먼저 흐름을 완성하세요.

- `PostRepository`
  - `findAll()`
  - `findById(Long id)`
  - `save(Post post)`
- `PostService`
  - `getPosts()`
  - `getPost(Long id)`
  - `createPost(PostCreateRequest request)`

핵심은 Controller가 DB를 직접 만지지 않고 Service를 통해 흘러가게 만드는 것입니다.

---

## 4) Controller를 2개로 분리 생성 (MVC / REST 비교용)

비교 학습을 위해 처음부터 분리해 두세요.

1. `PostPageController` (JSP/템플릿 렌더링)
   - `GET /posts` -> 뷰 이름 반환
   - `GET /posts/{id}` -> 뷰 이름 반환
   - `GET /posts/new` -> 등록 폼 뷰
   - `POST /posts` -> 저장 후 redirect

2. `PostApiController` (JSON 응답)
   - `GET /api/posts`
   - `GET /api/posts/{id}`
   - `POST /api/posts`

이렇게 해야 **JSP 렌더링 응답**과 **REST JSON 응답** 차이가 명확해집니다.

---

## 5) 1주차 핵심 비교 포인트를 코드에 녹이는 순서

### A. GET / POST 차이
- 목록/상세/폼 이동은 GET
- 등록 처리는 POST

### B. form submit / fetch 차이
- form submit: `application/x-www-form-urlencoded`, 서버 리다이렉트 중심
- fetch: `application/json`, 클라이언트가 JSON 응답 직접 처리

### C. `@RequestParam`, `@ModelAttribute`, `@RequestBody` 차이
- `@RequestParam`: 단일 쿼리값(`?page=1`)
- `@ModelAttribute`: form 필드 묶음 바인딩
- `@RequestBody`: JSON 본문 바인딩

실습 권장:
- `GET /posts?keyword=spring` 에 `@RequestParam`
- `POST /posts`(폼) 에 `@ModelAttribute PostForm`
- `POST /api/posts`(JSON) 에 `@RequestBody PostCreateRequest`

---

## 6) 흐름도(4개) 작성 순서

코드 작성 후가 아니라, **엔드포인트 고정 직후** 먼저 초안을 그리세요.

1. 목록 조회 흐름도
2. 상세 조회 흐름도
3. 등록 폼 이동 흐름도
4. 등록 처리 흐름도

각 흐름도는 최소 아래 6단계를 반드시 포함:

1) Browser
2) Controller
3) Service
4) DAO(Repository)
5) DB(또는 In-Memory 저장소)
6) Response(HTML 또는 JSON)

---

## 7) 실제 착수 체크리스트 (오늘 바로 시작용)

1. 패키지/폴더 뼈대 생성
2. `Post`, `PostCreateRequest`, `PostResponse`, `PostForm` 생성
3. `PostRepository`, `PostService` 생성
4. `PostPageController`에 4개 결과물 URL 우선 구현
5. `PostApiController`에 JSON 버전 구현
6. 4개 흐름도 작성 및 README에 첨부

---

## 결론: "무엇부터 생성해야 하나?"

가장 먼저 생성할 것은 **URL 계약 + DTO/도메인 뼈대**입니다.
그 다음 **Repository/Service**, 마지막에 **Controller(페이지/REST 분리)** 순으로 가면
1주차 학습목표를 가장 빠르게 달성할 수 있습니다.
