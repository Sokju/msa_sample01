echo $1
curl -X GET 192.168.100.102:5000/v2/$1/tags/list
