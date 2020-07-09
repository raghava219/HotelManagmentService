# HotelManagmentService
Room Booking Service


URL : http://localhost:8080/api/bookings -- Method : GET

Description : Above URL is for getting all Booking information.

JSon response for above GET request:

[
    {
        "bookingId": 2,
        "customer": {
            "customerId": 1,
            "firstName": "John",
            "lastName": "Adams",
            "dateOfBirth": "1983-01-03",
            "email": "john_test@gmail.com",
            "password": "test123"
        },
        "startDate": "2020-07-09",
        "endDate": "2020-07-11",
        "room": {
            "roomId": 1000,
            "roomType": "K",
            "roomRent": 20000
        }
    },
    {
        "bookingId": 4,
        "customer": {
            "customerId": 3,
            "firstName": "Dania",
            "lastName": "Dudi",
            "dateOfBirth": "1986-01-03",
            "email": "john_test@gmail.com",
            "password": "test123"
        },
        "startDate": "2020-07-09",
        "endDate": "2020-07-11",
        "room": {
            "roomId": 1000,
            "roomType": "K",
            "roomRent": 20000
        }
    }
]

URL : http://localhost:8080/api/bookings/2  -- Method : GET

Description : Above URL is for getting specific Booking information, in this case for booking_id 2.

JSon response for above GET request:

{
    "bookingId": 2,
    "customer": {
        "customerId": 1,
        "firstName": "John",
        "lastName": "Adams",
        "dateOfBirth": "1983-01-03",
        "email": "john_test@gmail.com",
        "password": "test123"
    },
    "startDate": "2020-07-09",
    "endDate": "2020-07-11",
    "room": {
        "roomId": 1000,
        "roomType": "K",
        "roomRent": 20000
    }
}


URL : http://localhost:8080/api/booking   -- Method : POST

Description : Above URL is for saving the Booking details.

Json Request object:

{
        "customer": {
            "firstName": "Dania",
            "lastName": "Dudi",
            "dateOfBirth": "1986-01-03",
            "email": "john_test@gmail.com",
            "password": "test123"
        },
        "startDate": "2020-07-09",
        "endDate": "2020-07-11",
        "room": {
            "roomId": 1000,
            "roomType": "K",
            "roomRent": 20000
         }
}



URL : http://localhost:8080/api/booking   -- Method : POST

Description : Above URL is for saving the Booking details, but below json body is not having correct RoomId in (1000,2000,3000,4000)

Body of above Post Request :

{
        "customer": {
            "firstName": "Dania",
            "lastName": "Dudi",
            "dateOfBirth": "1986-01-03",
            "email": "john_test@gmail.com",
            "password": "test123"
        },
        "startDate": "2020-07-09",
        "endDate": "2020-07-11",
        "room": {
            "roomId": 1030,
            "roomType": "K",
            "roomRent": 20000
         }
}

Body of above Post Response :

{
    "timestamp": "2020-07-09T05:07:25.801+00:00",
    "status": 400,
    "error": "Bad Request",
    "trace": "test",
    "message": "This Room with Id 1005 not available",
    "path": "/api/bookings"
}

URL : http://localhost:8080/api/booking   -- Method : POST

Description : Above URL is for saving the Booking details, but below "End Date" is before "Start Date" 

Body of above Post Reqiest :

{
        "customer": {
            "firstName": "Dania",
            "lastName": "Dudi",
            "dateOfBirth": "1986-01-03",
            "email": "john_test@gmail.com",
            "password": "test123"
        },
        "startDate": "2020-07-09",
        "endDate": "2020-06-11",
        "room": {
            "roomId": 1030,
            "roomType": "K",
            "roomRent": 20000
         }
}


Body of above Post Response :

{
    "timestamp": "2020-07-09T05:07:25.801+00:00",
    "status": 400,
    "error": "Bad Request",
    "trace": "test",
    "message": "Correct the Reservation Dates",
    "path": "/api/bookings"
}



