package com.mockProject.masterListbackend.Enum;

public enum Berth {
    Upper("Upper"),
    Middle("Middle"),
    Lower("Lower"),
    No_Preference("No Preference");

    private final String displayName;

    Berth(String displayName){
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
