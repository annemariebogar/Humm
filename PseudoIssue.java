//the PseudoIssue contains the name and id of the issue to relates to. The class connects the related issues list of each issue with the actual issues in the list

public class PseudoIssue {
private UUID mId;
private String mTitle; //name of the issue
private UUID mIssueId; //used to get issue

public PseudoIssue() {
    mId = UUID.randomUUID();
}

public PseudoIssue(String name, UUID id) {
    mId = UUID.randomUUID();
    mTitle = name;
    mIssueId = id;
}

public PseudoIssue(String name) {
    mId = UUID.randomUUID();
    mTitle = name;
}

public void setIssueId(UUID mIssueId) { this.mIssueId = mIssueId; }

public void setId(UUID mId) { this.mId = mId; }

public void setTitle(String mTitle) { this.mTitle = mTitle; }

public String getTitle() { return mTitle; }

public UUID getIssueId() { return mIssueId; }

public UUID getId() { return mId; }

public String toString() { return mTitle; }

}
