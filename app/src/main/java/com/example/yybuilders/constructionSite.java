package com.example.yybuilders;

import java.util.Map;

public class constructionSite {
    public bankingDetails bankingDetails;
    public construtionDetails construtionDetails;
    private Map<String, workDetails> workDetails;
    public com.example.yybuilders.bankingDetails getBankingDetails() {
        return bankingDetails;
    }

    public constructionSite() {
        // Default constructor required for Firebase
    }
    public void setBankingDetails(com.example.yybuilders.bankingDetails bankingDetails) {
        this.bankingDetails = bankingDetails;
    }

    public com.example.yybuilders.construtionDetails getConstrutionDetails() {
        return construtionDetails;
    }

    public void setConstrutionDetails(com.example.yybuilders.construtionDetails construtionDetails) {
        this.construtionDetails = construtionDetails;
    }

    public Map<String, com.example.yybuilders.workDetails> getWorkDetails() {
        return workDetails;
    }

    public void setWorkDetails(Map<String, com.example.yybuilders.workDetails> workDetails) {
        this.workDetails = workDetails;
    }



    public constructionSite(com.example.yybuilders.bankingDetails bankingDetails, com.example.yybuilders.construtionDetails construtionDetails, Map<String, com.example.yybuilders.workDetails> workDetails) {
        this.bankingDetails = bankingDetails;
        this.construtionDetails = construtionDetails;
        this.workDetails = workDetails;
    }




}
