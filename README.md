# Workshop 25

### Create an app that can send and receive and order from a redis server.
- Command prompt argument, if there is anything then we are receiving the order
- No args - we are pushing
### Sending Side takes a value from the dropdown list and selects order
- Retrieve a list of Strings from registration
- Webpage has an option to choose where to send the order to
- Sends over information in Json to the Redis Server
### Receiving side awaits the order details 
- Uses command line argument to choose where to listen in on
- Takes in the order from the Redis server and deserializes, adds the data to MySQL server
- Displays a page to show that the order is successful
