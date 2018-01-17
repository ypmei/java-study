####打包
mvn package

####启动
mvn package && java -jar target/ypmei-1.0-SNAPSHOT.jar
mvn clean spring-boot:run


####清除包
mvn clean


####curl
git clone https://github.com/curl/curl.git

curl http://127.0.0.1:8080/

####根目录下安装依赖，去掉测试
mvn clean install -DskipITs -DskipTests


