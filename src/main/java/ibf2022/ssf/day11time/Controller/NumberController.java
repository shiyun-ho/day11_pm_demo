package ibf2022.ssf.day11time.Controller;

import java.security.SecureRandom;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

//annotates and tells springboot that this is a controller
@Controller
//narrows primary mapping by TXT_HTML_VALUE produced by mapped handler
@RequestMapping(path={"/", "/index.html"}, produces = MediaType.TEXT_HTML_VALUE)

public class NumberController {
    //Logger - get messages on the info of app (can be helpful for debugging)
    //getLogger allows us to access the Log Manager object
    //can find or create a log object named "NumberController.class"
    private Logger logger = Logger.getLogger(NumberController.class.getName()); 

    //GET /; GET /index.html
    //maps GET requests from HTTP GET requests to handler method
    @GetMapping
    public String getIndex(Model model){
        //generates a random number
        Random rand = new SecureRandom(); 
        //generates limits to the numbers of images
        int imgIndex = rand.nextInt(31);
        //URL to the string
        String imgUrl = "/numbers/number%d.jpg".formatted(imgIndex); 

        //logger will create a message which specify logs to be within INFO (informational message)
        logger.log(Level.INFO, imgUrl); 

        //bind the value to the model
        model.addAttribute("imgUrl", imgUrl);
        model.addAttribute("imgIndex", imgIndex);

        //render the template with the model
        return "index"; 
        
    }
}
