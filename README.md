# Webflux Standalone Test

Set APPD_AGENT environment variable to agent install path
Adjust serviceUrl in StandaloneRemoteAndServiceHandler.java if neccesary.

Usage: 
    gradlew bootRun

Then request:
   http://{yourHost}/remote/person/firstName/{firstNameParam}/lastName/{lastNameParam}

Expected:
An AppD business transaction will be created for /remote/person
AppD will follow to the underlying request to /service/person/{firstNameParam}/{lastNameParam}
An AppD busines transaction will be created for /service/person

Nice to have:
An AppD business transaction will be created for /remote/person that automatically recognizes the parameterized request string.
An AppD busines transaction will be created for /service/person that automatically recognizes the parameterized request string.
