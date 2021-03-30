#!/bin/bash
set -ex
docker run --rm \
       -p 55680:55680 \
       -v $(cd $(dirname $0);pwd)/config.yaml:/etc/otel/config.yaml \
       -e DD_API_KEY \
       otel/opentelemetry-collector-contrib \
       --config /etc/otel/config.yaml