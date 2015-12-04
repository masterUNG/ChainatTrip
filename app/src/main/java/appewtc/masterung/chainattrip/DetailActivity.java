package appewtc.masterung.chainattrip;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

public class DetailActivity extends AppCompatActivity {

    //Explicit
    private TextView titleTextView, detailTextView;
    private ImageView firstImageView, secondImageView, thirdImageView;
    private String titleString, firstString, secondString, thirdString, detailString,
            latString, lngString;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        //Bind Widget
        bindWidget();

        //Receive Value From Intent
        receiveValue();

        //Show View
        showView();

    }   // Main Method

    private void showView() {

        titleTextView.setText(titleString);
        detailTextView.setText(detailString);

        //First
        Picasso.with(DetailActivity.this)
                .load(firstString)
                .into(firstImageView);

        //Second
        Picasso.with(DetailActivity.this)
                .load(secondString)
                .into(secondImageView);

        //Third
        Picasso.with(DetailActivity.this)
                .load(thirdString)
                .into(thirdImageView);

    }

    private void receiveValue() {

        titleString = getIntent().getStringExtra("Title");
        firstString = getIntent().getStringExtra("Image1");
        secondString = getIntent().getStringExtra("Image2");
        thirdString = getIntent().getStringExtra("Image3");
        detailString = getIntent().getStringExtra("Detail");
        latString = getIntent().getStringExtra("Lat");
        lngString = getIntent().getStringExtra("Lng");

    }

    private void bindWidget() {

        titleTextView = (TextView) findViewById(R.id.textView8);
        detailTextView = (TextView) findViewById(R.id.textView9);
        firstImageView = (ImageView) findViewById(R.id.imageView6);
        secondImageView = (ImageView) findViewById(R.id.imageView7);
        thirdImageView = (ImageView) findViewById(R.id.imageView8);

    }

}   // Main Class
