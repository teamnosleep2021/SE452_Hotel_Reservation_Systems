FROM openjdk:11
EXPOSE 8080
COPY hotelreservationsystem/build/libs/hotelreservationsystem-0.0.1-SNAPSHOT.jar hotelreservationsystem-0.0.1-SNAPSHOT.jar
ENTRYPOINT ["java","-jar","/hotelreservationsystem-0.0.1-SNAPSHOT.jar"]
