product-service
===============
This is the sample REST Spring boot microservice application written for the Pivotal Cloud Foundry. This application uses the Spring Cloud for different services required in microservice based architecture. This application connects to the database and returns the basic product information. This application connects to product-price-service to get the product price information.

This application uses following features / services in the Pivotal Cloud Foundry:

### Spring Cloud Connectors 
This application uses Spring Cloud Connectors to discover service binded services and connectivity to the MySql or RabbitMQ when services are binded in Cloud Foundry. 

### Database 
This application uses the in-memory h2 database if MySql service is not binded and uses the MySql if service is binded in Cloud Foundry.

### REST Client 
This application uses the RestTemplate and Feign Client. Comment out the code to switch between the client you want to use. 

### Client Side Load Balancing
This application uses the Netflix Ribbon for the client side load balancing

### Fault Tolerance
This application uses the Circuit Breaker Dashboard service of Pivotal Cloud Foundry which internally uses the Netflix Hystrix for circuit breaker and fault tolerance. It uses the fallback mechanism if calling service is not available. 

### Service Discovery 
This application uses Service Discovery service of Pivotal Cloud Foundry which internally uses the Netflix Eureka and provides the rich features for example service registration method (registrationMethod) of direct which registers the container’s IP address in the service registry instead of public route for direct service to service (container to container) communication. This feature is handy for the internal service communication instead of service call go out to the public internet and back to the service. 

### Auto Scaling
This application uses the Autoscaling service of Pivotal Cloud Foundry. Autoscaling provides the rich features of auto scaling based of different rules defined in Portal.

### Distributed Tracing
This application uses the Spring Cloud Sleuth to enable the Zipkin distributed tracing. 

### Container to Container Networking
For service to service call, this application uses the direct container to container communication for the service calls with the Cloud Foundry. This communication is useful for service to service call inside Cloud Foundry instead of call going out through internet. 

## Running application inside Pivotal Cloud Foundry
### Service Binding
Service binding is defined in the manifest.yml file. Create the following services inside the Cloud Foundry with the name provided as below:

* `ClearDb` service name: `ostore-db`
* `Service Registry` service name: `ostore-service-registry`
* `Circuit Breaker` service name: `ostore-circuit-breaker-dashboard`
* `CloudAMQP` service name: `ostore-rabbitmq`
* `App Autoscaler` service name: `ostore-autoscaler`

### Route
Service doesn’t have the public route defined as service is intended to be called by the API Gateway. To create the route, enable the route in the manifest.yml file or in the push command. 

### Network Policy for the Container to Container Networking 
To setup network access of product service call to product price service run the following command:
`cf allow-access product-service product-price-service --protocol tcp --port 8080`
To run this command, you need to have the Cf CLI Network Plugin installed. 

### Push the application
After creating the services push the application using the `cf push` command. 

