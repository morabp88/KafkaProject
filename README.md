This project is a POC implementing real-time data processing with Kafka and Spring Boot, where a producer publishes events and a consumer subscribes to consume them, facilitating efficient event-driven communication.
It consists of KafkaProducer which is a springboot application that logs the event to Kafka Topic "user_activity_topic".
It also consists of a KafkaConsumer which is also a springboot application that reads the event by subscribing to the Kafka Topic "user_activity_topic".
To run the project locally:
***** Configure and run Kafka server - START *****
- Download Kafka from "https://kafka.apache.org/downloads" and unzip the downloaded file to a local location. Lets say that location is C:\. You can rename the unzipped folder as Kafka.
  ** from here on we will assume that you renamed your folder to "Kafka"
- Goto C:\kafka\config and locate zookeeper.properties file.
   Open this file, and ensure that dataDir=C:\Kafka.
- Goto C:\kafka\config and locate server.properties file and update log.dirs path to "C:/<any location you prefer>)
- Open your terminal and navigate to Kafka folder on the prompt. Run the command
  .\bin\windows\zookeeper-server-start.bat .\config\zookeeper.properties
- Open a second terminal , navigate to Kafka folder on the prompt and run the below command:
  .\bin\windows\kafka-server-start.bat .\config\server.properties
- Your Kafka instance is ready to be used.
***** Configure and run Kafka server - END *****

***** Publish events to Kafka Topic - START *****
- Run the springboot application "KafkaProducer" which will create a topic named "user_activity_topic" designed to log an event consisting of userid, event type and date.
- Hit the endpoint with below request - "POST http://localhost:8081/user/activity"
  Content-Type: application/json
  
  {
    "userId": "1234",
    "eventType": "Login 2",
    "timestamp": "03-24-2024"
  }
 Your kafka topic will now have one event waiting to be read.
NOTE: If you read this event via terminal, then the offset of this message will be updated and it will not be available for consumption for the consumer (as the offset will lead the consumer to believe that the 
       event was already read.
***** Publish events to Kafka Topic - End *****

  ***** Consume events from Kafka Topic - START *****
- Run the springboot application "KafkaConsumer which will subscribe and read the events from the topic -  "user_activity_topic".
THATS IT!

***** Consume events from Kafka Topic - START *****



   
