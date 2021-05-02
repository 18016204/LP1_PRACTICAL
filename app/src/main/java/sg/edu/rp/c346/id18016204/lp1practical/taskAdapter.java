package sg.edu.rp.c346.id18016204.lp1practical;

import android.content.Intent;
import android.widget.ArrayAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.TextView;
import android.content.Context;

import java.util.ArrayList;

public class taskAdapter extends ArrayAdapter<Task> {
    private ArrayList<Task> task;
    private Context context;
    private TextView tvItem, tvDesc, tvDate;
    public Button button;
    public taskAdapter(Context context, int resource, ArrayList<Task> objects) {
        super(context, resource, objects);
        task = objects;
        this.context = context;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View rowView = inflater.inflate(R.layout.row_task, parent, false);

        tvItem = (TextView) rowView.findViewById(R.id.tvItem);
        tvDesc = (TextView) rowView.findViewById(R.id.tvDesc);
        tvDate = (TextView) rowView.findViewById(R.id.tvDate);
        button = (Button)rowView.findViewById(R.id.btnShare);
        Task currentCA = task.get(position);
        tvItem.setText("Item: " + (position + 1));
        tvDesc.setText(currentCA.getDescription());
        tvDate.setText(currentCA.getDate());

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                // The action you want this intent to do;
                // ACTION_SEND is used to indicate sending text
                Intent email = new Intent(Intent.ACTION_SEND);
                // Put essentials like email address, subject & body text
                email.putExtra(Intent.EXTRA_EMAIL,
                        new String[]{"andy_tao@rp.edu.sg"});
                email.putExtra(Intent.EXTRA_SUBJECT,
                        "A task is shared with you from 18016204");

                String text = "Task Description: "+ task.get(0).getDescription()  + "\n Task Date: " + task.get(0).getDate();


                email.putExtra(Intent.EXTRA_TEXT,
                        text);
                // This MIME type indicates email
                email.setType("message/rfc822");
                // createChooser shows user a list of app that can handle
                // this MIME type, which is, email

                context.startActivity(Intent.createChooser(email,
                        "Choose an Email client :"));

            }
        });
        return rowView;




    }
}
