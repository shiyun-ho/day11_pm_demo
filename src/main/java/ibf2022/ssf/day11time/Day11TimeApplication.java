package ibf2022.ssf.day11time;


import java.util.Collections;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.DefaultApplicationArguments;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Day11TimeApplication {

	private static final Logger logger = LoggerFactory.getLogger(Day11TimeApplication.class);
	public static void main(String[] args) {
		SpringApplication app = new SpringApplication(Day11TimeApplication.class);

		String portNumber = "6081"; 

		ApplicationArguments appArg = new DefaultApplicationArguments(args); 
		if (appArg.containsOption("port")){
			portNumber = appArg.getOptionValues("port").get(0);
			logger.debug(">>>Customising port number " + portNumber);
		}

		if (args.length == 0){
			portNumber = System.getenv("port"); 
			
			if (!(portNumber == null || portNumber.isEmpty())){
				logger.debug(">>>Setting port number to System environment port: " + portNumber);
			}

			if (portNumber == null || portNumber.isEmpty()){
				portNumber = "6081"; 
				logger.debug(">>>Setting to default port number: " + portNumber);
			} 
		}
		
		// if ((args.length == 0) && (!(portNumber == null || portNumber.isEmpty()))){
		// 	portNumber = System.getenv("port"); 
		// 	logger.debug(">>>Setting port number to System environment port: " + portNumber);
		// }

		// else if ((args.length == 0) && (portNumber == null || portNumber.isEmpty())){
		// 		portNumber = "6081"; 
		// 		logger.debug(">>>Setting to default port number: " + portNumber);
		// }

        app.setDefaultProperties(Collections.singletonMap("server.port", portNumber));
        app.run(args);
		}
	}
	

	// //getlogger 
	// private static final Logger logger = LoggerFactory.getLogger(Day11TimeApplication.class);
	// //declare variables - portNumber
	// public int portNumber; 
	// //declare variable default port
	// public int defaultPort = 8080; 

	// public static void main(String[] args) {

	// 	//loop through argument keyed in command line
	// 	//provide debugging info
	// 	//use substring to find out port number
	// 	//use debug log to log it
	// 	for (String argVal : args) {
	// 		logger.debug("%i is contained in %i", argVal, args);

	// 	}

	// 	//if portNumber not set in command line, get environmental variable from system
	// 	//use debug log to track

	// 	//if still null, set to DEFAULT_PORT number

	// 	//instantiate new springapplication app
	// 	//set default properties to key value pair
	// 	//run app
	// 	SpringApplication app = new SpringApplication(Day11TimeApplication.class);
    //     app.setDefaultProperties(Collections.singletonMap("server.port", portNumber));
    //     app.run(args);

	// 	//SpringApplication.run(Day11TimeApplication.class, args);
	


