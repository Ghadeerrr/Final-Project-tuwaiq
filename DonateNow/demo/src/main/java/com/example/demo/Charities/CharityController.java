package com.example.demo.Charities;

import com.example.demo.Admin.Admin;
import com.example.demo.Donations.Donation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping(path= "charities")
public class CharityController {
    private final CharityService charityservice;

    @Autowired
    public CharityController(CharityService charityservice) {
        this.charityservice = charityservice;
    }

    //Get all charities
    @GetMapping
    public List<Charity> getCharities(){
        return charityservice.getCharities();
    }

    // get charity by ID
    @GetMapping("/{id}")
    public Charity getCharity(@PathVariable String id){
        return charityservice.getCharity(id);

    }

    @GetMapping ("/{id}/donations")
    public List<Donation> getCharityDonations(@PathVariable int id){
        return charityservice.getCharityDonations(id);
    }
    // to calcute
    @GetMapping("totalCharities")
    public int totalCharities(){
        return charityservice.getCharities().size();
    }

    //post or add charity
    @PostMapping
    public Charity createCharity(@RequestBody Charity charity){
        System.out.println(charity);
        return charityservice.createCharity(charity);
    }

    //post or add all charity
    @PostMapping ("/s")
    public List<Charity> addCharities(@RequestBody List<Charity> charities){
        charityservice.addCharities(charities);
        return getCharities();
    }

    //delete charity by ID
    @DeleteMapping("/{id}")
    public void deleteCharity(@PathVariable String id){
        charityservice.deleteCharity(id);
    }

    // use put to update charity
    @PutMapping("/{id}")
    public Charity updateCharity(@PathVariable String id, @RequestBody Charity data){
        return charityservice.updateCharity(id, data);
    }

    @GetMapping("byUser/{userid}")
    public Charity getCharityByUser(@PathVariable String userid){
        return charityservice.getCharityByUser(userid);
    }


}
