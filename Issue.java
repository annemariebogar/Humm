public class Issue {

private UUID mId; //used to get issues
private String mTitle; //title of the issue
private String mSummary; //summary of the issue
private int mNumber; //hopefully useful when issues are no longer static -> easy to identify without needing the name
public ArrayList<Article> mArticleList; //list of articles that pertain to the issue
public ArrayList<String> mcategorytags; //purely for parsing JSON objects
    public ArrayList<PseudoIssue> mRelatedList; //list of related issues

public Issue() {
    mId = UUID.randomUUID();
    mArticleList = new ArrayList<Article>();
    mArticleList.add(new Article("Filler"));
    mcategorytags = new ArrayList<String>();
            mcategorytags.add(new String("Filler"));
            mRelatedList = new ArrayList<PseudoIssue>();
            mRelatedList.add(new PseudoIssue());
}

public ArrayList<Article> getArticleList() {
    return mArticleList;
}

public void setArticleList(ArrayList<Article> articleList) {
    mArticleList = articleList;
}

public void addArticle(Article a){
    mArticleList.add(a);
}

public ArrayList<String> getMcategorytags() {
    return mcategorytags;
}

public void setMcategorytags(ArrayList<String> mcategorytags) {
    this.mcategorytags = mcategorytags;
}

   public void addCategory(String s) {mcategorytags.add(s); }

   public ArrayList<PseudoIssue> getRelatedList() {return mRelatedList; }

   public void setRelatedList(ArrayList<PseudoIssue> issueList) { mRelatedList = issueList; }

   public void addIssue(PseudoIssue i) {mRelatedList.add(i); }

public String getTitle() {
    return mTitle;
}
public void setTitle(String title) {
    mTitle = title;
}
public String getSummary() {
    return mSummary;
}
public void setSummary(String summary) {
    mSummary = summary;
}
public UUID getId() {
    return mId;
}

public int getNumber() {
    return mNumber;
}

public void setNumber(int number) {
    mNumber = number;
}

}
