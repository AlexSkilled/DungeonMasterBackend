FROM anapsix/alpine-java

COPY ./build/libs/DungeonMaster-0.0.1-SNAPSHOT.jar /home/DungeonMaster-0.0.1-SNAPSHOT.jar

CMD ["java","-jar","/home/DungeonMaster-0.0.1-SNAPSHOT.jar"]