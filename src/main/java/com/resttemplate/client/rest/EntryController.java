package com.resttemplate.client.rest;
import com.resttemplate.client.dto.AnimalsDTO;
import com.resttemplate.client.dto.CatFactDTO;
import com.resttemplate.client.dto.UniversitiesDTO;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;

@Controller
public class EntryController {

    @RequestMapping("/catFacts")
    @ResponseBody
    private String getEntries(){
        String uri = "https://catfact.ninja/fact";
        RestTemplate restTemplate = new RestTemplate();

        CatFactDTO catFactDTO = restTemplate.getForObject(uri, CatFactDTO.class);

        System.out.println(" Entry Data : " + catFactDTO.getFact());

        return "Cat Facts page";
    }

    @RequestMapping("/animals")
    @ResponseBody
    private String getAnimals(){
        String uri = "https://api.publicapis.org/entries";
        RestTemplate restTemplate = new RestTemplate();

        AnimalsDTO animalsDTO = restTemplate.getForObject(uri, AnimalsDTO.class);

        System.out.println(" Entry Data : " + animalsDTO.getCount());

        Arrays.stream(animalsDTO.getEntries()).forEach(n -> System.out.println(n.getAPI()));

        return "Animal Facts page";
    }

    @RequestMapping("/universities")
    @ResponseBody
    private String getUniversities(){
        String uri = "http://universities.hipolabs.com/search?country=United+States";
        RestTemplate restTemplate = new RestTemplate();

        UniversitiesDTO[] universitiesDTO = restTemplate.getForObject(uri, UniversitiesDTO[].class);

        String loopingContent = "";
        //Arrays.stream(universitiesDTO).forEach(n -> System.out.println(n.getName()));

        for(UniversitiesDTO universityDTO : universitiesDTO){
            loopingContent += "<tr><td>"+universityDTO.getName()+"</td><td>"+universityDTO.getProvince()+"</td><td>"+Arrays.toString(universityDTO.getWeb_pages()).replace("[", "").replace("]", "")+"</td><td>"+Arrays.toString(universityDTO.getDomains()).replace("[", "").replace("]", "")+"</td><td>"+universityDTO.getAlpha_two_code()+"</td></tr>";
        }

        //building simple out put
        String table =
        "<table><tr>" +
                "<th>Name</th>" +
                "<th>Province</th>" +
                "<th>Web</th>" +
                "<th>Domain</th>" +
                "<th>Alpha Code</th>" +
                "</tr>" +
                loopingContent +
                "</table>";

        return table;
    }
}
