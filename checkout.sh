#!/usr/bin/env bash

BASENAME=$(basename "$0")

function print_usage() {
  echo "Usage: $BASENAME COMMAND [arg...]
       $BASENAME [ --help ]

  A self-sufficient runtime for checkout application.

  Commands:
      help                Get detailed help and usage
      start               Start services
      stop                Stop services

  Run '$BASENAME COMMAND --help' for more information on a command."
  exit 1
}

function start() {
  docker-compose -f docker/docker-compose.yml up --build -d
  while ! docker-compose -f docker/docker-compose.yml exec kafka cub kafka-ready -b kafka:9092 1 1 >/dev/null 2>&1; do
    echo "Kafka nao esta pronto"
    sleep 1
  done
  ./docker/kafka/init-topics.sh
}

function stop() {
  docker-compose -f docker/docker-compose.yml down
}

function parse_command() {
  local command=$1
  case $command in
  -h | --help | help)
    print_usage
    exit
    ;;
  start)
    start
    exit
    ;;
  stop)
    stop
    exit
    ;;
  *)
    echo "$BASENAME: '$command' is not a $BASENAME command."
    echo "Run '$BASENAME --help' for more information."
    exit 1
    ;;
  esac
}

if [ -z "$1" ]; then
  print_usage
else
  parse_command "$1"
fi
