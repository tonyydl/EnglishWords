package tw.tonyyang.englishwords;

import android.support.v7.app.ActionBar;
import android.view.MenuItem;
import android.widget.TextView;

import com.hedgehog.ratingbar.RatingBar;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.Bean;
import org.androidannotations.annotations.EActivity;
import org.androidannotations.annotations.Extra;
import org.androidannotations.annotations.ViewById;

import tw.tonyyang.englishwords.db.Words;
import tw.tonyyang.englishwords.db.WordsDao;


@EActivity(R.layout.activity_wordslist_info)
public class WordsListDetailActivity extends BaseActivity {

    @Extra
    Words selectedWords;

    @Bean
    WordsDao wordsDao;

    @ViewById(R.id.wordTV)
    TextView wordTV;

    @ViewById(R.id.wordmeanTV)
    TextView wordMeanTV;

    @ViewById(R.id.wordsentenceTV)
    TextView wordSentenceTV;

    @ViewById(R.id.categoryTV)
    TextView categoryTV;

    @ViewById(R.id.ratingbar)
    RatingBar ratingbar;

    @AfterViews
    protected void initViews() {
        super.initViews();
        initActionBar();
        setViews();
    }

    private void initActionBar() {
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setDisplayHomeAsUpEnabled(true);
        }
    }

    private void setViews() {
        if (selectedWords != null) {
            wordTV.setText(selectedWords.getWord().replace("*", ""));
            wordMeanTV.setText(selectedWords.getWordMean());
            wordSentenceTV.setText(selectedWords.getWordSentence());
            categoryTV.setText(selectedWords.getCategory());
            ratingbar.setStar(Float.parseFloat(selectedWords.getWordStar()));
        }
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                onBackPressed();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
}