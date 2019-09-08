This application forms the core part of the Alert Notification System. It contains all the functional rest end points.
The application can be tested using any Rest Client such as Postman. We have mentioned the the API specifications below for the same. Also you can import the collection file Bank.postman_collection and run it in your Postman.

Before running the application, please ensure you meet the following software requirements.
1. Java 8 or higher must be installed
2. MySQL instance should be running.
3. Create a database "bankapp"
4. Open command prompt -> Change the directory where the file : **myapp-0.0.1-SNAPSHOT** is present.
5. Run the following command:  java -jar myapp-0.0.1-SNAPSHOT


App URL: **localhost:8080**

Rest API's
1.  GET /customer/branches  -  List of branches displayed to the customer after selection of the name of the state and city
    Request Headers
    city : <city-name> Ex: BANGALORE
    state : <state-name> Ex: KARNATAKA
    No Authorization Required

2.  GET /customer/appointments  -  Customer making an appoinment prior to the branch visit
    Request Body
    Type: application/json
    {
      "phone":"9999209435",
      "name":"Dan",
      "branchName":"Chickpet",
      "purpose":"Digital Banking services",
      "subPurpose":"Internet Banking Activate",
      "date":"2019-09-22"
    }
    No Authorization Required

3. GET /staff/appointments  - Staff viewing the appointments asssigned to them
   Basic Authorization Required
   Username : staff1@gmail.com
   Password: 1234
   
4. PUT /staff/change_appintment_status  -  Change appointment Status
   Basic Authorization Required
   Username: staff1@gmail.com
   Password: 1234
   Request Body
   Type: application/json
   {
	    "id": "7",
	    "status" : "ATTENDED"
   }

5. GET /branch_head/find_branch_appointments - Branch Head - Get All appointments for the day
   Basic Authorization Required
   Username: sanchitgarg2012@gmail.com
   Password: 1234
   
6. PUT /branch_head/reassign_staff  -  Branch Head - Reassign Staff
  Basic Authorization Required
   Username: sanchitgarg2012@gmail.com
   Password: 1234
   Request Body
   Type : application/json
   {
	    "id" : "7",
	    "username" : "staff2@gmail.com"
   }
