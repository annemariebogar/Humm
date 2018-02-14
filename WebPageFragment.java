public class WebPageFragment extends Fragment {
private String mUrl;
private WebView mWebView;

@Override
public void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setRetainInstance(true);

    mUrl = getActivity().getIntent().getData().toString(); //gets URL from ArticleListFragment intent
}

@SuppressLint("SetJavaScriptEnabled")
@Override
public View onCreateView(LayoutInflater inflater, ViewGroup parent, Bundle savedInstanceState) {
    View v = inflater.inflate(R.layout.fragment_web_page, parent, false);

    mWebView = (WebView)v.findViewById(R.id.webView);

    mWebView.getSettings().setJavaScriptEnabled(true);

    mWebView.setWebViewClient(new WebViewClient() {
        public boolean shouldOverrideUrlLoading(WebView view, String url) {
            return false;
        }
    });

    mWebView.loadUrl(mUrl);

    return v;
}

}
