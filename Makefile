.PHONY: run war build

run: build
	docker-compose up

war: src/**/*
	mvn clean package

build: war
	docker-compose build
