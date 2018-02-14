public class ArticleListFragment extends ListFragment {

private ArrayList<Article> mArticleList;
private Issue mIssue;
// Comment back in later //
private static final String TAG = "ArticleListFragment";
public static final String EXTRA_ID = "com.AnneMarieandAnisah.android.whatsnew.id";

public static ArticleListFragment newInstance(UUID id) {
    Bundle args = new Bundle();
    args.putSerializable(EXTRA_ID, id);
            Log.i(TAG, "getting Bundle in ArticleList");

    ArticleListFragment fragment = new ArticleListFragment();
    fragment.setArguments(args);
    return fragment;
}

@Override
public void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    getActivity().setTitle(R.string.articles_title);
    UUID issueId = (UUID)getActivity().getIntent().getSerializableExtra(EXTRA_ID); //get issue id from the Intent
            Log.i(TAG,"got issue id from intent");
    mIssue = IssueLab.get(getActivity()).getIssue(issueId); //create an issue object using the id
            Log.i(TAG,"creates issue from id");
    mArticleList = mIssue.getArticleList();
            Log.i(TAG,"gets article list from issue");

    ArticleAdapter adapter = new ArticleAdapter(mArticleList);
    setListAdapter(adapter);

}

@Override
public void onListItemClick(ListView l, View v, int position, long id) {
    Article c = ((ArticleAdapter)getListAdapter()).getItem(position);
    Uri webPageUri = Uri.parse(c.getLink());
    Intent i = new Intent(getActivity(), WebPageActivity.class);
    i.setData(webPageUri);
    startActivity(i);
    // send an intent to the browser fragment (which should be held in an activity (container))
    // add an Extra to the intent that holds the link
}


private class ArticleAdapter extends ArrayAdapter<Article> { //defines ArrayAdapter, needed for listing fragments
    public ArticleAdapter(ArrayList<Article> articles) {
        super(getActivity(), 0, articles);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if(convertView == null) {
            convertView = getActivity().getLayoutInflater().inflate(R.layout.list_article, null);
        }
        Article c = getItem(position);

        TextView titleTextView = (TextView)convertView.findViewById(R.id.article_list_titleTextView);
        titleTextView.setText(c.getTitle()); //sets the title of the list item to the article's title
                    TextView sourceTextView = (TextView)convertView.findViewById(R.id.article_list_sourceTextView);
                    sourceTextView.setText(c.getSource());

        return convertView;
    }
}

@Override
public void onResume() { //again, not sure if we actually need this. willing to delete
    super.onResume();
    ((ArticleAdapter)getListAdapter()).notifyDataSetChanged();
}

}
