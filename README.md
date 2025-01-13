<p align="middle" >
  <img width="200px;" src="https://firebasestorage.googleapis.com/v0/b/fir-readme-storage.appspot.com/o/logo.jpg?alt=media&token=46aada62-533c-4ee0-8b0a-c454d033733f"/>
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

![메인페이지](https://firebasestorage.googleapis.com/v0/b/fir-readme-storage.appspot.com/o/%E1%84%89%E1%85%B3%E1%84%8F%E1%85%B3%E1%84%85%E1%85%B5%E1%86%AB%E1%84%89%E1%85%A3%E1%86%BA%202022-06-02%20%E1%84%8B%E1%85%A9%E1%84%92%E1%85%AE%2010.32.09.png?alt=media&token=b2d5b84a-eaf0-4f57-9e82-0dda2ee080cb)

- **메인화면** : 관심이 있는 공지사항을 클릭하면 연결된 URL을 통해 웹 사이트로 이동한다.

![선택페이지](https://firebasestorage.googleapis.com/v0/b/fir-readme-storage.appspot.com/o/Image%2Fselect.png?alt=media&token=05794943-9657-40bf-ad36-d3bdbb895d84)

- **강의 목록 화면** : 데이터를 선택하여 강의를 찾을 수 있다. 시간표 추가 버튼을 눌러 강의를 시간표에 추가할 수 있다.

![미리보기](https://firebasestorage.googleapis.com/v0/b/fir-readme-storage.appspot.com/o/%E1%84%89%E1%85%B3%E1%84%8F%E1%85%B3%E1%84%85%E1%85%B5%E1%86%AB%E1%84%89%E1%85%A3%E1%86%BA%202022-06-02%20%E1%84%8B%E1%85%A9%E1%84%92%E1%85%AE%2010.52.47.png?alt=media&token=7502d5f5-a3c3-4193-a873-620747b7b070)

- **시간표 화면** : 강의 목록 화면에서 추가한 강의를 시간표로 볼 수 있다.

![제작페이지](https://firebasestorage.googleapis.com/v0/b/fir-readme-storage.appspot.com/o/%E1%84%89%E1%85%B3%E1%84%8F%E1%85%B3%E1%84%85%E1%85%B5%E1%86%AB%E1%84%89%E1%85%A3%E1%86%BA%202022-06-02%20%E1%84%8B%E1%85%A9%E1%84%92%E1%85%AE%2010.53.28.png?alt=media&token=83162f3e-0802-4c65-863e-e907ca6979b3)

- **강의 분석 화면** : 강의의 경쟁률과 정보를 볼 수 있는 화면이 나온다. 삭제 버튼을 누르면 삭제가 가능하다.

![저장페이지](https://firebasestorage.googleapis.com/v0/b/fir-readme-storage.appspot.com/o/%E1%84%89%E1%85%B3%E1%84%8F%E1%85%B3%E1%84%85%E1%85%B5%E1%86%AB%E1%84%89%E1%85%A3%E1%86%BA%202022-06-02%20%E1%84%8B%E1%85%A9%E1%84%92%E1%85%AE%2010.54.47.png?alt=media&token=015f9d34-ed1f-4017-8de3-832fb026e0a2)

- **캘린더 화면** : 달력을 통해 일정을 등록할 수 있다. 일정을 수정하고 삭제할 수 있다.

![검색페이지](https://firebasestorage.googleapis.com/v0/b/fir-readme-storage.appspot.com/o/%E1%84%89%E1%85%B3%E1%84%8F%E1%85%B3%E1%84%85%E1%85%B5%E1%86%AB%E1%84%89%E1%85%A3%E1%86%BA%202022-06-02%20%E1%84%8B%E1%85%A9%E1%84%92%E1%85%AE%2010.55.21.png?alt=media&token=31460bdc-5cba-4274-a38c-e5a87566aecd)

- **커뮤니티 화면** : 게시글 등록, 수정, 삭제가 가능하다.

![로그인](https://firebasestorage.googleapis.com/v0/b/fir-readme-storage.appspot.com/o/%E1%84%89%E1%85%B3%E1%84%8F%E1%85%B3%E1%84%85%E1%85%B5%E1%86%AB%E1%84%89%E1%85%A3%E1%86%BA%202022-06-02%20%E1%84%8B%E1%85%A9%E1%84%92%E1%85%AE%2010.38.38.png?alt=media&token=5e34c62b-f65b-469f-84fc-dca665bd96bc)

- **위치 정보 화면** : 사용자의 현재 위치가 나오고 건물 이름 버튼을 누르면 마커가 표시된다. 지도에 표시된 마커를 누르면 건물 정조가 담긴 다이얼로그 창이 나온다.

![마이페이지](https://firebasestorage.googleapis.com/v0/b/fir-readme-storage.appspot.com/o/%E1%84%89%E1%85%B3%E1%84%8F%E1%85%B3%E1%84%85%E1%85%B5%E1%86%AB%E1%84%89%E1%85%A3%E1%86%BA%202022-06-02%20%E1%84%8B%E1%85%A9%E1%84%92%E1%85%AE%2010.46.10.png?alt=media&token=f6ba20e7-9aa8-440e-9bcf-021f0bd07490)

<br/>

## 🔨 프로젝트 구조
![아키텍처](https://firebasestorage.googleapis.com/v0/b/fir-readme-storage.appspot.com/o/%E1%84%89%E1%85%B3%E1%84%8F%E1%85%B3%E1%84%85%E1%85%B5%E1%86%AB%E1%84%89%E1%85%A3%E1%86%BA%202022-06-02%20%E1%84%8B%E1%85%A9%E1%84%92%E1%85%AE%2011.19.37.png?alt=media&token=79093ff3-9c0a-40fd-8721-f0fa54625694)

<br/>
