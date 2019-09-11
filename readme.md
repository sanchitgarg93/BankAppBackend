This application forms the core part of the Alert Notification System. It contains all the functional rest end points.
The application can be tested using any Rest Client such as Postman. We have mentioned the the API specifications below for the same. Also you can import the collection file Bank.postman_collection and run it in your Postman.

**Application Flow:**

The customer makes the appointment using the API 2. The branch head gets the notification about the customer visiting the branch if the customer happens to be a high net worth individual.
The branch head also gets the reminder mail on the day, the customer is supposed to visit the branch.

The staff can view the list of appointments assigned to him/her using the API 3. The staff can also change the appointmnt status to ATTENDED or ABSENT using the API 4.

The branch head can view the list of appointments in his/her branch using the API 5. Can also re-assign the staff for a particular appointment using the API 6.

**App Url**: http://bankappbackend-env.ehbhe9ppne.us-east-2.elasticbeanstalk.com

If you want to run the application on the local system, then please ensure you meet the following software requirements.
1. Java 8 or higher must be installed
2. Open command prompt -> Change the directory where the file : **myapp-0.0.1-SNAPSHOT** is present.
3. Run the following command:  java -jar myapp-0.0.1-SNAPSHOT

Note: AWS RDS service MySQL instance and ElasticBeanstalk Free Tier is being used. Connectivity issues to it may impact the performance of the API's

Rest API's
API 1.  GET /customer/branches  -  List of branches displayed to the customer after selection of the name of the state and city
    Request Headers
    city : <city-name> Ex: BANGALORE
    state : <state-name> Ex: KARNATAKA
    No Authorization Required

API 2.  GET /customer/appointments  -  Customer making an appointment prior to the branch visit
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

API 3. GET /staff/appointments  - Staff viewing the appointments assigned to them
   Basic Authorization Required
   Username : staff1@gmail.com
   Password: 1234
   
API 4. PUT /staff/change_appintment_status  -  Change appointment Status
   Basic Authorization Required
   Username: staff1@gmail.com
   Password: 1234
   Request Body
   Type: application/json
   {
	    "id": "7",
	    "status" : "ATTENDED"
   }

API 5. GET /branch_head/find_branch_appointments - Branch Head - Get All appointments for the day
   Basic Authorization Required
   Username: sanchitgarg2012@gmail.com
   Password: 1234
   
API 6. PUT /branch_head/reassign_staff  -  Branch Head - Reassign Staff
   Basic Authorization Required
   Username: sanchitgarg2012@gmail.com
   Password: 1234
   Request Body
   Type : application/json
   {
	    "id" : "7",
	    "username" : "staff2@gmail.com"
   }

Note : API's for customer do not need any authorization

Please refer to the screenshots for more details.
