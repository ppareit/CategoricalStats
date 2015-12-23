package be.ppareit.janstat;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import net.vrallev.android.cat.Cat;

import java.util.List;

/**
 * Created by ppareit on 17/12/15.
 */
public class StatAdapter extends BaseAdapter {

    private List<Person> persons;
    private Activity activity;

    public StatAdapter(Activity activity, List<Person> persons) {
        super();

        this.activity = activity;
        this.persons = persons;
    }

    static class ViewHolder {
        protected TextView name;
        protected ImageView image;
        protected ProgressBar progress;
        protected ImageButton addGiftButton;
    }

    @Override
    public int getCount() {
        return persons.size();
    }

    @Override
    public Person getItem(int position) {
        return persons.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        Person person = persons.get(position);
        View view;
        if (convertView == null) {
            LayoutInflater inflater = activity.getLayoutInflater();
            view = inflater.inflate(R.layout.row_layout, parent, false);
            ViewHolder viewHolder = new ViewHolder();
            viewHolder.name = (TextView) view.findViewById(R.id.name_text);
            viewHolder.image = (ImageView) view.findViewById(R.id.image);
            viewHolder.progress = (ProgressBar) view.findViewById(R.id.progress_bar);
            view.setOnClickListener(
                    v -> {
                        person.addGift();
                        viewHolder.progress.setProgress(person.getGiftCount());
                    });
            view.setTag(viewHolder);
        } else {
            view = convertView;
        }
        ViewHolder viewHolder = (ViewHolder) view.getTag();
        viewHolder.name.setText(person.getName());
        viewHolder.image.setImageDrawable(activity.getResources().getDrawable(R.mipmap.ic_launcher));
        viewHolder.progress.setProgress(person.getGiftCount());

        return view;
    }
}









