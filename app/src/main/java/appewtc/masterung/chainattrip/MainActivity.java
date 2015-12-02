package appewtc.masterung.chainattrip;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    //Explicit
    private ImageView hotelImageView, restaurantImageView, souvenirImageView, travelImageView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Bind Widget
        bindWidget();

        //Image Controller
        imageController();

    }   // Main Method

    private void imageController() {

        hotelImageView.setOnClickListener(this);
        restaurantImageView.setOnClickListener(this);
        souvenirImageView.setOnClickListener(this);
        travelImageView.setOnClickListener(this);

    }

    private void bindWidget() {

        hotelImageView = (ImageView) findViewById(R.id.imageView);
        restaurantImageView = (ImageView) findViewById(R.id.imageView2);
        souvenirImageView = (ImageView) findViewById(R.id.imageView3);
        travelImageView = (ImageView) findViewById(R.id.imageView4);

    }

    @Override
    public void onClick(View view) {


        //Intent To ChainatListView
        Intent objIntent = new Intent(MainActivity.this, ChainatListView.class);
        startActivity(objIntent);

    }   // onClick

}   // Main Class
