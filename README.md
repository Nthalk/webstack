Starter 
========

This is a starter project for using spring-boot, h2database, jooq, jooq-models, spring-webmvc, react, mobx, and typescript.
   
## Developing

    mvn clean install
    
    # Db Tab:
    ./dbcli start --migrate # <= Run Db server
    
    # Dev Tab:
    ./dbcli migrate         # <= Run this when you update migrations
    ./regen                 # <= Run this when you want to regen models (db/api)
    ./dev-watch             # <= Watch for changes and rebuild web ui
    
    # Server Tab:
    ./webcli start         # <= Run the webserver
    

## Queues / Messaging

During development, 

## Websockets

During development, client websockets connect to the local spring memory broker for single node.

In production, client websockets connect to a local spring relay that then relays to a STOMP enabled
system. The recommendation is RabbitMQ with the STOMP 1.2 plugin. 

## Tasks:

- [ ] websocket example (use rabbitmq / stomp)
- [ ] queueing example (use rabbitmq / annotations)
- [ ] messaging example (use rabbitmq / annotations)
- [ ] XSD based configuration
- [ ] Authentication
- [x] add react ui lib https://material-ui.com/
- [x] a react-native project (android)
- [x] a react-native project (ios)
- [x] vagrant w/ rabbitmq & postgres
- [x] home directory
- [x] messaging / queues (use rabbit)
- [x] database & migrations & generated models (use jooq/flyway)
- [x] configurable logging (via spring)
- [x] executable assemblies for web (mvn -pl web package spring-boot:repackage)
- [x] export as deployable war (mvn package -Pwar)
