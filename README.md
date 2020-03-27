# conversao-cambio

Primeiramente é necessário rodar o "maven build" para gerar o .jar.
Após isso, rodar os comandos abaixo para subir a aplicação em um docker container:

docker build -t conversao-cambio .
docker run --name conversao -p 8080:8080 conversao-cambio

A aplicação irá rodar em: http://192.168.99.100:8080