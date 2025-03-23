FROM openjdk:21
EXPOSE 7575
						#origen    				#destino
ADD target/spring-boot-api-rest-docker.jar spring-boot-api-rest-docker.jar
ENTRYPOINT ["java","-jar","/spring-boot-api-rest-docker.jar"]