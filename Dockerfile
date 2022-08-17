FROM adoptopenjdk/openjdk11
WORKDIR /opt
ADD target/order-*.jar order.jar
EXPOSE 8089
ENTRYPOINT ["java", "-jar", "/opt/order.jar"]