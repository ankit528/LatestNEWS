package example.android.latestnews;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.util.ArrayList;

public class NewsAdapter extends ArrayAdapter<News> {

    public NewsAdapter(Context context, ArrayList<News> newses) {
        super(context, 0, newses);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        View listItemView = convertView;
        if (listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.news_list_item, parent, false);
        }

        News currentNews = getItem(position);

        TextView webTitleView = listItemView.findViewById(R.id.web_title);
        webTitleView.setText(currentNews.getWebTitle());

        TextView dateView = listItemView.findViewById(R.id.date);
        dateView.setText(currentNews.getWebPublicationDate());

        return listItemView;
    }
}
