package com.example.freedom20;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;

import com.github.barteksc.pdfviewer.PDFView;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

public class PDFActivity extends AppCompatActivity {
    PDFView pdf;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pdfactivity);

        Intent intent = getIntent();
        String pdfLink = intent.getStringExtra("url");
        pdf = findViewById(R.id.pdfView1);

        new PDFdownload().execute(pdfLink);


    }
    private class PDFdownload extends AsyncTask<String, Void , InputStream> {
        public ProgressDialog dialog;


        @Override
        protected void onPreExecute() {
            super.onPreExecute();

            dialog = new ProgressDialog(PDFActivity.this);


            dialog.setProgressStyle(ProgressDialog.STYLE_SPINNER);
            dialog.setTitle("Please wait a moment");
            dialog.setMessage("Download time may vary with book size ");
            dialog.setCancelable(false);
            dialog.setCanceledOnTouchOutside(false);
            dialog.show();

        }

        @Override
        protected InputStream doInBackground(String... strings) {
            InputStream inputStream = null;

            try {
                URL url = new URL(strings[0]);
                HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();
                if (urlConnection.getResponseCode() == 200){
                    inputStream = new BufferedInputStream(urlConnection.getInputStream());
                }

            } catch ( IOException e) {
                e.printStackTrace();
            }

            return inputStream;
        }



        @Override
        protected void onPostExecute(InputStream inputStream) {
            pdf.fromStream(inputStream).load();
            dialog.dismiss();
        }
    }

}