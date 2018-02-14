public class IssueListFragment extends ListFragment {

private ArrayList<Issue> mIssues; 
public ArrayList<Article> articlelist; 
private static final String TAG = "IssueListFragment";
public static ArrayList<Article> tempList = new ArrayList<Article>();

@Override
public void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setHasOptionsMenu(true);
    getActivity().setTitle(R.string.issues_title); // sets the title of the page (next to the little green dude)
    mIssues = IssueLab.get(getActivity()).getIssues(); // mIssues is an ArrayList identical to the one in IssueLab
    IssueAdapter adapter = new IssueAdapter(mIssues);
    setListAdapter(adapter);
    Log.i(TAG,"something");

}


@Override
public void onListItemClick(ListView l, View v, int position, long id) {
    Issue c = ((IssueAdapter)getListAdapter()).getItem(position);

    Intent i = new Intent(getActivity(), IssuePagerActivity.class); //sends intent to the Pager Activity with the issue id
    i.putExtra(IssueFragment.EXTRA_ISSUE_ID, c.getId());
    startActivity(i); // starts the new activity
}

private class IssueAdapter extends ArrayAdapter<Issue> { // defines the class IssueAdapter
    public IssueAdapter(ArrayList<Issue> issues) {
        super(getActivity(), 0, issues);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if(convertView == null) {
            convertView = getActivity().getLayoutInflater().inflate(R.layout.list_issue, null);
            // corresponds to list_issue.xml
        }
        Issue c = getItem(position);

        TextView titleTextView = (TextView)convertView.findViewById(R.id.issue_list_titleTextView);
        titleTextView.setText(c.getTitle()); //sets text of each list item with the title of the issue

        return convertView;
    }
}

    //attempt to create search option - will work on this later after the app is connected to server
@Override
@TargetApi(11)
public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
    super.onCreateOptionsMenu(menu, inflater);
    inflater.inflate(R.menu.fragment_issue_list, menu);
    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.HONEYCOMB) {
        // pull out the SearchView
        MenuItem searchItem = menu.findItem(R.id.menu_item_search);
        SearchView searchView = (SearchView)searchItem.getActionView();

        // get the data from our searchable.xml as a SearchableInfo
        SearchManager searchManager = (SearchManager)getActivity()
            .getSystemService(Context.SEARCH_SERVICE);
        ComponentName name = getActivity().getComponentName();
        SearchableInfo searchInfo = searchManager.getSearchableInfo(name);

        searchView.setSearchableInfo(searchInfo);
    }
}

@Override
public boolean onOptionsItemSelected(MenuItem item) {
    switch(item.getItemId()) {
        case R.id.menu_item_search:
            getActivity().onSearchRequested();
            return true;
        case R.id.menu_item_clear:
            return true;
        default:
            return super.onOptionsItemSelected(item);
    }
}

@Override
public void onResume() {
    super.onResume();
    ((IssueAdapter)getListAdapter()).notifyDataSetChanged();
    // the adapter is notified of any change done to the issue (there is no change. this was just from criminal intent that
    // I literally just copied and pasted. I may just take this out
}



//don't think we need this - will delete later  
  public ArrayList<Article> SearchCategories(String SearchTerm) {
      ArrayList<Article> SearchList = new ArrayList<Article>();
      for(int z = 0; z<mIssues.size(); z++){
            Issue y = mIssues.get(z);
            ArrayList<String> b = y.getMcategorytags();

            for(int c = 0; c<b.size(); c++){
                String d = b.get(c);
                if (d == SearchTerm){
                SearchList.addAll(y.getArticleList()) ;
                }

            }

      }
  return SearchList;
  }

}
