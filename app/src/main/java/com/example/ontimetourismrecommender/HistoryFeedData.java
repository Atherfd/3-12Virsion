package com.example.ontimetourismrecommender;

public class HistoryFeedData {

    private int rating;
    private String Name;
    private String Image;
    private String SiteId;
    public HistoryFeedData( String Name, String Image, int rating, String SiteId) {

        this.Name = Name;

        this.rating = rating;
        this.Image = Image;
        this.SiteId=SiteId;
    }
public String getSiteId(){


        return SiteId;
}

    public String getName() {
        return Name;
    }

    public int getRating() {
        return rating;
    }


    public String getImage() {
        return Image;
    }

}
