docker run --name k8s-private-registry -v /sw/registry/data:/var/lib/registry/docker/registry/v2 -d -p 5000:5000 -e REGISTRY_STORAGE_DELETE_ENABLED=True registry 
#docker run --name k8s-private-registry -v /sw/registry/data:/var/lib/registry/docker/registry/v2 -d -p 5000:5000 registry 
