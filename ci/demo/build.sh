#!/usr/bin/env bash

set -evx

export PROJECT_ROOT=$(pwd)
export GRADLE_USER_HOME="$PROJECT_ROOT/.gradle"
pushd $1
./gradlew build -x test
#popd
mv "$1/build/libs/*-0.0.1-SNAPSHOT.jar" deploy/
mv "$1/ci/demo/manifest.yml" deploy/
local_route = `echo ${route} | sed 's|https://||g'`
sed -i "s/\[ROUTE\]/${local_route}/g" deploy/manifest.yml
