# 의료기기 통합정보시스템 API 활용예제

## Requirements

1. JDK 1.8
1. Maven

## Tech

* SpringBoot 2.2
* Thymeleaf 3
* Jquery3
* Bootstrap4

## Clone 후 해야될 것

* application.yml 의 oauth 설정값 변경

```yaml
oauth:
  client-id: blahblah  <- 변경
  secret: blahblah <- 변경
```
설정값은 통합정보시스템의 사용자정보 보기에서 확인

## 실행방법

```shell script
$ ./mvnw spring-boot:run
```

실행 후 아래 경로로 접속

```
http://localhost:8080/models
```
