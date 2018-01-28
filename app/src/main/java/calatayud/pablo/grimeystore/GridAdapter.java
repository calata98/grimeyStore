package calatayud.pablo.grimeystore;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by calata98 on 28-Jan-18.
 */

public class GridAdapter extends BaseAdapter {
    private Context mContext;
    private String[] mThumbIds;

    public GridAdapter(Context c, String [] mThumbIds) {
        mContext = c;
        this.mThumbIds = mThumbIds;
    }

    public int getCount() {
        return mThumbIds.length;
    }

    public Object getItem(int position) {
        return null;
    }

    public long getItemId(int position) {
        return 0;
    }

    // create a new ImageView for each item referenced by the Adapter
    public View getView(int position, View convertView, ViewGroup parent) {

        if (convertView == null) {
            LayoutInflater layoutInflater = (LayoutInflater) mContext.getSystemService(mContext.LAYOUT_INFLATER_SERVICE);
            convertView = layoutInflater.inflate(R.layout.layout_lista,null);
        }

        TextView nombreP = (TextView) convertView.findViewById(R.id.nombreP);
        nombreP.setText("");

        TextView precioP = (TextView) convertView.findViewById(R.id.precioP);
        precioP.setText("");

        ImageView imagenP = (ImageView) convertView.findViewById(R.id.imgP);
        //imagenP.setImageResource(mThumbIds[position]);


        return convertView;
    }


}