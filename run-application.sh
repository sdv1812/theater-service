

wget https://download.java.net/java/GA/jdk19.0.2/fdb695a9d9064ad6b064dc6df578380c/7/GPL/openjdk-19.0.2_linux-x64_bin.tar.gz

tar -xvf openjdk-19.0.2_linux-x64_bin.tar.gz
#
#vim ~/.bashrc
#
#export JAVA_HOME="/home/ec2-user/jdk-19.0.2"
#export PATH="$JAVA_HOME/bin:$PATH"

aws s3 cp s3://theater-jars/theater-0.0.1-SNAPSHOT.jar .

# restart terminal

java -jar theater-0.0.1-SNAPSHOT.jar

