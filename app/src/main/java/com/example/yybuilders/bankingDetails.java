package com.example.yybuilders;

public class bankingDetails {
    public String bank_name;
    public String amount;
    public String paid_or_not;

    public bankingDetails(String bank_name, String amount, String paid_or_not) {
        this.bank_name = bank_name;
        this.amount = amount;
        this.paid_or_not = paid_or_not;
    }
    public bankingDetails()
    {}

    public String getBank_name() {
        return bank_name;
    }

    public void setBank_name(String bank_name) {
        this.bank_name = bank_name;
    }

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }

    public String getPaid_or_not() {
        return paid_or_not;
    }

    public void setPaid_or_not(String paid_or_not) {
        this.paid_or_not = paid_or_not;
    }
}
