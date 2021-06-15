#  store-service 

###  Build Project
- mvn clean install


### Docker Image Create:
docker build -t store-service:1.0 .


### Run Project
docker-compose up

### API 1:

POST : http://127.0.0.1:9080/stores

{
  "storeID": "1234",
  "latitude": 27.876,
  "longitude": -128.33
}

### API 2:


GET : http://127.0.0.1:9080/drivers/nearest?storeId=1234&N=2


### API 3:

POST : http://127.0.0.1:9080/drivers/location

{
  "driverID": "m123@gmail.com",
  "latitude": 27.876,
  "longitude": -128.33
}






