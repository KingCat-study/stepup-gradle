# AWS 기반 WebService 프로젝트

1. 이 프로젝트는 제로베이스에서 백엔드 영역을 중심으로 Webservice 전체 구조를 제 스스로 리마인드 하기 위해 만들었습니다.
2. 스프링부트와 AWS로 구현함으로써 부족했던 AWS 인프라 지식과 경험을 어느정도 충족시킬 수 있었습니다.
3. 기본적인 put/get/post/delete Method 구성
4. Custom Oauth2 를 구성하여 구글 계정 로그인 연동

* Tech Stack
  * Java 17 
  * SpringBoot 2.7
  * Spring Security OAuth 2.0 (Google Account Login)
  * JPA
  * Gradle
  * Travis(설정 구성까지만 진행)
  * Github Action
  * nginx(무중단 배포를 위한 이중화)
  * AWS
      * Aurora(Mysql)
      * S3
      * EC2
      * CodeDeploy
