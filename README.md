# spark-simple-rest-api
This is a simple Spark rest api application. Response will return a JSON that will contain car data.

## JsonResponse structure

```
{
  "status" : <status>,
  "message" : <message>,
  "data : <car-array>
}
```

## What you'll need
Java 11

Maven 3.3+

lombok

## To start
To start this application, clone this repo (https://github.com/DivitGitHub/spark-simple-rest-api.git).

Build:
```
mvn install
```
And then run the Application class.

## Build Docker image
```
docker build -f Dockerfile -t docker-spark-api .
```
## Screenshots
I've used Chrome Advanced REST Client to test the API.

### -POST-
![screenshot_1](https://user-images.githubusercontent.com/26686429/50621654-14cded00-0eff-11e9-8904-2cbf04506262.png)

### -GET-
![screenshot_2](https://user-images.githubusercontent.com/26686429/50621648-0e3f7580-0eff-11e9-8a82-d38019a878b2.png)
![screenshot_4](https://user-images.githubusercontent.com/26686429/50621660-17304700-0eff-11e9-9d4c-cb895ae7b2c4.png)

### -DELETE-
![screenshot_3](https://user-images.githubusercontent.com/26686429/50621655-15ff1a00-0eff-11e9-8249-524b1dbd2708.png)

## About
I started this project for fun which showcase a bit of Spark framework, Java 11, MongoDB, JUnit, Mockito and lombok.
