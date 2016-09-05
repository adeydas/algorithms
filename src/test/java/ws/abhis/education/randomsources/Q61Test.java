package ws.abhis.education.randomsources;

import org.junit.Before;
import org.junit.Test;
import ws.abhis.education.throwawayUtils.Q61Commit;

import static org.junit.Assert.*;


public class Q61Test {
    private Q61Commit[] commits;
    private Q61 q61;

    @Before
    public void setup() {
        q61 = new Q61();
        commits = new Q61Commit[3];
        commits[0] = new Q61Commit("dfksjdhf48", false);
        commits[1] = new Q61Commit("dfs39387hds", true);
        commits[2] = new Q61Commit("dfs22222", true);
    }

    @Test
    public void testForIndex1() throws Exception {
        assertEquals(q61.getFirstBuggyCommit(commits), "dfs39387hds");
    }
}