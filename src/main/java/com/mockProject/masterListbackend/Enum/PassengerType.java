package com.mockProject.masterListbackend.Enum;

public enum PassengerType {

    Normal_User("Normal User"),
    Person_With_Disability("Person With Disability"),
    Journalist("Journalist");

    private final String displayName;
    PassengerType(String displayName){
        this.displayName=displayName;
    }
    public String getDisplayName(){
        return  displayName;
    }
    @Override
    public String toString(){
        return displayName;
    }
}
