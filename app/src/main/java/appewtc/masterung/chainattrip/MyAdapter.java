package appewtc.masterung.chainattrip;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

/**
 * Created by masterUNG on 12/3/15 AD.
 */
public class MyAdapter extends BaseAdapter{

    //Explicit
    private Context objContext;
    private String[] titleStrings, detailStrings;
    private String[] iconInts;

    public MyAdapter(Context objContext, String[] titleStrings, String[] detailStrings, String[] iconInts) {
        this.objContext = objContext;
        this.titleStrings = titleStrings;
        this.detailStrings = detailStrings;
        this.iconInts = iconInts;
    }   // Constructor

    @Override
    public int getCount() {
        return titleStrings.length;
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {

        LayoutInflater objLayoutInflater = (LayoutInflater) objContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view1 = objLayoutInflater.inflate(R.layout.my_listview, viewGroup, false);

        //Set TextView
        TextView titleTextView = (TextView) view1.findViewById(R.id.textView6);
        titleTextView.setText(titleStrings[i]);

        TextView detailTextView = (TextView) view1.findViewById(R.id.textView7);
        detailTextView.setText(detailStrings[i]);

        //Set ImageView
        ImageView iconImageView = (ImageView) view1.findViewById(R.id.imageView5);
        Picasso.with(objContext)
                .load(iconInts[i])
                .resize(100, 100)
                .into(iconImageView);

        return view1;
    }
}   // Main Class
