FROM anapsix/alpine-java

# COPY ./build/libs/DungeonMaster-0.0.1-SNAPSHOT.jar /home/DungeonMaster-0.0.1-SNAPSHOT.jar

WORKDIR /app

CMD ["java","-jar","./DungeonMaster-0.0.1-SNAPSHOT.jar"]