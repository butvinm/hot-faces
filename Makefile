.PHONY: run war build

run: build
	docker run -p 8080:8080 -p 8787:8787 lab2 /opt/jboss/wildfly/bin/standalone.sh --debug -b 0.0.0.0

war: src/**/*
	mvn clean package

build: war Dockerfile
	docker build -t lab2 .

