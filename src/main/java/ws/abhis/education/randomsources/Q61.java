package ws.abhis.education.randomsources;

import ws.abhis.education.throwawayUtils.Q61Commit;

/**
 * https://code.abhis.ws/Tech_Interviews/Algorithms_Maven/issues/61
 */
public class Q61 {

    private int getFirstBuggyCommit(final Q61Commit[] commits, int startIndex, int endIndex) {
        while (startIndex <= endIndex) {
            final int midIndex = startIndex + (endIndex - startIndex) / 2;
            if (commits[midIndex].isBuggy()) {
                if (!commits[midIndex-1].isBuggy()) {
                    return midIndex;
                }
                endIndex = midIndex - 1;
            } else if (!commits[midIndex].isBuggy()) {
                startIndex = midIndex + 1;
            }
        }
        return -1;
    }


    public String getFirstBuggyCommit(final Q61Commit[] commits) {
        return commits[getFirstBuggyCommit(commits, 0, commits.length-1)].getCommitId();
    }
}
