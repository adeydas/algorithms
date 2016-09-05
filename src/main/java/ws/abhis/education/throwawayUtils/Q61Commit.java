package ws.abhis.education.throwawayUtils;

/**
 * https://code.abhis.ws/Tech_Interviews/Algorithms_Maven/issues/61
 */
public class Q61Commit {
    private String commitId;
    private boolean isBuggy;

    public Q61Commit(final String commitId, final boolean isBuggy) {
        this.commitId = commitId;
        this.isBuggy = isBuggy;
    }

    public boolean isBuggy() {
        return isBuggy;
    }

    public void setBuggy(boolean buggy) {
        isBuggy = buggy;
    }

    public String getCommitId() {
        return commitId;
    }

    public void setCommitId(String commitId) {
        this.commitId = commitId;
    }
}
