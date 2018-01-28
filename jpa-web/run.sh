#criando imagem dp postgreSQL
docker build -t ricardojob/banco ./postgres
docker run -p 5433:5432 -d --name banco ricardojob/banco

#criando imagem da aplicação
mvn clean package
docker build -t ricardojob/datasource .
docker run -p 8080:8080 -p 4848:4848 -d --name app --link banco:host-banco ricardojob/datasource
