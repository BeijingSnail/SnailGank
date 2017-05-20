package example.snail.snailgank.bean;

import java.util.List;

/**
 * Created by admin on 2017/5/20.
 */

public class AndroidResult {
    private boolean error;

    private List<AndroidBean> results;

    public void setError(boolean error) {
        this.error = error;
    }

    public boolean getError() {
        return this.error;
    }

    public void setResults(List<AndroidBean> results) {
        this.results = results;
    }

    public List<AndroidBean> getResults() {
        return this.results;
    }
}
