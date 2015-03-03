package com.adhish.pagertabstriptutorial;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.Toast;

import java.io.FileOutputStream;
import java.io.OutputStreamWriter;

public class FragmentTab1 extends Fragment implements View.OnClickListener {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        // Get the view from fragmenttab1.xml
        //first inflate the view.
        View v  = inflater.inflate(R.layout.fragmenttab1, container, false);

        //then access the elements

        v.findViewById(R.id.button1).setOnClickListener(this);

        //then return the view
        return v;

    }

    @Override
    public void onClick(View view)
    {
        if(view == getView().findViewById(R.id.button1))
        {
            //Call all the elements of this Fragment here becuase they are accessible easily through
            //getView(); method. Use the getText(); method to get the Text and toString(); to convert
            //it.
            String name = ((EditText)getView().findViewById(R.id.name)).getText().toString();
            String email = ((EditText)getView().findViewById(R.id.email)).getText().toString();

            if(name.isEmpty() || email.isEmpty())
            {
                Toast.makeText(getActivity(), "Cannot store empty values !", Toast.LENGTH_SHORT).show();
            }
            else
            {
                try
                {
                    FileOutputStream fOut = getActivity().openFileOutput("sample_details.txt", Context.MODE_MULTI_PROCESS);
                    OutputStreamWriter outputStreamWriter = new OutputStreamWriter(fOut);

                    outputStreamWriter.write(name + " " + email + ";");
                    Log.e("String Concat Done", "Concatenation of the Strings is done to write in the File. Write Success.");
                    outputStreamWriter.flush();
                    Log.e("Flush","Flush Success");
                    outputStreamWriter.close();
                    fOut.close();
                    Log.e("Stream Closed","Both Streams are flushed and closed");

                    Toast.makeText(getActivity(), "Submitted", Toast.LENGTH_SHORT).show();
                }
                catch (Exception e)
                {
                    Toast.makeText(getActivity(), "FAILED !", Toast.LENGTH_SHORT).show();
                    Log.e("Error in File Write",e.toString());
                }
            }
        }
    }

}
