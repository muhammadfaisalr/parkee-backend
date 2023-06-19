# parkee-backend

Execute SQL First Before Compiling or Running Spring Boot!

1. Config Datasource Apps in ```application.properties```
2. Running Configuration -> Modify Options -> Check Environment Variables (ALT + E)
3. Java 18 -> Main Class: id.muhammadfaisal.parkee.ParkeeApplication
4. Running.


HTTP Request Example : 
> Master
1. Get Vehicle Types 
```http://localhost:9090/api/vehicle-types``` Method ```GET```
Response : 
```
{
    "code": 200,
    "message": "Berhasil",
    "data": [
        {
            "id": 1,
            "code": "M",
            "name": "Mobil",
            "price": 3000
        },
        {
            "id": 2,
            "code": "O",
            "name": "Motor",
            "price": 3000
        },
        {
            "id": 3,
            "code": "T",
            "name": "Truk",
            "price": 7000
        },
        {
            "id": 4,
            "code": "B",
            "name": "Bus",
            "price": 10000
        }
    ]
}
```

> Transaction
2. New Transaction
```http://localhost:9090/api/parkee/new-transaction``` Method ```POST```
Request: 
```
{
    "vehicleNumber":"B1108AJK",
    "vehicleType":1,
    "status":1
}
```
Response : 
```
{
    "code": 200,
    "message": "Berhasil, Silahkan Masuk!",
    "data": {
        "id": 654,
        "parkingSlip": "B1108AJK",
        "vehicleNumber": "B1108AJK",
        "vehicleType": 1,
        "paymentMethod": null,
        "checkInTime": "2023-06-19T23:31:45.675740500",
        "checkOutTime": null,
        "discount": null,
        "discountAmount": null,
        "baseAmount": 3000,
        "totalAmount": null,
        "status": 1
    }
}
```

Another REST Api available here 
```https://www.postman.com/docking-module-astronomer-78575518/workspace/public-workspace/collection/18935989-a4826c92-1d8a-42ce-bdde-ed41a2f4e51f?action=share&creator=18935989```
