## Getting Started

Welcome to the VS Code Java world. Here is a guideline to help you get started to write Java code in Visual Studio Code.

## Folder Structure

The workspace contains two folders by default, where:

- `src`: the folder to maintain sources
- `lib`: the folder to maintain dependencies

## Dependency Management

The `JAVA DEPENDENCIES` view allows you to manage your dependencies. More details can be found [here](https://github.com/microsoft/vscode-java-pack/blob/master/release-notes/v0.9.0.md#work-with-jar-files-directly).



# MSA



### 이벤트 주도 아키텍쳐

- 동기보다 비동기에 의존하는 방식
- 비동기 식의 요청 후 응답을 대기하는 구조가 아닌 이벤트를 서로 주고 받는 방식
- 이벤트 주도 아키텍처는 서비스 간의 결합도를 낮출 수 있음(가장 중요한 이슈)
- MQ, Kafka등의 메시지 브로커들을 사용 가능
- 메시지의 발행 및 구독 기능을 제공하며 인프라적으로는 확장 가능



### Orchestration(동기식) vs Choreography(비동기식)

> Choreography
>
> 특정 이벤트를 발행
>
> 이벤트를 구독하는 서비스들이 각자 적절한 조치를 취함
>
> 구조가 명시적이지 않아 모니터링 및 추적에 어려움이 있음.



### Monolith에 오해

- Monolith는 레거시이다?
- 관리용이성, 트랜잭션에 용이



### MSA 의 장점

- 빠른 delivery
- polyglot architecture지원
- 실험과 혁신 가능
- 탄력적이고 선택적인 확장
- 기술 부채의 경감



### MSA의 특징

- 서비스를 통한 컴포넌트화
- 비지느시 역량에 따른 조직 구성
- 프로젝트보다 제품에 집중
- 분산 된 거버넌스
- 분산 된 데이터 관리
- 인프라 자동화
- 장애 방지 설계



### MSA는 필수인가?

- MSA의 선택은 기술의 문제가 아님
- business benefit증가의 확신이 들때만 도입하는 것이 좋다.
- MSA도 하나의 대안일 뿐
- 모든 문제를 해결해 주지 않고, 오히려 많은 종류의 새로운 문제를 만들어내기도 함.
- Monolithic의 모든 장점을 살리면서 MSA를 도입하는 것은 불가능



### 역량 분류

- 핵심역량
- 지원역량
- 인프라스트럭쳐 역량
- 프로세스 및 통제 역량



### 서비스 분리 전략

- 3 Key point
- 단계적 마이그레이션
- 처음에는 크게 분리, 추후에 작게 분리
- 공식은 없다.
- 

> 결함도 응집도 SRP









