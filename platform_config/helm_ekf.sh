helm repo add incubator https://kubernetes-charts-incubator.storage.googleapis.com/

helm install --name elasticsearch stable/elasticsearch \
     --set master.persistence.enabled=false \
     --set data.persistence.enabled=false \
     --namespace kube-logging
	 
helm install --name kibana stable/kibana \
    --set env.ELASTICSEARCH_URL=http://elasticsearch-client:9200 \
    --namespace kube-logging

curl https://raw.githubusercontent.com/fluent/fluent-bit-kubernetes-logging/master/fluent-bit-service-account.yaml > fluent-bit-service-account.yaml    
curl https://raw.githubusercontent.com/fluent/fluent-bit-kubernetes-logging/master/fluent-bit-role.yaml > fluent-bit-role.yaml
curl https://raw.githubusercontent.com/fluent/fluent-bit-kubernetes-logging/master/fluent-bit-role-binding.yaml > fluent-bit-role-binding.yaml

namespace 변경

kubectl apply -f fluent-bit-service-account.yaml
kubectl apply -f fluent-bit-role.yaml 
kubectl apply -f fluent-bit-role-binding.yaml 

curl https://raw.githubusercontent.com/fluent/fluent-bit-kubernetes-logging/master/output/elasticsearch/fluent-bit-configmap.yaml > fluent-bit-configmap.yaml
kubectl apply -f fluent-bit-configmap.yaml


wget https://raw.githubusercontent.com/fluent/fluent-bit-kubernetes-logging/master/output/elasticsearch/fluent-bit-ds.yaml

FLUENT_ELASTICSEARCH_HOST variable from elasticsearch to elasticsearch-client.

kubectl apply -f fluent-bit-ds.yaml

apiVersion: apps/v1 로 변경

selector:
    matchLabels:
      k8s-app: fluent-bit-logging spec 밑에 추가
	  
ingress 생성


==================================
리소스가 안되어
non-production 으로 재구성

kubectl create namespace logging

kubectl run elasticsearch \
	--image=docker.elastic.co/elasticsearch/elasticsearch:6.7.0 \
	-n logging
	
kubectl expose deploy elasticsearch --port 9200 -n logging
	  
helm del --purge kibana
	  
helm install --name kibana stable/kibana \
    --set env.ELASTICSEARCH_URL=http://elasticsearch:9200 \
    --namespace logging


kubectl apply -f fluent-bit-service-account.yaml
kubectl apply -f fluent-bit-role.yaml 
kubectl apply -f fluent-bit-role-binding.yaml 
kubectl apply -f fluent-bit-configmap.yaml


kubectl apply -f fluent-bit-ds.yaml

worker
sysctl -w vm.max_map_count=262144
	  
