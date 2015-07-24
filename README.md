# camel-bacth

## Description
Programme Camel qui permet via des routes d'alimenter plusieurs types de sources. 
Il prend un fichier CSV en entrée et le tranqforme en fichier JSON.

Les patterns utilisés parmi les 50 EIP et fonctionalités sont les suivants:
- split
- aggregate
- convert
- bean
- unmarshall/marshall pour le csv et JSON
- choose
- xpath

Route existante:
- une route File to File
- une route File to AMQP
- une route file to RabbitMQ
- une route file to Elastic
- une route file to mongo
- une route mongo to es

## Confuguration
- java 8
- camel 2.15.2

## Usage
Usage : java -jar ... -file <PATH>\\data.properties -command start -job file");

- command option [start|stop]
- job option [es|mongo|rabbit|file|mongoToFile|amqp]

### data.properties
-Fichier contenant les données de configurations

file.in=C:/Dev/workspace/Camel-Batch/data/in/csv/maif
file.out=C:/Dev/workspace/Camel-Batch/data/out/json

mongo.host=localhost
mongo.port=27017
mongo.database=testCamel
mongo.collection=personnes
	
es.cluster=localhost
es.host=localhost
es.port=9300
es.index=testcamel
es.type.index=personne

#bactivemq.port=61616

rabbitMQ.port=5672
rabbitMQ.host=localhost
rabbitMQ.virtual.host=/
rabbitMQ.user=guest
rabbitMQ.password=guest
rabbitMQ.exchange=testcamel


