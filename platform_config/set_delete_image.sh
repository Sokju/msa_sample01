echo $1 $2

IMG_NM=$1
TAG_NO=$2

echo "---------------------------------------------------"
curl -X GET 192.168.100.102:5000/v2/${IMG_NM}/tags/list
echo "---------------------------------------------------"

curl -v --silent -H "Accept: application/vnd.docker.distribution.manifest.v2+json" -X GET 192.168.100.102:5000/v2/${IMG_NM}/manifests/${TAG_NO} 2>&1 | grep Docker-Content-Digest | awk '{print ($3)}' 

DIGEST=`curl -v --silent -H "Accept: application/vnd.docker.distribution.manifest.v2+json" -X GET 192.168.100.102:5000/v2/${IMG_NM}/manifests/${TAG_NO} 2>&1 | grep Docker-Content-Digest | awk '{print ($3)}'`

URL="192.168.100.102:5000/v2/${IMG_NM}/manifests/${DIGEST}"
URL=${URL%$'\r'}
echo "curl -X DELETE ${URL}" |awk '{print $0}' |sh -v

docker exec -it k8s-private-registry  bin/registry garbage-collect  /etc/docker/registry/config.yml 

docker stop k8s-private-registry
docker start k8s-private-registry
