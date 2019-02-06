# Webflux Standalone Test

Usage:
<p> Clone the repo. </p>

<p>Set APPD_AGENT environment variable to agent install path</p>

<p>Adjust serviceUrl in StandaloneRemoteAndServiceHandler.java if neccesary.</p>

Run:
    `gradlew bootRun`

Then request:
   `http://{yourHost}/remote/person/firstName/{firstNameParam}/lastName/{lastNameParam}`

Expected:
- A business transaction will be created for /remote/person
- We have an exit call for the service request tracked to /service/person/{firstNameParam}/{lastNameParam}
- A business transaction will be created for /service/person

Nice to have:
- An business transaction will be created for /remote/person that automatically recognizes the parameterized request string.
- An business transaction will be created for /service/person that automatically recognizes the parameterized request string.
