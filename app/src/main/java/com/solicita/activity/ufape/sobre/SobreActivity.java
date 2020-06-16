package com.solicita.activity.ufape.sobre;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;

import com.solicita.R;

public class SobreActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ufape_sobre);


    }

    public void clickBotaoClose(View view){
        finish();
    }
}
