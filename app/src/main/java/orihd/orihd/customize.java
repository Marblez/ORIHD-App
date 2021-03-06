package orihd.orihd;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Spinner;
import android.widget.Toast;

public class customize extends AppCompatActivity implements AdapterView.OnItemSelectedListener,View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_customize);
        Spinner spinner = (Spinner) findViewById(R.id.spinner);

        EditText newtag = (EditText) findViewById(R.id.editText);

        // Create an ArrayAdapter using the string array and a default spinner layout
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.personal_tags, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
        spinner.setOnItemSelectedListener(this);
        Button save = (Button) findViewById(R.id.button4);
        save.setOnClickListener(this);


    }

    public String FindLabel(){
        Spinner spinner = (Spinner) findViewById(R.id.spinner);
        String text = spinner.getSelectedItem().toString();
        return text;
    }

    public String FindTag(){
        EditText newtag = (EditText) findViewById(R.id.editText);
        String TagInfo = newtag.getText().toString();
        if(TagInfo==null || TagInfo == "" || TagInfo == " " ||TagInfo.length() <= 1){
            return null;
        }
        return TagInfo;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {

            case R.id.button4:
                String TagInfo = FindTag();
                if(TagInfo == null){
                    String righttag = FindLabel();
                    FragmentTab1.globaltext = righttag;
                    Intent registerIntent1234 = new Intent(customize.this, Login.class);
                    customize.this.startActivity(registerIntent1234);
                    finish();
                }
                else{
                FragmentTab1.globaltext = TagInfo;
                Intent registerIntent1234 = new Intent(customize.this, Login.class);
                customize.this.startActivity(registerIntent1234);
                finish();
                }
                break;



        }
    }



    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        // On selecting a spinner item
        String item = parent.getItemAtPosition(position).toString();

        switch (position) {
            case 0:

                FragmentTab1.globaltext = "Working Class";

                break;
            case 1:

                FragmentTab1.globaltext = "Professional Athlete";

                break;
            case 2:

                FragmentTab1.globaltext = "Outdoor Hobbyist";

            case 3:

                FragmentTab1.globaltext = "Health Junkie";

                break;
            case 4:
                FragmentTab1.globaltext = "Rehabilitation Patient";
                break;
            case 5:
                FragmentTab1.globaltext = "Casual Athlete";
                break;
        }
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }


}




