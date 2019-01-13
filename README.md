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
    

## Todo:

- [ ] Add executable assemblies for db/web
- [x] Add home directory
- [ ] Add configurable logging
- [x] Add atomix
- [ ] Add messaging / queues (use atomix)
- [ ] Add websockets (use atomix)
- [ ] Add a react-native project (android)
- [ ] Add a react-native project (ios)
