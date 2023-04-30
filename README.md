

# 🎤 싱싱타임

<br />


## 📖 프로젝트 소개
 

[개요] 비대면 노래 대결 플랫폼

[기간] 2023.01.02~2023.02.17 (7주)  

[소속] SSAFY 8기 2학기 공통 프로젝트 (Web RTC) 

<br />



## 🏷 기획의도
노래방이라는 장소적 제한을 없애기 위해 비대면 노래 대결 플랫폼 '싱싱타임'을 기획하게 되었습니다.
해당 서비스를 이용하여 언제, 어디서든 노래를 부르고 즐길 수 있습니다.
<br />



## 🛠️ 기술 스택 및 환경

BackEnd
- IntelliJ
- Spring Boot
- Spring Data JPA
- Mysql

FrontEnd
- Vue.js
- Vuex
- Vuetify


CI/CD
- AWS EC2
- Docker 
- Jenkins
- nginx

Web RTC
- Open Vidu


<br />



## 💻 사용기술
<image src="./image1.png"/>


<br />




## 📋 API 명세서
<image src="./image2.png"/>


<br />




## ✔️ ERD
<image src="./image3.png"/>


<br />

## ✔️ 와이어프레임
<image src="./image4.png"/>


<br />




## 🎶 주요 기능 소개

#### 1️⃣ 노래 대결 및 투표 기능   
- 챔피언과 이에 대결을 신청하는 도전자는 챔피언의 플레이리스트 중 노래를 선곡하여 대결을 신청할 수 있으며 관람객들은 대결에 대한 투표를 진행할 수 있습니다.
<image src="./image5.png"/>

#### 2️⃣ 가면 및 에코 기능  
- 얼굴 공개를 원하지 않는 사용자들은 가면 기능을 기용하여 일부를 가릴 수 있으며 노래 대결을 하는 사용자들은 에코 기능을 사용해 보다 퀄리티 높은 대결을 즐길 수 있습니다.  
<image src="./image6.png"/>

#### 3️⃣ 실시간 채팅 기능   
- 대결을 관람하는 관람객들은 대결화면 아래에서 실시간으로 소통을 할 수 있습니다.  
<image src="./image7.png"/>

#### 4️⃣ 영상 녹화 및 공유 기능   
- 대결화면에서 바로 영상을 녹화 및 저장할 수 있으며 이를 커뮤니티 페이지에 공유하여 사용자들과 소통할 수 있습니다.
<image src="./image8.png"/>

#### 4️⃣ 나의 영상 및 플레이리스트 선곡
- 대결 시 사용하게 될 사용자의 플레이리스트를 선곡할 수 있으며 사용자가 커뮤니티에 올린 영상들을 조회할 수 있습니다.
<image src="./image9.png"/>


<br />




## 🤜 팀원

👩‍💻 송해찬 - 팀장, BE   

👨‍💻 김경삼 - BE, Open Vidu 

👨‍💻 김선규 - BE, 배포   

👨‍💻 박현영 - FE 

👩‍💻 정채은 - FE, Open Vidu   

👨‍💻 최형운 - FE   
 





</br>
</br>

## 📢 Git 사용 규칙
</br>

### 🚩 Branch 생성, 병합
</br>

💡 총 5개의 브랜치 사용
- feature - develop에서 feature 분기, 기능 추가 후 develop에 병합
- develop - feature, release를 병합하기 위해 사용
- release - develop에서 release 분기, 배포 준비 완료되면 master에 병합
- master - release 브랜치만 병합
- hotfix - master 브랜치에서 hotfix 브랜치 분기, 수정 후 다시 master에 병합
</br>

💡 feature 브랜치 생성 및 종료 과정

```bash
// feature 브랜치(feature/login)를 'develop' 브랜치에서 분기
git checkout -b feature/login develop

/* ~ feature 브랜치에서 새로운 기능에 대한 코드 작성 ~ */
git add [작성 파일]
git commit -m "type: Subject"
git push origin feature/login

// 'develop' 브랜치로 이동한다.
git checkout develop

// 'develop' 브랜치에 feature/login 브랜치 내용을 병합(merge)한다.
git merge --no-ff feature/login

// Merging 메시지 입력
i 누르기 (INSERT 모드)
# 무시하고 아래로 이동해서 type: Subject 커밋 메시지 입력
입력 후 esc
:wq + enter

// (삭제 안해도됌) -d 옵션: feature/login에 해당하는 브랜치를 삭제한다.
git branch -d feature/login

// 'develop' 브랜치를 원격 중앙 저장소에 올린다.
git push origin develop
```

</br></br>

### 🚩 Commit Convention
💡 Udacity Style (커밋 양식) 사용
```
커밋 메시지 양식

type: Subject

ex) 
docs: Update README.md
feat: Add 로그인 유효성 검사 기능
feat: Add Openvidu 컨트롤러 기능
fix: Modify 비밀번호 유효성 체크 기능
```
</br>

💡 type 규칙
- feat: 새로운 기능 추가
- fix: 버그 수정
- docs: 문서 수정
- style: 코드 포맷 변경, 세미콜론 누락, 코드 변경 없음
- refactor: 프로덕션 코드 리팩터링
- test: 테스트 추가, 테스트 코드 리팩터링, 프로덕션 코드 변경 없음
- chore: 빌드 테스크 업데이트, 패키지 매니저 환경설정, 프로덕션 코드 변경 없음
</br>

💡 Subject 규칙
- 동사(ex. Add, Update, Modify)로 시작
- 첫 글자 대문자
- 끝에 마침표 x


</br></br>

### 🚩 Jira Convention

💡 Epic - 큰 파트 생성
  - [단계] ~~~
  ex)
  [기획] 자료 탐색
  [기본기능] 로그인
  [필수기능] 플레이룸 사용
  [심화기능] 영상 커스터마이징
</br>

💡 Story - 사용자 행위 생성 (사용x)
  - 사용자는 ~~~할 수 있다
  ex)
  사용자는 회원가입할 수 있다
  사용자는 플레이룸을 생성할 수 있다.
</br>

💡 Task - 개발자 상세 업무 생성
  - Story point는 4시간 이하 할당
  - [포지션] ~~~ 정의/구현/설계/학습
  ex)
  [BE] 유저 엔티티 설계 
  [FE] 회원가입 기능 구현



