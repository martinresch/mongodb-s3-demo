FROM registry.redhat.io/codeready-workspaces/plugin-java11-rhel8 AS builder

USER root
WORKDIR /build

# Build dependency offline to streamline build
COPY pom.xml .
RUN mvn dependency:go-offline

COPY src src
RUN mvn package -Dmaven.test.skip=true

FROM registry.redhat.io/openjdk/openjdk-11-rhel7 AS runtime

WORKDIR /app

COPY --from=builder /build/target/mongodb-openshift-demo-0.0.1-SNAPSHOT.jar /app/target/mongodb-openshift-demo-0.0.1-SNAPSHOT.jar
#COPY /build/target/mongodb-openshift-demo-0.0.1-SNAPSHOT.jar /app/target/mongodb-openshift-demo-0.0.1-SNAPSHOT.jar

EXPOSE 8081
ENTRYPOINT [ "java", "-jar", "/app/target/mongodb-openshift-demo-0.0.1-SNAPSHOT.jar", "--server.port=8081" ]
