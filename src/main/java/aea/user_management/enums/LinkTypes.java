package aea.user_management.enums;

public enum LinkTypes {

    GITHUB("","گیت هاب"),
    APARAT("","آپارات"),
    YOUTUBE("","یوتوب");

    private final String value;
    private final String description;

    private LinkTypes (String value,String description){
        this.value =value;
        this.description=description;
    }

    private String getValue(){
        return value;
    }

    private String getDescription(){
        return description;
    }


}
