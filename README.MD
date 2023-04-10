# This project
## The database:
First I started a mysql database in docker because I'm 
used to working with that.

```docker run --detach --name lease-a-car -e MYSQL_ROOT_PASSWORD="AsavePasswordForYou" --publish 3306:3306 -d mysql:latest```

With this new database I was able to import the '.csv' files
with the interface of DBeaver.

## Setting up Spring boot
### Initializing
After import those filesI  created a Spring Boot project with the
spring initializer I found at: https://start.spring.io/
With a Mysql connector I was able to set up the project to
quickly create the entities (Relation, Vehicle and Interest).
After creating the entities I first started the server to
check if I was able to connect and find it on the api.
### Testing
using http://localhost:8080/api/vehicle/1 it showed the first car.

## Setting up OAuth2
When I was sure the api was working I wanted to add Oauth2 security. For a 
first test I did not want to set up my own Oauth2 server because I have no
experience with this. I chose the GitHub service as that was where I wanted to
send my code to anyway. To continue on this process There should be a separate 
server set up to handle this.

I struggled following the instructions I found online because ```WebSecurityConfigurerAdapter```
has been deprecated by last year February. After finding this issue I was quickly able to set
up the oauth page. Setting this up immediately gave me a login page on loading vehicle 1.

## Lease Rate

Finally I added the lease rate calculation, by handing in an id for the vehicle and interest rate you should
be able the calculate the rate.