FROM openjdk:8-jre-alpine

ARG JAR_FILE

ADD target/dependency           /usr/share/service/lib
ADD target/${JAR_FILE} /usr/share/service/service.jar
RUN ls -l /usr/share/service/lib
RUN ls -l /usr/share/service/
ENTRYPOINT ["/usr/bin/java", "-cp", "/usr/share/service/service.jar:/usr/share/service/lib/*", "by.part7.product.ProductApp"]
