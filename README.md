Run the following step to reproduce the error

1. Clone the project
2. modify .env file to add your IP for KAFKA ADVERTISED_HOST and add DIR to map SFTP location to your machine folder
3. Move data file from ./data to dir you mentioned above

4. Run docker-compose up -d :-> should start SFTP container KAFKA container and ZOOKEEPER container
5. Run ./mvnw spring-boot:run :-> should pull the file from above mentioned directory back to ./data folder and should print following lines 


- 2018-08-14 19:50:29.266  INFO 70271 --- [ask-scheduler-1] tpSource$$EnhancerBySpringCGLIB$$6aa6212 : Received line : 622,538686012,605,97,2018-05-07 09:05:35,37
- 2018-08-14 19:50:29.267  INFO 70271 --- [ask-scheduler-1] tpSource$$EnhancerBySpringCGLIB$$6aa6212 : Received line : 622,549255822,605,97,2018-05-07 09:05:35,1
- 2018-08-14 19:50:29.269  INFO 70271 --- [ask-scheduler-1] tpSource$$EnhancerBySpringCGLIB$$6aa6212 : Received line : 622,5409871,605,97,2018-05-07 09:05:35,17
- 2018-08-14 19:50:29.270  INFO 70271 --- [ask-scheduler-1] tpSource$$EnhancerBySpringCGLIB$$6aa6212 : Received line : 622,5712221,605,97,2018-05-07 09:05:35,7
- 2018-08-14 19:50:29.271  INFO 70271 --- [ask-scheduler-1] tpSource$$EnhancerBySpringCGLIB$$6aa6212 : Received line : 622,5434815,605,97,2018-05-07 09:05:35,25



Following is the error:

Compare the File in ./data folder to the Values on Kafka Topic and Log file (like shown above)

- file has 10 lines, 
- Data from the  Odd number lines i.e 1,3,5,7,9 appears on LOG as received.
- Data from the Even number lines i.e 2,4,6,8,10 appears on KAFKA Topic.

Expecting,
- all 10 lines to be in LOG
- all 10 lines to be on KAFKA topic

Not sure what's wrong?


UPDATE:
Issue is the Source.Output is a Direct Channel bound by the Binders Producer to send the data from Output Channel onto Binder.
And the Code is Subscribed to Source.Output Channel as well to log whats going on Binder using @StreamListener(Source.OUTPUT).

So now when SFTP SOurce App reads from File and writes to Source.Output the data alternates between the Code and Binder's producer. Code writes Data to Log and Binder's Produce writes onto Binder in round-robin fashion.

Solution:
Option 1: Instead of listening to the Source.output WireTap OutPut channel to another Direct Channel and listen to new Direct Channel using @ServiceActivator instead of @StreamListener

