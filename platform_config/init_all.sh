kubectl apply -f msa-config-server/deployment.yml
kubectl apply -f msa-config-server/service.yml

kubectl apply -f msa-eureka-server/deployment.yml
kubectl apply -f msa-eureka-server/service.yml
kubectl apply -f msa-eureka-server/ingress.yml

kubectl apply -f msa-svc-member/deployment.yml
kubectl apply -f msa-svc-member/autoscaler.yml

kubectl apply -f msa-svc-order/deployment.yml
kubectl apply -f msa-svc-order/autoscaler.yml

kubectl apply -f msa-zuul-server/deployment.yml
kubectl apply -f msa-zuul-server/service.yml
kubectl apply -f msa-zuul-server/ingress.yml
kubectl apply -f msa-zuul-server/autoscaler.yml


kubectl apply -f msa-turbine-server/deployment.yml
kubectl apply -f msa-turbine-server/service.yml
kubectl apply -f msa-turbine-server/ingress.yml

kubectl apply -f msa-zipkin-server/deployment.yml
kubectl apply -f msa-zipkin-server/service.yml
kubectl apply -f msa-zipkin-server/ingress.yml

kubectl apply -f msa-auth-server/deployment.yml
kubectl apply -f msa-auth-server/service.yml
kubectl apply -f msa-auth-server/ingress.yml

kubectl apply -f msa-svc-ui/deployment.yml
kubectl apply -f msa-svc-ui/service.yml
kubectl apply -f msa-svc-ui/ingress.yml
