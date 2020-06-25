package com.company.person;

public enum Parameters {
    NAME("name"),
    SURNAME("surname"),
    BIRTHPLACE("birthplace");
    private String choice;
Parameters(String choice){
this.choice = choice;
}

    public String getChoice() {
        return choice;
    }
}
