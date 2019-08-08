FROM hub.hurriyetemlak.com/java-ci-base:v1.0 AS build-project
ADD . ./photo-tagger-api
WORKDIR /photo-tagger-api
RUN ./mvnw clean install -DskipTests

FROM hub.hurriyetemlak.com/java-centos-base:v1
EXPOSE 3232
WORKDIR /app
COPY --from=build-project ./photo-tagger-api/target/photo-tagger-api-*.jar ./photo-tagger-api.jar
ENV ARTIFACT_NAME=photo-tagger-api.jar