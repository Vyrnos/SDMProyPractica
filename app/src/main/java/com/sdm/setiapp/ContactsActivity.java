package com.sdm.setiapp;

import android.app.Activity;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.util.Log;

/**
 * Created by Vlad on 2/3/2018.
 */

public class ContactsActivity extends Activity {
    @Override
    protected void onCreate(Bundle objProvider){
        super.onCreate(objProvider);
        setContentView(R.layout.table);
        Uri todosContactos = Uri.parse("content://contacts/people");
        Cursor c = getContentResolver().query(todosContactos,null,null,null, ContactsContract.Contacts.DISPLAY_NAME);
        PrintContactos(c);
    }

    private void PrintContactos(Cursor c){
        if(c.moveToFirst()){
            do{
                String contID = c.getString(c.getColumnIndex(ContactsContract.Contacts._ID));
                String contDameNombre = c.getString(c.getColumnIndex(ContactsContract.Contacts.DISPLAY_NAME));
                Log.v("Content Providers", contID + ", "+contDameNombre);
            }while(c.moveToNext());
        }
    }
}
