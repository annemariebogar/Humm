public class IssueFragment extends Fragment {

public static final String EXTRA_ISSUE_ID = "com.AnneMarieandAnisah.android.whatsnew.issue_id";

private Issue mIssue;
private TextView mTitle;
private Button mReadMoreButton;
private TextView mSummary;
    private TextView mRelatedTopics;
    private GridView mGridView;
private ArrayList<PseudoIssue> mIssueList;

@Override
public void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    getActivity().setTitle(R.string.summary_title); // sets title of the page (next to little green dude)
    UUID issueId = (UUID)getArguments().getSerializable(EXTRA_ISSUE_ID); // gets the id from IssueListFragment
    mIssue = IssueLab.get(getActivity()).getIssue(issueId); //uses id to get the actual issue
            mIssueList = mIssue.getRelatedList();
}

@Override
public View onCreateView(LayoutInflater inflater, ViewGroup parent, Bundle savedInstanceState) {
    View v = inflater.inflate(R.layout.fragment_issue, parent, false);

    mTitle = (TextView)v.findViewById(R.id.issue_title);
    mTitle.setText(mIssue.getTitle()); //sets title of specific page to the issue's title

    mSummary = (TextView)v.findViewById(R.id.issue_summary);
    mSummary.setText(mIssue.getSummary()); // sets text of summary to the issue's summary

    mReadMoreButton = (Button)v.findViewById(R.id.issue_read_more);
    mReadMoreButton.setOnClickListener(new View.OnClickListener() {

        @Override
        public void onClick(View v) {

            Intent i = new Intent(getActivity(), ArticleListActivity.class); //sends intent to the Article list
            i.putExtra(ArticleListFragment.EXTRA_ID, mIssue.getId()); //sends the issue id with the intent
            startActivity(i); //starts the Article list activity
        }
    });

    mRelatedTopics = (TextView)v.findViewById(R.id.issue_related_topics);

    mGridView = (GridView)v.findViewById(R.id.issue_gridView); //GridView holds the pseudoIssues that correspond to the related issues
    setupAdapter();
    mGridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
        @Override
        public void onItemClick(AdapterView<?> adapterView, View view, int pos, long id) {
            PseudoIssue pIssue = mIssueList.get(pos);
            Intent i = new Intent(getActivity(), IssuePagerActivity.class); //sends intent to the Pager Activity with the issue id
            i.putExtra(IssueFragment.EXTRA_ISSUE_ID, pIssue.getIssueId());
            startActivity(i); // starts the new activity
        }
    });

    return v;
}

void setupAdapter() {
    if(getActivity() == null || mGridView == null) return;

    if(mIssueList != null) {
        mGridView.setAdapter(new ArrayAdapter<PseudoIssue>(getActivity(), android.R.layout.simple_gallery_item, mIssueList));
    } else {
        mGridView.setAdapter(null);
    }
}

public static IssueFragment newInstance(UUID issueId) { //I don't think we actually need this, but I am always hesitant to delete
    Bundle args = new Bundle();
    args.putSerializable(EXTRA_ISSUE_ID, issueId);

    IssueFragment fragment = new IssueFragment();
    fragment.setArguments(args);

    return fragment;
}

}
