Starter 
========

This is a starter project for using spring-boot, postgres, jooq, jooq-models, spring-webmvc, generated api models, react, and typescript.
   
## Developing

    ./vm up
    
    # Ensure clean build
    mvn clean install
    
    # Dev Tab:
    ./dbcli migrate         # <= Run this when you update migrations
    ./dbcli --help          # <= Print dbcli help
    ./regen                 # <= Run this when you want to regen models (db/api)
    ./regen-db-models       # <= Run this when you want to regen database models
    ./regen-api-models      # <= Run this when you want to regen api models
    ./dev-watch             # <= Watch for changes and rebuild web ui (see http://localhost:8081 for live view)
    
    # Server Tab:
    ./webcli                # <= Run the webserver
    ./webcli --help         # <= Print webcli help
    

## Queues / Messaging

During development, 

## Websockets

During development, client websockets connect to the local spring memory broker for single node.

In production, client websockets connect to a local spring relay that then relays to a STOMP enabled
system. The recommendation is RabbitMQ with the STOMP 1.2 plugin. 

## Todo:

- [ ] websocket example (use rabbitmq / stomp)
- [ ] queueing example (use rabbitmq / annotations)
- [ ] messaging example (use rabbitmq / annotations)
- [ ] XSD based configuration objects
- [ ] Send emails (https://docs.aws.amazon.com/ses/latest/DeveloperGuide/quick-start.html)
- [ ] Send SMS (https://docs.aws.amazon.com/sns/latest/dg/sns-mobile-phone-number-as-subscriber.html)
- [ ] Maps (https://github.com/react-native-community/react-native-maps via openstreetmap)
- [ ] PWA for webap

## Done:

- [x] Authentication
- [x] Oauth google email principal login
- [x] Oauth facebook email principal login
- [x] add react ui lib https://material-ui.com/
- [x] share web service models with typescript 
- [x] a react-native project (android)
- [x] a react-native project (ios)
- [x] vagrant w/ rabbitmq & postgres
- [x] home directory
- [x] messaging / queues (use rabbit)
- [x] database & migrations & generated models (use jooq/flyway)
- [x] configurable logging (via spring)
- [x] executable assemblies for web (mvn -pl web package spring-boot:repackage)
- [x] export as deployable war (mvn package -Pwar)
