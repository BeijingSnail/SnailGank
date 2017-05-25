package example.snail.snailgank.bean;

import java.util.List;

/**
 * Created by Snail on 2017/5/25.
 */

public class ResResult {

    private boolean error;

    private List<ResBean> results;

    public void setError(boolean error) {
        this.error = error;
    }

    public boolean getError() {
        return this.error;
    }

    public void setResults(List<ResBean> results) {
        this.results = results;
    }

    public List<ResBean> getResults() {
        return this.results;
    }

}
