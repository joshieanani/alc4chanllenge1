package com.example.alcchallenge1;



import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.KeyEvent;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.widget.ProgressBar;

public class AboutALC extends AppCompatActivity {

    private WebView mAlcViewer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about_alc);


        ProgressBar progressBar = findViewById(R.id.about_alc_progress_bar);
        mAlcViewer = findViewById(R.id.about_alc_webview);
        WebSettings alcWebSettings = mAlcViewer.getSettings();
        alcWebSettings.setJavaScriptEnabled(true);
        alcWebSettings.setDomStorageEnabled(true);
        ALCWebViewClient alcWebViewClient = new ALCWebViewClient(this, progressBar);
        mAlcViewer.setWebViewClient(alcWebViewClient);


        mAlcViewer.loadUrl("https://www.andela.com/alc");

    }
    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK  && this.mAlcViewer.canGoBack()){

            this.mAlcViewer.goBack();
            return true;
        }

        return super.onKeyDown(keyCode, event);
    }
}
