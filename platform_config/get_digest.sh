echo $1
curl -v --silent -H "Accept: application/vnd.docker.distribution.manifest.v2+json" -X GET 192.168.100.102:5000/v2/$1/manifests/$2 2>&1 | grep Docker-Content-Digest | awk '{print ($3)}' 
