## Experimental AWS lambda Java app

### Build
./gradlew build

AWS Lambda package will be created in folder build/distributions/expapp-XYZ.zip. File will contain all dependencies required to run lambda.
 
**Handler**: _com.github.lzenczuk.aws.lambda.expapp.handler.GreetingHandler::hello_