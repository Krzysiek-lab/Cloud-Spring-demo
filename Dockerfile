FROM openjdk:17
ADD target/demo.jar demo.jar
CMD ["java", "-jar", "/demo.jar"]