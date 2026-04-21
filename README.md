# ASMAndroid
AI SW Maestro 학습 레포입니다.

## Layered Architecture VS Clean Architecture 질문
- clean Architecture의 특징은 domain이 data나 ui를 모르게 하는 것이 장점인데, 이를 위해선 단일 모듈이 아닌 멀티 모듈이 필수적인 것 같다.(의존성을 지우기 위해) 그러면 소규모의 프로젝트에서는 clean Architecture이 오버엔지니어링이 될 수 있나?
- gson은 보다 kotlin serialization이 더 빠른 것으로 알고 있는데 사용하는 이유가 있을까?
- usecase는 기능이 작을 수록 repository 함수를 그대로 사용하는 경우가 많아 무의미한 중복이라고 생각이 들 때가 있는데, 실제론 어떤지?
- viewmodel을 사용하는 screen은 preview로 테스트가 어려운데, 보통 어떻게 테스트하는지?
