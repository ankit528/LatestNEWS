package example.android.latestnews;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import java.util.ArrayList;
import java.util.List;

public class NewsActivity extends AppCompatActivity {

    private NewsAdapter adapter;

    private static final String news_Request_Url = "http://content.guardianapis.com/search?q=android&api-key=test&order-by=newest&page-size=30";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.news_list_view);

        ListView newsListView = findViewById(R.id.list);

        adapter = new NewsAdapter(this, new ArrayList<News>());

        newsListView.setAdapter(adapter);

        newsListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                News currentEarthquake = adapter.getItem(position);

                Uri newsUri = Uri.parse(currentEarthquake.getWebUrl());

                Intent webIntent = new Intent(Intent.ACTION_VIEW, newsUri);

                startActivity(webIntent);

            }
        });

        NewsAsyncTask task = new NewsAsyncTask();
        task.execute(news_Request_Url);
    }

    private class NewsAsyncTask extends AsyncTask<String, Void, List<News>> {

        @Override
        protected List<News> doInBackground(String... urls) {
            if (urls[0] == null) {
                return null;
            }
            List<News> result = NewsQuery.fetchNewsData(urls[0]);
            return result;
        }

        @Override
        protected void onPostExecute(List<News> data) {
            adapter.clear();

            if (data != null && !data.isEmpty()) {
                adapter.addAll(data);
            }
        }
    }
}
