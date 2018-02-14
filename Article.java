public class Article { //this is a work in progress...we will have to tweak it when we figure out the articles problem

public UUID mId; //used to get an article
public String mTitle; //title of the article
public String mLink; //link to the article
    public String mSource; //news source of article
    public String mDate; //publication date


public Article(String title) {
    mId = UUID.randomUUID();
    mTitle = title;
}

public Article() {
    // TODO Auto-generated constructor stub
    mId = UUID.randomUUID();
}

public void setId(UUID id) {
    mId = id;
}

public void setLink(String link) {
    mLink = link;
}

    public String getTitle() {
    return mTitle;
}

public void setTitle(String title) {
    mTitle = title;
}

public UUID getId() {
    return mId;
}

public String getLink() {
    return mLink;
}

   public void setSource(String source) {mSource = source;}

   public String getSource() {return mSource;}

   public void setDate(String date) {mDate = date;}

   public String getDate() {return mDate;}

//To be commented out later after test is done 
    public String getDetails() {
    String result =  mTitle + "\n" + mLink;
    return result;
}

}
