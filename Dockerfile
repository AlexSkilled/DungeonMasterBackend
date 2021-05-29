FROM anapsix/alpine-java

COPY ./build/libs/DungeonMaster-0.0.1-SNAPSHOT.jar /home/DungeonMaster-0.0.1-SNAPSHOT.jar

RUN echo 'Hi, I am in your container'

CMD ["java","-jar","/home/DungeonMaster-0.0.1-SNAPSHOT.jar"]