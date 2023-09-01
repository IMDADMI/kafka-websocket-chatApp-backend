# real-time chat application
### this application basically use websocket to make a realtime messaging system and kafka for dealing with large amount of users and services 
### react js and mui for the front end 
### spring boot for the backend
## not completed yet
# how to run the app
### to get started you need to install kafka server and launch the following commands :
## backend
* .\bin\windows\zookeeper-server-start.bat .\config\zookeeper.properties : to start zookeeper 
* .\bin\windows\kafka-server-start.bat .\config\server.properties : to start the kafka server
* create a database named chat or whatever (view in the properties file)
## front end (https://github.com/IMDADMI/kafka-websocket-chatApp)
* npm i : to install the packages
* npm run dev to start the application
