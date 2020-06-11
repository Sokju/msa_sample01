
MSA 샘플 유형1(Spring Cloud + Netflix OSS)
======================

# 1. msa-config-server
* Spring Cloud Config 예제
* git Repository를 config 저장소로 테스트
* Port : 8888
* Dockerfile 로 빌드 후 
* Kubernetes 에 deployment.yml 로 pod 및 service 배포 테스트

# 2. msa-eureka-server
* Netflix Eureka 예제
* Spring Cloud Config 서버 연동없이 자체 Config 설정 
* Port : 8761
* Dockerfile 로 빌드 후 
* Kubernetes 에 deployment.yml 로 pod 및 service, Ingress 배포 테스트
* Ingress URL은 eureka.msasmp01.com 로 테스트 

# 3. msa-zuul-server
* Netflix Zuul 예제
* Spring Cloud Config 서버 연동하여 routing 설정 
* Port : 9090
* Dockerfile 로 빌드 후 
* Kubernetes 에 deployment.yml 로 pod 및 service, Ingress 배포 테스트
* Ingress URL은 zuul.msasmp01.com 로 테스트 
* Swagger UI 포

# 4. msa-auth-server
* Spring Security Resource/Authorization Server 예제
* Spring Cloud Config 서버 연동
* Port : 9080
* Dockerfile 로 빌드 후 
* Kubernetes 에 deployment.yml 로 pod 및 service, Ingress 배포 테스트
* Ingress URL은 auth.msasmp01.com 로 연계 테스

# 5. msa-svc-member
* 임의의 마이크로서비스 샘플 1
* Spring Cloud Config 서버 연동
* Port : 9091
* Dockerfile 로 빌드 후 
* Kubernetes 에 deployment.yml 로 pod 배포 테스트(Service 없이 Eureka 로 Service Discovery 테스트 )
* @FeignClient 로 msa-svc-order 호출 예제 테스트
* hystrix 테스트(Timeout 유발 circuit-breaker 테스트) 

# 6. msa-svc-order
* 임의의 마이크로서비스 샘플 2
* Spring Cloud Config 서버 연동
* Port : 9092
* Dockerfile 로 빌드 후 
* Kubernetes 에 deployment.yml 로 pod 배포 테스트(Service 없이 Eureka 로 Service Discovery 테스트 )

# 7. msa-svc-ui
* Frontend UI 용 마이크로서비스  예제(미완성)
* 원래 Spring Security 연동 로그인 처리, 임의의 서비스 2개 호출 예제로 정리
* Spring Cloud Config 서버 연동
* Port : 9093
* Dockerfile 로 빌드 후 
* Kubernetes 에 deployment.yml 로 pod 및 service, Ingress 배포 테스트
* Ingress URL은 ui.msasmp01.com 로 테스트 

# 8. msa-turbine-server
* Hystrix Dashboard 및 스트림 수집 Turbine 서버 구
* Spring Cloud Config 서버 연동
* Port : 9010
* Dockerfile 로 빌드 후 
* Kubernetes 에 deployment.yml 로 pod 및 service, Ingress 배포 테스트
* Ingress URL은 turbine.msasmp01.com 로 테스트 
* 테스트 결과 Eureka 환경에선 바로 쓸 수 있으나, Eureka 없는 환경에선 MQ, Turbine, Dashboard 롤 별도로 구성해야 함(유형2 에서 테스트 해봄)

# 9. msa-zipkin-server
* Trace Monitoring 서버
* Zipkin은 기존에 Spring boot 위에 Library 방식으로 포팅을 더이상 지원안한다고 함
* 홈페이지에서 바이너리(jar) 자체로 가져다 실행했음
* 테스트시 가장 부하가 많이 걸리는 서버 중에 하나임...
* 임의의 부하 가중시 가장 먼저 OOM 이 발생되는 패턴을 보임
* Port : 9411
* Dockerfile 로 빌드 후 
* Kubernetes 에 deployment.yml 로 pod 및 service, Ingress 배포 테스트
* Ingress URL은 zipkin.msasmp01.com 로 테스트 


