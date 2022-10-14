package com.example.mybrowser2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    Button btnGo;
    WebView webview;
    EditText address;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        address = findViewById(R.id.adress);
        webview = findViewById(R.id.webview);
        webview.setWebViewClient(new WebViewClient());

        if ((getIntent() != null) && (getIntent().getData() != null)){
            address.setText(getIntent().getData().toString());
            webview.loadUrl(getIntent().getData().toString());
        }

        btnGo = findViewById(R.id.btnGo);

        btnGo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                webview.loadUrl("http://"+ address.getText());
            }
        });
    }

      @Override
    public boolean onCreateOptionsMenu(Menu menu) {
          MenuInflater inflater = getMenuInflater();
          inflater.inflate(R.menu.menu, menu);
          return super.onCreateOptionsMenu(menu);
      }
}