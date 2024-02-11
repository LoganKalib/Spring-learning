package za.ac.cput.Controllers.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import za.ac.cput.Controllers.Models.Person;

import java.util.ArrayList;
import java.util.List;

//all controllers need this annotation
@Controller
public class helloControl {

    //get mapping says that the function gets rendered to the URL in the ()
    // if its only text being returned we add @ResponseBody
    @GetMapping("/test1")
    public String helloPage(Model model){
        // when we pass a model to a controller it allows is to insert data into the html page with the below command
        model.addAttribute("message","if this is working?");
        model.addAttribute("paragraph", "then time to get started");
        return "helloPage";
    }

    @GetMapping("/people")
    public String showPeople(Model model){

        List<Person> friends = new ArrayList<Person>();

        friends.add(new Person(0,"logan", 22, 68.4f));
        friends.add(new Person(1,"isha", 22, 72.7f));
        friends.add(new Person(2,"sheldon", 23, 85.2f));
        friends.add(new Person(3,"uzair", 25, 86.9f));
        friends.add(new Person(4,"natheer", 24, 71.3f));
        friends.add(new Person(5,"josh", 23, 74.9f));

        model.addAttribute("people", friends);

        return "peoplePage";
    }

    @GetMapping("/peopleJSON")
    @ResponseBody
    public List showPeopleJSON(Model model){

        List<Person> friends = new ArrayList<Person>();

        friends.add(new Person(0,"logan", 22, 68.4f));
        friends.add(new Person(1,"isha", 22, 72.7f));
        friends.add(new Person(2,"sheldon", 23, 85.2f));
        friends.add(new Person(3,"uzair", 25, 86.9f));
        friends.add(new Person(4,"natheer", 24, 71.3f));
        friends.add(new Person(5,"josh", 23, 74.9f));

        model.addAttribute("people", friends);

        return friends;
    }

}
