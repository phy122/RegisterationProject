<p align="center">
  <img width="200px" src="https://github.com/user-attachments/assets/ab1381c6-a341-41e3-9a19-0193fb068f81" />
</p>
</p>
<h1 align="middle">한신알림</h1>
<h3 align="middle">안드로이드 기반의 수강신청 어플리케이션</h3>

<br/>

## 📝 프로젝트 소개
강의 정보를 보면서 본인의 시간표를 작성하는 수강신청 어플리케이션이다.

- 커뮤니티 기능을 통해 소통이 가능하다.
- GPS 기능을 통해 학교 건물 위치 및 정보를 알 수 있다.
- 사용자는 보다 효율적으로 시간표 관리를 할 수 있다.

<br/>

## 📝 프로젝트 배경

최근 스마트폰의 보급이 늘어남에 따라 일상 생활에 도움이 되는 어플리케이션들이 등장하면서 스마트폰으로 편리하게 사용할 수 있는 어플리케이션을 이용해 일정관리를 하는 사람들이 늘어나고 있다. 학생들이 개인의 시간표 관리를
효율적으로 할 수 있도록 기존에 있던 수강신청 어플리케이션보다 기능이 추가된 수강신청 어플리케이션을 구현하였다.

<br/>

## 📝 프로젝트 개발 환경
- **JAVA JDK (Java Development Kit)**
  - JDK JAVA 는 프로그램을 개발하고 실행하는데 필요한 프로그래밍 기능을 집약적으로 모아놓은 개발 툴이다.
- **Android studio**
  - Android studio는 안드로이드 및 안드로이드 전용 앱 제작을 위한 공식 통합 개발 환경(IDE)이다.
- **Android SDK (Software Development Kit)**
  -  Android SDK는 안드로이드를 구동시키는 각종 기능을 담고 있는 개발에 핵심적인 소프트웨어이다.
- **AVD (Android Virtual Device)**
  - 개발한 안드로이드 프로젝트를 실제 단말기에서처럼 구동해 볼 수 있는 소프트웨어이다.
- **Firebase**
  - 파이어베이스는 2011년 파이어베이스사가 개발하고 2014년 구글에 인수된 모바일 및 웹 애플리케이션 개발 플랫폼이다.
- **Figma**
  - Figma는 웹 기반으로 실시간 협업 기능을 가지고 있는 웨디자인 툴이다.   
<br/>

## 📝 프로젝트 흐름도 및 설계도

<div align="center">

| 시스템 흐름도 | 설계도 |
|:-------------:|:------:|
| ![시스템 흐름도](https://github.com/user-attachments/assets/f0f451cd-629b-49b9-880d-b924e171e7ec) | ![설계도](https://github.com/user-attachments/assets/f0f451cd-629b-49b9-880d-b924e171e7ec) |

</div>

<br/>

## ⭐ 주요 기능
- **로그인/회원가입** : 사용자는 개인정보를 입력하여 회원가입을 진행하고, 로그인을 한다.

<p align="center">
  <img src="https://github.com/user-attachments/assets/7d40fe2a-9494-49ab-864a-f4b0e28924ee" width="500">
</p>


- **메인화면** : 관심이 있는 공지사항을 클릭하면 연결된 URL을 통해 웹 사이트로 이동한다.

<p align="center">
  <img src="https://github.com/user-attachments/assets/f641cadb-d58f-441c-998a-74ab1d58c345" width="500">
</p>


- **강의 목록 화면** : 데이터를 선택하여 강의를 찾을 수 있다. 시간표 추가 버튼을 눌러 강의를 시간표에 추가할 수 있다.

<p align="center">
  <img src="https://github.com/user-attachments/assets/e5f02d9c-5bf3-4f4a-8637-969e96afa90c" width="500">
</p>


- **시간표 화면** : 강의 목록 화면에서 추가한 강의를 시간표로 볼 수 있다.

<p align="center">
  <img src="https://github.com/user-attachments/assets/32ae0a58-4f13-473c-81f4-83cd5e9c9b26" width="250">
</p>


- **강의 분석 화면** : 강의의 경쟁률과 정보를 볼 수 있는 화면이 나온다. 삭제 버튼을 누르면 삭제가 가능하다.

<p align="center">
  <img src="https://github.com/user-attachments/assets/b99dc55d-8293-4ea5-9a41-0c9b4d3ab400" width="250">
</p>


- **캘린더 화면** : 달력을 통해 일정을 등록할 수 있다. 일정을 수정하고 삭제할 수 있다.

<p align="center">
  <img src="https://github.com/user-attachments/assets/b55a1820-eb97-4239-b2bc-a9ebace216a9" width="500">
</p>


- **커뮤니티 화면** : 게시글 등록, 수정, 삭제가 가능하다.

<p align="center">
  <img src="https://github.com/user-attachments/assets/9e29f9fd-13d8-4627-940a-961e58cc9827" width="500">
</p>
<p align="center">
  <img src="https://github.com/user-attachments/assets/01a5b0c1-0340-4060-a631-66114e49be0c" width="250">
</p>


- **위치 정보 화면** : 사용자의 현재 위치가 나오고 건물 이름 버튼을 누르면 마커가 표시된다. 지도에 표시된 마커를 누르면 건물 정조가 담긴 다이얼로그 창이 나온다.

<p align="center">
  <img src="https://github.com/user-attachments/assets/102dd45b-c6dc-4f4b-8017-99fbab7d0b90" width="500">
</p>


<br/>

## 종합 평가
이 수강신청 어플리케이션은 학생들의 시간표 관리를 혁신적으로 개선하는 데 중요한 역할을 수행한다.<br/>

개인의 일정을 간편하게 관리할 수 있는 기능을 제공한다 사용자들은 강의 정보를 확인하고 자신의 시간표를 손쉽게 작성할 수 있어 학업 및 일상생활을 조율하는 데 큰 도움을 준다. <br/>

커뮤니티 기능을 통해 사용자들은 그룹 내에서 소통하고 정보를 공유할 수 있다 이를 통해 학생들은 서로의 경험과 지식을 나누며 학습 공동체를 형성할 수 있다.


<br/>
