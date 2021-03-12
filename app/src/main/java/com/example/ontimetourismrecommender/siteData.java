package com.example.ontimetourismrecommender;

public class siteData {


    private String Name;
    private String Image;
    private String map;
    private String ID;
    public siteData( String Name, String Image, String map, String ID) {

        this.Name = Name;
        this.Image = Image;
        this.map=map;
        this.ID=ID;
    }
    public String getID() {
        return ID;
    }
    public String getName() {
        return Name;
    }
    public String getMap() {
        return map;
    }
    public String getImage() {
        return Image;
    }

}
