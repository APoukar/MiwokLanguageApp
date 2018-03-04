package com.example.android.miwok;

import android.app.Activity;
import android.content.res.Resources;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by adam on 13.2.18.
 */

public class AndroidWordAdapter extends ArrayAdapter<Word> {

    private int mBackgroundColorID;


    private static final String LOG_TAG = AndroidWordAdapter.class.getSimpleName();

    public AndroidWordAdapter(Activity context,ArrayList<Word>word, int backgroundColorID) {
        // Here, we initialize the ArrayAdapter's internal storage for the context and the list.
        // the second argument is used when the ArrayAdapter is populating a single TextView.
        // Because this is a custom adapter for two TextViews and an ImageView, the adapter is not
        // going to use this second argument, so it can be any value. Here, we used 0.
        super(context, 0, word);
        mBackgroundColorID = backgroundColorID;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View listItemView = convertView;
        if(listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.list_item, parent, false);
        }

        Word currentWord = getItem(position);

        TextView defaultTranslation = (TextView) listItemView.findViewById(R.id.default_translation);
        defaultTranslation.setText(currentWord.getDefaultTranslation());

        TextView miwokTranslation = (TextView) listItemView.findViewById(R.id.miwok_translation);
        miwokTranslation.setText(currentWord.getMiwokTranslation());

        ImageView image = (ImageView) listItemView.findViewById(R.id.word_image);
        if (currentWord.hasImage()) {
            image.setImageResource(currentWord.getImage());
            image.setVisibility(View.VISIBLE);
        } else {
            image.setVisibility(View.GONE);
        }

        LinearLayout textContainer = (LinearLayout) listItemView.findViewById(R.id.text_containter);
        int color = ContextCompat.getColor(getContext(), mBackgroundColorID);
        textContainer.setBackgroundColor(color);
        return listItemView;
    }
}
