package com.lucavg.myportfolio.home;

import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.lucavg.myportfolio.R;

public class HomeFragment extends Fragment {
    ImageButton phoneBtn;
    ImageButton mailBtn;
    ImageButton mailPersonalBtn;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v1 = inflater.inflate(R.layout.fragment_home, container, false);

        // setup imagebuttons
        mailBtn = v1.findViewById(R.id.mailbtn);
        phoneBtn = v1.findViewById(R.id.phonebtn);
        mailPersonalBtn = v1.findViewById(R.id.mailPersonalBtn);

        mailBtn.setOnClickListener(v -> {
            String mailto = "mailto:r0849476@student.thomasmore.be";

            Intent emailIntent = new Intent(Intent.ACTION_SENDTO);
            emailIntent.setData(Uri.parse(mailto));

            try {
                startActivity(emailIntent);
            } catch (ActivityNotFoundException e) {
                Toast.makeText(getActivity(), "Please install a mail app", Toast.LENGTH_SHORT).show();
            }
        });

        mailPersonalBtn.setOnClickListener(v -> {
            String mailto = "mailto:lucavg@icloud.com";

            Intent emailIntent = new Intent(Intent.ACTION_SENDTO);
            emailIntent.setData(Uri.parse(mailto));

            try {
                startActivity(emailIntent);
            } catch (ActivityNotFoundException e) {
                Toast.makeText(getActivity(), "Please install a mail app", Toast.LENGTH_SHORT).show();
            }
        });

        phoneBtn.setOnClickListener(v -> {
            Intent phone = new Intent(ContactsContract.Intents.Insert.ACTION);
            phone.setType(ContactsContract.RawContacts.CONTENT_TYPE);

            String phoneNumber = "0471016602";
            String name = "Luca Van Genechten";

            phone.putExtra(ContactsContract.Intents.Insert.NAME, name)
                    .putExtra(ContactsContract.Intents.Insert.PHONE, phoneNumber)
                    .putExtra(ContactsContract.Intents.Insert.PHONE_TYPE, ContactsContract.CommonDataKinds.Phone.TYPE_WORK);

            startActivity(phone);
        });

        return v1;
    }
}
