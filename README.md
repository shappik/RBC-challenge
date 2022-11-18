# RBC-challenge

The proposed solution in a Spring Boot application, using REST API, H2 Database, OpenCSV

Installation instructions:

Run maven build using JDK 8 Command example: mvn clean install

Run Sping Boot Application command example: mvn spring-boot:run

Use Postman to run the REST API commands:

Add a new record
----------------

POST method: http://localhost:8080/stocks

Body:
{
        "id": 6,
        "quarter": "1",
        "stock": "AA",
        "date": "1/7/2011",
        "open": "$15.82",
        "high": "$16.72",
        "low": "$15.78",
        "close": "$16.42",
        "volume": "239655616",
        "percent_change_price": "3.79267",
        "percent_change_volume_over_last_wk": "",
        "previous_weeks_volume": "",
        "next_weeks_open": "$16.71",
        "next_weeks_close": "$15.97",
        "percent_change_next_weeks_price": "-4.42849",
        "days_to_next_dividend": "26",
        "percent_return_next_dividend": "0.182704"
    }

Example result:

{
    "id": 6,
    "quarter": "1",
    "stock": "AA",
    "date": "1/7/2011",
    "open": "$15.82",
    "high": "$16.72",
    "low": "$15.78",
    "close": "$16.42",
    "volume": "239655616",
    "percent_change_price": "3.79267",
    "percent_change_volume_over_last_wk": "",
    "previous_weeks_volume": "",
    "next_weeks_open": "$16.71",
    "next_weeks_close": "$15.97",
    "percent_change_next_weeks_price": "-4.42849",
    "days_to_next_dividend": "26",
    "percent_return_next_dividend": "0.182704"
}

Upload a bulk data set
----------------------

POST method: http://localhost:8080/upload

Body:

form-data  (Key -> filename, Key type: File;    value -> dow_jones_index.data)

Example result:

Success



Query for data by stock ticker (e.g. input: AA, would return 12 elements if the only data uploaded were the single data set above)
------------------------------

Get method method: http://localhost:8080/stocks/AA

Example result:

[
    {
        "id": 1,
        "quarter": "1",
        "stock": "AA",
        "date": "1/7/2011",
        "open": "$15.82",
        "high": "$16.72",
        "low": "$15.78",
        "close": "$16.42",
        "volume": "239655616",
        "percent_change_price": "3.79267",
        "percent_change_volume_over_last_wk": "",
        "previous_weeks_volume": "",
        "next_weeks_open": "$16.71",
        "next_weeks_close": "$15.97",
        "percent_change_next_weeks_price": "-4.42849",
        "days_to_next_dividend": "26",
        "percent_return_next_dividend": "0.182704"
    },
    {
        "id": 2,
        "quarter": "1",
        "stock": "AA",
        "date": "1/14/2011",
        "open": "$16.71",
        "high": "$16.71",
        "low": "$15.64",
        "close": "$15.97",
        "volume": "242963398",
        "percent_change_price": "-4.42849",
        "percent_change_volume_over_last_wk": "1.380223028",
        "previous_weeks_volume": "239655616",
        "next_weeks_open": "$16.19",
        "next_weeks_close": "$15.79",
        "percent_change_next_weeks_price": "-2.47066",
        "days_to_next_dividend": "19",
        "percent_return_next_dividend": "0.187852"
    },
    {
        "id": 4,
        "quarter": "1",
        "stock": "AA",
        "date": "1/7/2011",
        "open": "$15.82",
        "high": "$16.72",
        "low": "$15.78",
        "close": "$16.42",
        "volume": "239655616",
        "percent_change_price": "3.79267",
        "percent_change_volume_over_last_wk": "",
        "previous_weeks_volume": "",
        "next_weeks_open": "$16.71",
        "next_weeks_close": "$15.97",
        "percent_change_next_weeks_price": "-4.42849",
        "days_to_next_dividend": "26",
        "percent_return_next_dividend": "0.182704"
    }
]




