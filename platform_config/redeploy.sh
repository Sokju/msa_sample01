#kubectl delete -f msa-svc-member/deployment.yml
#kubectl delete -f msa-svc-order/deployment.yml
#kubectl delete -f msa-svc-ui/deployment.yml
#kubectl delete -f msa-zuul-server/deployment.yml
#kubectl delete -f msa-auth-server/deployment.yml
#kubectl delete -f msa-turbine-server/deployment.yml
#kubectl delete -f msa-zipkin-server/deployment.yml
#kubectl delete -f msa-config-server/deployment.yml
#kubectl delete -f msa-eureka-server/deployment.yml

docker build -t 192.168.100.102:5000/msasmp01/msa-eureka-server:1.0     msa-eureka-server/.
docker build -t 192.168.100.102:5000/msasmp01/msa-config-server:1.0     msa-config-server/.
docker build -t 192.168.100.102:5000/msasmp01/msa-auth-server:1.0       msa-auth-server/.
docker build -t 192.168.100.102:5000/msasmp01/msa-svc-order:1.0         msa-svc-order/.
docker build -t 192.168.100.102:5000/msasmp01/msa-svc-member:1.0        msa-svc-member/.
docker build -t 192.168.100.102:5000/msasmp01/msa-svc-ui:1.0        	msa-svc-ui/.
docker build -t 192.168.100.102:5000/msasmp01/msa-zuul-server:1.0       msa-zuul-server/.
docker build -t 192.168.100.102:5000/msasmp01/msa-turbine-server:1.0    msa-turbine-server/.
docker build -t 192.168.100.102:5000/msasmp01/msa-zipkin-server:1.0     msa-zipkin-server/.

docker push 192.168.100.102:5000/msasmp01/msa-eureka-server:1.0
docker push 192.168.100.102:5000/msasmp01/msa-config-server:1.0
docker push 192.168.100.102:5000/msasmp01/msa-auth-server:1.0
docker push 192.168.100.102:5000/msasmp01/msa-svc-order:1.0
docker push 192.168.100.102:5000/msasmp01/msa-svc-member:1.0
docker push 192.168.100.102:5000/msasmp01/msa-svc-ui:1.0
docker push 192.168.100.102:5000/msasmp01/msa-zuul-server:1.0
docker push 192.168.100.102:5000/msasmp01/msa-turbine-server:1.0
docker push 192.168.100.102:5000/msasmp01/msa-zipkin-server:1.0

#kubectl apply -f msa-eureka-server/deployment.yml
#kubectl apply -f msa-config-server/deployment.yml
#kubectl apply -f msa-auth-server/deployment.yml
#kubectl apply -f msa-svc-order/deployment.yml
#kubectl apply -f msa-svc-member/deployment.yml
#kubectl apply -f msa-svc-ui/deployment.yml
#kubectl apply -f msa-zuul-server/deployment.yml
#kubectl apply -f msa-turbine-server/deployment.yml
#kubectl apply -f msa-zipkin-server/deployment.yml

kubectl rollout restart deployment/msa-eureka-server
kubectl rollout restart deployment/msa-config-server
kubectl rollout restart deployment/msa-auth-server
kubectl rollout restart deployment/msa-svc-order
kubectl rollout restart deployment/msa-svc-member
kubectl rollout restart deployment/msa-svc-ui
kubectl rollout restart deployment/msa-zuul-server
kubectl rollout restart deployment/msa-turbine-server
kubectl rollout restart deployment/msa-zipkin-server

