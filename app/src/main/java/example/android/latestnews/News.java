package example.android.latestnews;

public class News {

    private String webTitle, webPublicationDate, webUrl;


    public News(String webTitle, String webPublicationDate, String webUrl) {
        this.webTitle = webTitle;
        this.webPublicationDate = webPublicationDate;
        this.webUrl = webUrl;
    }

    public String getWebPublicationDate() {
        return webPublicationDate;
    }

    public String getWebTitle() {
        return webTitle;
    }

    public String getWebUrl() {
        return webUrl;
    }
}
