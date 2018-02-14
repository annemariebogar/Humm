public class IssueLab {
private static IssueLab sIssueLab;
private Context mAppContext;
private ArrayList mIssueList;
private static final String TAG = "IssueLab";
private IssueLab(Context appContext) {
setAppContext(appContext);
mIssueList = new ArrayList();

    //this part is just for the test run. It will not be relevant when we hook up the server to the app
    Article a = new Article();
    a.setTitle("Separatists in Ukraine Vow to Proceed With Autonomy Vote");
    a.setLink("http://www.nytimes.com/2014/05/09/world/europe/ukraine.html?partner=rss&emc=rss&_r=0");

    Article b = new Article();
    b.setTitle("In Odessa, Home-Grown Combatants Keep Pro-Russia Forces in Check");
    b.setLink("http://www.nytimes.com/2014/05/09/world/europe/odessa-ukrainians-keep-pro-russia-forces-in-check.html?partner=rss&emc=r)

    /*//this is where we need to parse JSON and get both the categories and the articles
    HTTPClient myClient = new DefaultHttpClient();
    HttpPost post = new HttpPost("storm.cis.fordham.edu/home/students/assim/public_html/humm/main.php");
    try{
        List<NameValuePair> myArgs = new ArrayList<NameValuePair>();
        myArgs.add(new BasicNameValuePair("username", "assim"));
        myArgs.add(new BasicNameValuePair("password", "yohcaew2"));
        post.setEntity(new UrlEncodedFormEntity(myArgs));
        HttpResponse myResponse = myClient.execute(post);
        BufferedReader br = new BufferedReader(new InputStreamReader(myResponse.getEntity().getContent()));
        StringBuilder sb = new StringBuilder();
        String line = "";
        while((line = br.readLine()) != null)
        {
            sb.append(line + "\n"); //get JSON from Web Server
        }
        //parse JSON object that we recieve from the server
        String response = sb.toString();
        JSONObject jObj = new JSONObject(response);
        JSONObject contentObj = null;
        JSONObject articleObj = null;
        JSONArray relatedArray = null;
        JSONArray articleArray = null;
        JSONArray contentArray = jObj.getJSONArray("content");
        for(int k=0; j<contentArray.length(); k++)
        {
            Issue issue = new Issue;
            contentObj = contentArray.getJSONObject(k);
            issue.setTitle(contentObj.getString("category_name"));
            issue.setNumber(k);
            relatedArray = contentObj.getJSONArray("related_topics_array");
            for(int j=0; j<relatedArray.length(); j++)
            {
                issue.addCategory(relatedArray.getString(j));
            }
            articleArray = contentObj.getJSONArray("list_of_articles");
            for(int m=0; m<articleArray.length(); m++)
            {
                Article article = new Article;
                articleObj = articleArray.getJSONObject(m);
                article.setTitle(articleObj.getString("title"));
                article.setLink(articleObj.getString("link"));
                article.setDate(articleObj.getString("date"));
                article.setSource(articleObj.getString("source"));
                issue.addArticle(article);
            }
            mIssueList.add(issue);
        }
    }
    catch (IOException e) {
        e.printStackTrace();
    }
    //changing all the strings in mcategorytags array (which only has the name of the related issues) to pseudoissues which contain both the name and the id of each issue
    Issue temp = new Issue;
    ArrayList<String> al = new ArrayList<String>();
    al.add(new String("Filler");
    for(int k=0; k<mIssueLab.length(); k++)
    {
        temp = mIssueList.get(k);
        al = temp.getMcategorytags();
        for(int j=0; j<al.length(); j++)
        {
            PseudoIssue pi = new PseudoIssue(al.get(j));
            for(int m=0; m<mIssueList.length(); m++)
            {
                if(al.get(j) == mIssueList.get(m).getTitle())
                {
                    pi.setIssueId(mIssueList.get(m).getId());
                }
            }
            mIssueList.get(k).addIssue(pi);
        }
    }


    */
             //this is also code just for the purpose of testing and will eventually be written out
     for (int k = 1; k < 9; k++) { //initializes the issues we have so far
            Issue c = new Issue();

            switch (k)  {
            case 1:
                c.setTitle("Ukraine"); 
                c.setNumber(k);
                c.setSummary("blah blah blah UKRAINE blah blah");
                    PseudoIssue temp1 = new PseudoIssue("Ukraine", c.getId());
                    c.addIssue(temp1);
                    c.addArticle(a);
                    Log.i(TAG,"article a added");
                c.addArticle(b);
                    Log.i(TAG,"article b added");
                break;
            case 2:
                c.setTitle("Syria"); 
                c.setNumber(k);
                c.setSummary("blah blah blah SYRIA blah blah");
                    PseudoIssue temp2 = new PseudoIssue("Syria", c.getId());
                    c.addIssue(temp2);
                break;
            case 3:
                c.setTitle("China"); 
                c.setNumber(k);
                c.setSummary("blah blah blah CHINA blah blah");
                    PseudoIssue temp3 = new PseudoIssue("China", c.getId());
                    c.addIssue(temp3);
                break;
            case 4:
                c.setTitle("Elections"); 
                c.setNumber(k);
                c.setSummary("blah blah blah ELECTIONS blah blah");
                    PseudoIssue temp4 = new PseudoIssue("Elections", c.getId());
                    c.addIssue(temp4);
                break;
            case 5:
                c.setTitle("Marijuana"); 
                c.setNumber(k);
                c.setSummary("blah blah blah MARIJUANA blah blah");
                    PseudoIssue temp5 = new PseudoIssue("Marijuana", c.getId());
                    c.addIssue(temp5);
                break;
            case 6:
                c.setTitle("Supreme Court"); 
                c.setNumber(k);
                c.setSummary("blah blah blah SUPREME COURT blah blah");
                    PseudoIssue temp6 = new PseudoIssue("Supreme Court", c.getId());
                    c.addIssue(temp6);
                break;
            case 7:
                c.setTitle("Israel/Palestine Conflict"); 
                c.setNumber(k);
                c.setSummary("blah blah blah ISRAEL/PALESTINE CONFLICT blah blah");
                    PseudoIssue temp7 = new PseudoIssue("Israel/Palestine", c.getId());
                    c.addIssue(temp7);
                break;
            case 8:
                c.setTitle("Affordable Health Care Act"); 
                c.setNumber(k);
                c.setSummary("blah blah blah AFFORDABLE HEALTH CARE ACT blah blah");
                    PseudoIssue temp8 = new PseudoIssue("Health Care", c.getId());
                    c.addIssue(temp8);
                break;
            }

            mIssueList.add(c);
        }
}

public static IssueLab get(Context c) {
    if(sIssueLab == null) {
        sIssueLab = new IssueLab(c.getApplicationContext());
    }
    return sIssueLab;
}

public ArrayList<Issue> getIssues() {
    return mIssueList;
}

public Issue getIssue(UUID id) {
    for (Issue c : mIssueList) {
        if(c.getId().equals(id))
            return c;
    }
    return null;
}

public Context getAppContext() {
    return mAppContext;
}

public void setAppContext(Context appContext) {
    mAppContext = appContext;
}

}
