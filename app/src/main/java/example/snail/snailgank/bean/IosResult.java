package example.snail.snailgank.bean;

import java.util.List;

/**
 * Created by admin on 2017/5/23.
 */

public class IosResult {

    private boolean error;
    private List<IosBean> results;

    public void setError(boolean error) {
        this.error = error;
    }

    public boolean getError() {
        return error;
    }

    public void setResults(List<IosBean> results) {
        this.results = results;
    }

    public List<IosBean> getResults() {
        return results;
    }
}
