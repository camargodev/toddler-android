package com.ihc.toddler.manager;

import android.speech.tts.TextToSpeech;
import android.view.View;
import android.widget.TextView;

public class SpeechManager {

    private TextToSpeech textToSpeech;

    public SpeechManager(TextToSpeech textToSpeech) {
        this.textToSpeech = textToSpeech;
    }

    public void readWithNormalClick(final TextView element) {
        readWithNormalClick(element, element.getText().toString());
    }

    public void readWithNormalClick(final View element, final String text) {
        element.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                talk(text);
            }
        });
    }

    public void readWithLongClick(final TextView element) {
        readWithLongClick(element, element.getText().toString());
    }

    public void readWithLongClick(final View element, final String text) {
        element.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                talk(text);
                return false;
            }
        });
    }

    public void talk(String text) {
        textToSpeech.speak(text, TextToSpeech.QUEUE_FLUSH, null);
    }
}
