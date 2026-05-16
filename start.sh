#!/bin/sh
set -eu

ROOT_DIR=$(CDPATH= cd -- "$(dirname -- "$0")" && pwd)
APP_DIR="$ROOT_DIR/ecoTaggy-backend"

cd "$APP_DIR"

set -- target/ecoTaggy-backend-*.jar

if [ ! -f "$1" ]; then
  sh ./mvnw -DskipTests package
  set -- target/ecoTaggy-backend-*.jar
fi

if [ ! -f "$1" ]; then
  echo "Jar do backend nao encontrado em $APP_DIR/target" >&2
  exit 1
fi

exec java -Dserver.port="${PORT:-8080}" -jar "$1"
