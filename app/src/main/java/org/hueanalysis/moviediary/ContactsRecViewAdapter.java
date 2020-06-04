package org.hueanalysis.moviediary;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;

import org.hueanalysis.moviediary.R;

import java.util.ArrayList;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

public class ContactsRecViewAdapter extends RecyclerView.Adapter<ContactsRecViewAdapter.ItemViewHolder> {

    private ArrayList<Contact> contacts = new ArrayList<>();

    private Context context;


    public ContactsRecViewAdapter(Context context) {
        this.context = context;
    }

    @NonNull
    @Override
    public ItemViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.contacts_list_item, parent, false);
        ItemViewHolder holder = new ItemViewHolder(view);

        return holder;
    }


    @Override
    public void onBindViewHolder(@NonNull ItemViewHolder holder, final int position) {
        holder.txtName.setText(contacts.get(position).getName());
        holder.txtEmail.setText(contacts.get(position).getEmail());
        holder.parent.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Toast.makeText(context, contacts.get(position).getName(), Toast.LENGTH_SHORT).show();
            }
        });

        Glide.with(context)
                .asBitmap()
                .load(contacts.get(position).getImageUrl())
                .override(150, 150)
                .centerCrop()
                .into(holder.image);

    }

    @Override
    public int getItemCount() {
        return contacts.size();
    }


    public void setContacts(ArrayList<Contact> contacts) {
        this.contacts = contacts;
        notifyDataSetChanged();
    }


    public class ItemViewHolder extends RecyclerView.ViewHolder{

        private TextView txtName, txtEmail;
        private ImageView image;

        private CardView parent;

        public ItemViewHolder(@NonNull View itemView) {
            super(itemView);

            txtName = itemView.findViewById(R.id.txtName);
            parent = itemView.findViewById(R.id.parent);
            txtEmail = itemView.findViewById(R.id.txtEmail);
            image = itemView.findViewById(R.id.image);
        }
    }


}
