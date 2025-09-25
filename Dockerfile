FROM adoptopenjdk:11.0.9_11-jre-hotspot
COPY ./build/libs/*.jar /home/app.jar
EXPOSE 8080
CMD java -server -Duser.country=EC -Duser.language=es -Duser.timezone=America/Guayaquil -Djava.security.egd=file:/dev/urandom -jar /home/app.jar