package com.example.demoForm;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.client.RestOperations;
import org.springframework.web.client.RestTemplate;


@Controller
public class GreetingController {

    private static final Logger log = LoggerFactory.getLogger(DemoFormApplication.class);
    private RestOperations restTemplate;
    //private RestTemplate restTemplate;

//    @Bean
//    public RestTemplate restTemplate(RestTemplateBuilder builder) {
//        return builder.build();
//    }

    @GetMapping("/greeting")
    public String greeting(@RequestParam(name="name", required=false, defaultValue="World") String name, Model model) {
        model.addAttribute("name", name);
        return "greeting";
    }

    @GetMapping("/cancelUrl")
    public String cancelUrl(@RequestParam(name="name", required=false, defaultValue="Cancelled") String name, Model model) {
        model.addAttribute("name", name);
        return "cancelled";
    }

    @GetMapping("/successful")
    public String successful(@RequestParam(name="name", required=false, defaultValue="Cancelled") String name, Model model) {
        model.addAttribute("name", name);
        return "successful";
    }

    @GetMapping("/api")
    public String api() {
//        Subscription subscription = this.restTemplate.getForObject("http://www.google.com",Subscription.class);
//        Subscription subscription = restTemplate.getForObject(
//					"https://api.payfast.pf.schalk/subscriptions/7bfce38d-5103-4133-a64b-a16033bdb538", Subscription.class);
//			log.info(subscription.toString());

        final var restTemplate = new RestTemplate();
        final var username = "admin";
        final var password = "pass";
        final var url = "https://someapi.net/rest/api/2/issue/";
        var headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.setBasicAuth(username, password);
        //header will look like 'Authorization: Basic QWxhZGRpbjpvcGVuIHNlc2FtZQ==' ('username:password' with Base64)
        var fieldsFromInputObject = new FieldsFromInputObject();
        fieldsFromInputObject.setSummary("REST ye merry gentlemen.");
        //here set another fields
        var inputObject = new InputObject();
        inputObject.setFields(fields);
        var request = new HttpEntity<>(inputObject, headers);
        var response = restTemplate.postForObject(url, request, String.class);
        //instead object you can use your serialized JSON
        //last parameter determines a class of the response


        return "api";
    }


}