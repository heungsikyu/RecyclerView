package org.hueanalysis.recyclerviewexample;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.RelativeLayout;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private RecyclerView contactsRecView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        contactsRecView = findViewById(R.id.contactsRecView);

        ArrayList<Contact> contacts = new ArrayList<>();

        contacts.add(new Contact("Margot Robbie", "marog@gmail.com", "https://thumbor.forbes.com/thumbor/fit-in/416x416/filters%3Aformat%28jpg%29/https%3A%2F%2Fspecials-images.forbesimg.com%2Fimageserve%2F585404d54bbe6f1f20e92308%2F0x0.jpg%3Fbackground%3D000000%26cropX1%3D0%26cropX2%3D744%26cropY1%3D58%26cropY2%3D802" ) );
        contacts.add(new Contact("Cillian Mruphy", "Chillian@gmail.com", "https://upload.wikimedia.org/wikipedia/commons/thumb/a/a5/Cillian_Murphy_Press_Conference_The_Party_Berlinale_2017_02cr.jpg/440px-Cillian_Murphy_Press_Conference_The_Party_Berlinale_2017_02cr.jpg" ) );
        contacts.add(new Contact("Saoirse Ronan", "saoirse@gmail.com", "https://upload.wikimedia.org/wikipedia/commons/f/f5/Saoirse_Ronan_in_2018.png" ) );

        contacts.add(new Contact("Emma Watson", "emma@gmail.com", "https://upload.wikimedia.org/wikipedia/commons/0/0a/Emma_Watson_interview_in_2017.jpg" ) );
        contacts.add(new Contact("Margot Robbie", "marog@gmail.com", "https://thumbor.forbes.com/thumbor/fit-in/416x416/filters%3Aformat%28jpg%29/https%3A%2F%2Fspecials-images.forbesimg.com%2Fimageserve%2F585404d54bbe6f1f20e92308%2F0x0.jpg%3Fbackground%3D000000%26cropX1%3D0%26cropX2%3D744%26cropY1%3D58%26cropY2%3D802" ) );
        contacts.add(new Contact("Cillian Mruphy", "Chillian@gmail.com", "https://upload.wikimedia.org/wikipedia/commons/thumb/a/a5/Cillian_Murphy_Press_Conference_The_Party_Berlinale_2017_02cr.jpg/440px-Cillian_Murphy_Press_Conference_The_Party_Berlinale_2017_02cr.jpg" ) );

        contacts.add(new Contact("Saoirse Ronan", "saoirse@gmail.com", "https://upload.wikimedia.org/wikipedia/commons/f/f5/Saoirse_Ronan_in_2018.png" ) );
        contacts.add(new Contact("Emma Watson", "emma@gmail.com", "https://upload.wikimedia.org/wikipedia/commons/0/0a/Emma_Watson_interview_in_2017.jpg" ) );
        contacts.add(new Contact("Margot Robbie", "marog@gmail.com", "https://thumbor.forbes.com/thumbor/fit-in/416x416/filters%3Aformat%28jpg%29/https%3A%2F%2Fspecials-images.forbesimg.com%2Fimageserve%2F585404d54bbe6f1f20e92308%2F0x0.jpg%3Fbackground%3D000000%26cropX1%3D0%26cropX2%3D744%26cropY1%3D58%26cropY2%3D802" ) );

        contacts.add(new Contact("Cillian Mruphy", "Chillian@gmail.com", "https://upload.wikimedia.org/wikipedia/commons/thumb/a/a5/Cillian_Murphy_Press_Conference_The_Party_Berlinale_2017_02cr.jpg/440px-Cillian_Murphy_Press_Conference_The_Party_Berlinale_2017_02cr.jpg" ) );
        contacts.add(new Contact("Saoirse Ronan", "saoirse@gmail.com", "https://upload.wikimedia.org/wikipedia/commons/f/f5/Saoirse_Ronan_in_2018.png" ) );
        contacts.add(new Contact("Emma Watson", "emma@gmail.com", "https://upload.wikimedia.org/wikipedia/commons/0/0a/Emma_Watson_interview_in_2017.jpg" ) );

        contacts.add(new Contact("Cillian Mruphy", "Chillian@gmail.com", "https://upload.wikimedia.org/wikipedia/commons/thumb/a/a5/Cillian_Murphy_Press_Conference_The_Party_Berlinale_2017_02cr.jpg/440px-Cillian_Murphy_Press_Conference_The_Party_Berlinale_2017_02cr.jpg" ) );
        contacts.add(new Contact("Saoirse Ronan", "saoirse@gmail.com", "https://upload.wikimedia.org/wikipedia/commons/f/f5/Saoirse_Ronan_in_2018.png" ) );
        contacts.add(new Contact("Emma Watson", "emma@gmail.com", "https://upload.wikimedia.org/wikipedia/commons/0/0a/Emma_Watson_interview_in_2017.jpg" ) );


        ContactsRecViewAdapter adapter = new ContactsRecViewAdapter(this);
        adapter.setContacts(contacts);

        contactsRecView.setAdapter(adapter);
        //contactsRecView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
        contactsRecView.setLayoutManager(new GridLayoutManager(this, 2));

    }
}