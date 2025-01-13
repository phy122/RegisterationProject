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

학생들은 자기 경험을 포트폴리오로 표현해냅니다.  
하지만 포트폴리오를 제작하는 것은 희망하는 분야에 따라 매우 다양하고 어렵기에,  
저희는 대학생들이 더욱 쉽게 포트폴리오를 디자인할 수 있고 관심 분야와 연관된 다른 사람들의 디자인을 제공하고자 했습니다.

<br/>

## ⭐ 주요 기능
- **메인페이지** : 인기 포트폴리오, 전체 포트폴리오, 학과별 포트폴리오 제공

![메인페이지](https://firebasestorage.googleapis.com/v0/b/fir-readme-storage.appspot.com/o/%E1%84%89%E1%85%B3%E1%84%8F%E1%85%B3%E1%84%85%E1%85%B5%E1%86%AB%E1%84%89%E1%85%A3%E1%86%BA%202022-06-02%20%E1%84%8B%E1%85%A9%E1%84%92%E1%85%AE%2010.32.09.png?alt=media&token=b2d5b84a-eaf0-4f57-9e82-0dda2ee080cb)

- **양식 선택** : 새 양식, 기본 포트폴리오 양식 선택

![선택페이지](https://firebasestorage.googleapis.com/v0/b/fir-readme-storage.appspot.com/o/Image%2Fselect.png?alt=media&token=05794943-9657-40bf-ad36-d3bdbb895d84)

- **양식 미리보기** : 양식 미리보기 후 불러오기가 가능하며, 좋아요 기능 적용 

![미리보기](https://firebasestorage.googleapis.com/v0/b/fir-readme-storage.appspot.com/o/%E1%84%89%E1%85%B3%E1%84%8F%E1%85%B3%E1%84%85%E1%85%B5%E1%86%AB%E1%84%89%E1%85%A3%E1%86%BA%202022-06-02%20%E1%84%8B%E1%85%A9%E1%84%92%E1%85%AE%2010.52.47.png?alt=media&token=7502d5f5-a3c3-4193-a873-620747b7b070)

- **양식 제작** : Drag&Drop 방식으로 이미지, 텍스트, 구분선, 표, 아이콘 등을 이용하여 포트폴리오 제작

![제작페이지](https://firebasestorage.googleapis.com/v0/b/fir-readme-storage.appspot.com/o/%E1%84%89%E1%85%B3%E1%84%8F%E1%85%B3%E1%84%85%E1%85%B5%E1%86%AB%E1%84%89%E1%85%A3%E1%86%BA%202022-06-02%20%E1%84%8B%E1%85%A9%E1%84%92%E1%85%AE%2010.53.28.png?alt=media&token=83162f3e-0802-4c65-863e-e907ca6979b3)

- **양식 PDF저장/생성** : 생성한 양식을 PDF형식으로 저장 가능. 태그, 공개 여부, 썸네일 등을 추가하여 사이트에 업로드

![저장페이지](https://firebasestorage.googleapis.com/v0/b/fir-readme-storage.appspot.com/o/%E1%84%89%E1%85%B3%E1%84%8F%E1%85%B3%E1%84%85%E1%85%B5%E1%86%AB%E1%84%89%E1%85%A3%E1%86%BA%202022-06-02%20%E1%84%8B%E1%85%A9%E1%84%92%E1%85%AE%2010.54.47.png?alt=media&token=015f9d34-ed1f-4017-8de3-832fb026e0a2)

- **양식 검색** : 제목이나 태그를 통해 포트폴리오 검색

![검색페이지](https://firebasestorage.googleapis.com/v0/b/fir-readme-storage.appspot.com/o/%E1%84%89%E1%85%B3%E1%84%8F%E1%85%B3%E1%84%85%E1%85%B5%E1%86%AB%E1%84%89%E1%85%A3%E1%86%BA%202022-06-02%20%E1%84%8B%E1%85%A9%E1%84%92%E1%85%AE%2010.55.21.png?alt=media&token=31460bdc-5cba-4274-a38c-e5a87566aecd)

- **로그인/회원가입** : 유저의 학교,학과 데이터를 입력받아 포트폴리오 관리

![로그인](https://firebasestorage.googleapis.com/v0/b/fir-readme-storage.appspot.com/o/%E1%84%89%E1%85%B3%E1%84%8F%E1%85%B3%E1%84%85%E1%85%B5%E1%86%AB%E1%84%89%E1%85%A3%E1%86%BA%202022-06-02%20%E1%84%8B%E1%85%A9%E1%84%92%E1%85%AE%2010.38.38.png?alt=media&token=5e34c62b-f65b-469f-84fc-dca665bd96bc)

- **마이페이지** : 유저정보, 좋아요 누른 포트폴리오, 자신의 포트폴리오 관리

![마이페이지](https://firebasestorage.googleapis.com/v0/b/fir-readme-storage.appspot.com/o/%E1%84%89%E1%85%B3%E1%84%8F%E1%85%B3%E1%84%85%E1%85%B5%E1%86%AB%E1%84%89%E1%85%A3%E1%86%BA%202022-06-02%20%E1%84%8B%E1%85%A9%E1%84%92%E1%85%AE%2010.46.10.png?alt=media&token=f6ba20e7-9aa8-440e-9bcf-021f0bd07490)

<br/>

## 🔨 프로젝트 구조
![아키텍처](https://firebasestorage.googleapis.com/v0/b/fir-readme-storage.appspot.com/o/%E1%84%89%E1%85%B3%E1%84%8F%E1%85%B3%E1%84%85%E1%85%B5%E1%86%AB%E1%84%89%E1%85%A3%E1%86%BA%202022-06-02%20%E1%84%8B%E1%85%A9%E1%84%92%E1%85%AE%2011.19.37.png?alt=media&token=79093ff3-9c0a-40fd-8721-f0fa54625694)

<br/>
