package com.gadomska.security;

import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class QuotationApi {

    private List<Quotation> quotations;

    public QuotationApi(){
        this.quotations = new ArrayList<>();
        quotations.add(new Quotation("The ability to delude yourself may be an important survival tool.", "Jane Wagner"));
        quotations.add(new Quotation("I never believed in Santa Claus because I knew no white dude would come into my neighborhood after dark.","Dick Gregory"));
    }

    @GetMapping("/api")
    public List<Quotation> getQuotations(){
        return quotations;
    }

    @PostMapping("/api")
    public boolean addQuotation(@RequestBody Quotation quotation){
        return quotations.add(quotation);
    }

    @DeleteMapping("/api")
    public void deleteQuotation(@RequestParam int index){
        quotations.remove(index);
    }
}
