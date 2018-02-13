/*
 * Copyright (C) 2016 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.example.android.miwok;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class NumbersActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_numbers);

        ArrayList<Word> englishNumbers = new ArrayList<Word>();
        englishNumbers.add(new Word("One", "lutti"));
        englishNumbers.add(new Word("Two", "otiiko"));
        englishNumbers.add(new Word("Three", "tolookosu"));
        englishNumbers.add(new Word("Four", "oyyiisa"));
        englishNumbers.add(new Word("Five", "massokka"));
        englishNumbers.add(new Word("Six", "temmokka"));
        englishNumbers.add(new Word("Seven", "kenekaku"));
        englishNumbers.add(new Word("Eight", "kavinta"));
        englishNumbers.add(new Word("Nine", "wo'e"));
        englishNumbers.add(new Word("Ten", "na'aacha"));


        AndroidWordAdapter wordArrayAdapter = new AndroidWordAdapter(this, englishNumbers);

        ListView listView = (ListView) findViewById(R.id.activity_numbers);
        listView.setAdapter(wordArrayAdapter);
    }
}
