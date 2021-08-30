#!/bin/bash
export NAME=docker.pkg.github.com/nestor-by/java-courses-2021/java:0.0.1-artsymenia
docker image build -f Dockerfile.jre -t $NAME .
docker push $NAME