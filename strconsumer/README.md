## _Kafka Challenge_ <br />
Using Kafka to notify customers when they pay bills using credit cards... 

## _Table of contents_

- [_Overview_](#overview)
- [_Requirements_](#requirements)
- [_Project Structure_](#requirements)
- [_Howto Build and Run_](#requirements)
- [_Screenshot_](#screenshot)
- [_Links_](...)
- [_Built with_](#built-with)
- [_Code Snippet_](#requirements)
- [_Continued development_](#continued-development)
- [_Useful resources_](#useful-resources)
- [_Author_](#requirements)
- [_Portfolio_](#requirements)

## _Overview_

Allow a retail store notify via email/SMS a customer who had paid any bill above a certain value.
<br />

## _Requirements_

Implement a listener that will consume JSON objects to trigger or not a notification.
<br />
The app has been coded using Java 21, Spring Boot 3.4.5, Maven, Javadoc, Jackson, Lombok, OpenAPI, Docker and hosted in an AWS EC2 instance with secure access provided
by a NGINX SSL proxy reverse and being live at <a href="https://tbd.ferreiras.dev.br/swagger-ui/index.html" target="_blank">Customer NotificationService</a> <br />
<br />
I will let you give it a try using these credentials to taste it: <br />
<b>username:</b> <i>example@example.com</i>, <b>password:</b> <i>example.com</i> <br />
<br />
Click at <a href="https://tbd.ferreiras.dev.br" target="_blank">CalculatorWeb-UI</a>, load 
these credentials, authenticate and get a credit of 100.00 to do your maths!<br />
Enjoy it....
<br />


## _Project Structure_
- docs
   - javadocs
- src
    - main
    - java
        - br.dev.ferreiras.kafka
            - config
            - resources
              - handlers 
            - dto
            - entity
            - enums
            - mapper
            - repository
            - services
              - exceptions
    - resources
        - db.migration
        - certs
    - test
-

## _Screenshot_

[![](./webCalculator.png)]()

## _Links_

- Live Site URL: <a href="https://tbd.ferreiras.dev.br/swagger-ui/index.html" target="_blank">Customer Notification Service</a>

## _Built with_

[![My Skills](https://skillicons.dev/icons?i=java,spring,kafka,mysql,maven,docker,redhat,aws,idea,git,github,)](https://skillicons.dev)

## _Code Snippet_

```java
package br.dev.ferreiras.kafka.strconsumer.listeners;

import br.dev.ferreiras.kafka.strconsumer.custom.StrConsumerCustomListener;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.stereotype.Component;

@Component
public class StrConsumerListener {

  private static final Logger logger = LoggerFactory.getLogger(StrConsumerListener.class);

  @StrConsumerCustomListener(groupId = "group-one")
  public void crete(String message) {

    logger.info("CREATE ::: Receive message {}", message);
  }
  
  @StrConsumerCustomListener(groupId = "group-one")
  public void log(String message) {

    logger.info("LOG ::: Receive message {}", message);
  }

  @StrConsumerCustomListener(groupId = "group-two")
  public void history(String message) {

    logger.info("HISTORY ::: Receive message {}", message);
  }
}


``` 

## _Continued development_

- Unit Tests 
- Provide a Json to FrontEnd including
    - delivery status of each operation to frontend 
    - count of operations consumed by subscriber 
- Subscriber Authentication 
    - Spring JWT-OAuth2 
- Messages Recovery 

### _Useful resources_

- [https://spring.io] Awesome Java framework!.
- [https://start.spring.io/]  Handy startup tool.
- [https://mvnrepository.com] Tools that help tackle the beast

## _Author_
<a href="mailto:ricardo@ferreiras.dev.br">Ricardo Ferreira</a>

## - _Portfolio_
<a href="https://www.ferreiras.dev.br" target="_blank">My Portfolio...</a>

