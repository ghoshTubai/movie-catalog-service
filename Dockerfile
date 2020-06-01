FROM openjdk:8
COPY ./target/movie-catalog-service.jar movie-catalog-service.jar
EXPOSE 8090
ENTRYPOINT ["java","-jar","movie-catalog-service.jar"]