package com.mockProject.masterListbackend.Enum;

public enum Food {

    VEG("VEG"),
    NON_VEG("NON-VEG"),
    NO_FOOD("NO FOOD");

    private final String displayName;
    Food(String displayName){
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
