Run the following step to reproduce the error

- Clone the project
- modify .env file to add your IP for KAFKA ADVERTISED_HOST and add DIR to map SFTP location to your machine folder
- Move data file from ./data to dir you mentioned above

- Run docker-compose up -d :-> should start SFTP container KAFKA container and ZOOKEEPER container
- Run ./mvnw spring-boot:run :-> should pull the file from above mentioned directory back to ./data folder and should print following lines 


2018-08-14 19:50:29.266  INFO 70271 --- [ask-scheduler-1] tpSource$$EnhancerBySpringCGLIB$$6aa6212 : Received line : 622,538686012,605,97,2018-05-07 09:05:35,37
2018-08-14 19:50:29.267  INFO 70271 --- [ask-scheduler-1] tpSource$$EnhancerBySpringCGLIB$$6aa6212 : Received line : 622,549255822,605,97,2018-05-07 09:05:35,1
2018-08-14 19:50:29.269  INFO 70271 --- [ask-scheduler-1] tpSource$$EnhancerBySpringCGLIB$$6aa6212 : Received line : 622,5409871,605,97,2018-05-07 09:05:35,17
2018-08-14 19:50:29.270  INFO 70271 --- [ask-scheduler-1] tpSource$$EnhancerBySpringCGLIB$$6aa6212 : Received line : 622,5712221,605,97,2018-05-07 09:05:35,7
2018-08-14 19:50:29.271  INFO 70271 --- [ask-scheduler-1] tpSource$$EnhancerBySpringCGLIB$$6aa6212 : Received line : 622,5434815,605,97,2018-05-07 09:05:35,25



Following is the error:

Compare the File in ./data folder to the Values on Kafka Topic and Log file (like shown above)

- file has 10 lines, 
- Data from the  Odd number lines i.e 1,3,5,7,9 appears on LOG as received.
- Data from the Even number lines i.e 2,4,6,8,10 appears on KAFKA Topic.

Not sure what's wrong?


