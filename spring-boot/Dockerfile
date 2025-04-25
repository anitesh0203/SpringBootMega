#FROM Name of the image from marketplace with tag
#ADD source jar location --> target jar name
#ENTRYPOINT command that you want to execute
#



FROM openjdk:25-jdk-bullseye
ADD target/basic-app.jar basic-app.jar
ENTRYPOINT ["java", "-jar", "/basic-app.jar"]