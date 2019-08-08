# Spring Photo Tagger Backend 

## Tools
```
Couchbase used for database.
Java and Spring used for repository, service and controller layers.
Swagger used for checking controller end points.
```
## Port
```
The project uses localhost:/8086 for swagger.ui
```

## Configuration
```
In order to run this project, you must configure it with your own couchbase server from application.yml
You should change couchbase username, couchbase password and couchbase bucket name.
Also, your bucket should have Photo objects which has these attributes;
(String) "address", 
(String) "assignedTo", 
(Array) "tagList"
```

## PS
```
If, I can do it, I will post here a link for live version.
