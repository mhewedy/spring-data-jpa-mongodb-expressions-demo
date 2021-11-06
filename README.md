## Demo application for spring-data-jpa-mongodb-expressions

1. first run the application
2. start sending querying as below

### Example queries:

**1. find all employees with last name "ibrahim" _or_ firstname is "mostafa" and birthdate after "1990-01-01", sorting by id desc:**

URL: 
```
http://localhost:8080/search?sort=id,desc
```

Request body:
```json
{
  "$or": [
    {"lastName": "ibrahim"},
    {
      "$and": [
        {"firstName": "mostafa"},
        {
          "birthDate": {"$gt": "1990-01-01"}
        }
      ]
    }
  ]
}
```
 
 Screenshot:

<img src="https://github.com/springexamples/spring-data-jpa-mongodb-expressions-demo/raw/master/etc/1.PNG?raw=true" width="700px" />

---

**2. find all employees with last name "ibrahim" _or_ department name contains "sw":**

URL:
```
http://localhost:8080/search
```

Request body:
```json
{
  "lastName": "ibrahim",
  "department.name": {"$contains":  "sw"}
}
```

<img src="https://github.com/springexamples/spring-data-jpa-mongodb-expressions-demo/raw/master/etc/2.PNG?raw=true" width="700px" />
