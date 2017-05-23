package example.snail.snailgank.bean;

import java.util.List;

/**
 * 福利返回数据实体类
 * Created by snail on 2017/5/23.
 */

public class WelfareResult {
    private boolean error;

    private List<WelfareBean> results;

    public void setError(boolean error) {
        this.error = error;
    }

    public boolean getError() {
        return this.error;
    }

    public void setResults(List<WelfareBean> results) {
        this.results = results;
    }

    public List<WelfareBean> getResults() {
        return this.results;
    }
}
