echo $1 $2
echo "---------------------------------------------------"
curl -X GET 192.168.100.102:5000/v2/$1/tags/list
echo "---------------------------------------------------"

curl -v --silent -H "Accept: application/vnd.docker.distribution.manifest.v2+json" -X GET 192.168.100.102:5000/v2/$1/manifests/$2 2>&1 | grep Docker-Content-Digest | awk '{print ($3)}' 

DIGEST=`curl -v --silent -H "Accept: application/vnd.docker.distribution.manifest.v2+json" -X GET 192.168.100.102:5000/v2/$1/manifests/$2 2>&1 | grep Docker-Content-Digest | awk '{print ($3)}'`

curl -X DELETE 192.168.100.102:5000/v2/$1/manifests/${DIGEST}

docker exec -it k8s-private-registry  bin/registry garbage-collect  /etc/docker/registry/config.yml 

docker stop k8s-private-registry
docker start k8s-private-registry
