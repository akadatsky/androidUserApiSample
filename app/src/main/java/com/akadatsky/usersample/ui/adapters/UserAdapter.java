package com.akadatsky.usersample.ui.adapters;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.akadatsky.usersample.R;
import com.akadatsky.usersample.model.User;

public class UserAdapter extends ArrayAdapter<User> {

    private LayoutInflater mInflater;

    public UserAdapter(@NonNull Context context) {
        super(context, 0);
        mInflater = LayoutInflater.from(context);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        if (convertView == null) {
            convertView = mInflater.inflate(R.layout.user, parent, false);
        }
        String item = getItem(position).getName();

        TextView text = convertView.findViewById(R.id.textView);
        text.setText(item);

        return convertView;
    }
}
