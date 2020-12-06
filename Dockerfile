FROM java:8
COPY "./target/message-0.0.1-SNAPSHOT.jar" "/message-0.0.1-SNAPSHOT.jar"
EXPOSE 21000
CMD ["java", "-jar","message-0.0.1-SNAPSHOT.jar","--spring.profiles.active=product"]