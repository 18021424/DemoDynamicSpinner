package sg.edu.rp.c346.demodynamicspinner;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;

import java.util.ArrayList;
import java.util.Arrays;

public class MainActivity extends AppCompatActivity {
Spinner spn1,spn2;
Button btn;
ArrayList<String> al;
ArrayAdapter<String> aa;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        spn1 = findViewById(R.id.spinner);
        spn2 = findViewById(R.id.spinner2);
        btn = findViewById(R.id.button);
        al = new ArrayList<>();
        String[] strNumbers = getResources().getStringArray(R.array.even_numbers);
        al.addAll(Arrays.asList(strNumbers));
        aa = new ArrayAdapter<>(this,android.R.layout.simple_spinner_dropdown_item,al);

        spn2.setAdapter(aa);
        // Approach one
        /*al.add("2");
        al.add("4");
        al.add("6");
        */

        // Approach 2


       /* btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int pos = spn1.getSelectedItemPosition();
                al.clear();
                if (pos == 0) {
                    String[] strNumbers = getResources().getStringArray(R.array.even_numbers);
                    al.addAll(Arrays.asList(strNumbers));
                    aa.notifyDataSetChanged();
                }
                else{
                    String[] strNumbers = getResources().getStringArray(R.array.odd_numbers);
                    al.addAll(Arrays.asList(strNumbers));
                    aa.notifyDataSetChanged();
                }
            }
        });
        */

     spn1.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
         @Override
         public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
             switch (position){
                 case  0:
                     al.clear();
                     String[] even = getResources().getStringArray(R.array.even_numbers);
                     al.addAll(Arrays.asList(even));
                      aa.notifyDataSetChanged();
                     break;
                 case 1:
                     al.clear();
                     String[] odd = getResources().getStringArray(R.array.odd_numbers);
                     spn2.setSelection(1);
                     al.addAll(Arrays.asList(odd));
                      aa.notifyDataSetChanged();
                     break;
             }
         }


         @Override
         public void onNothingSelected(AdapterView<?> parent) {

         }
     });
        if ( spn1.getSelectedItemPosition() == 0 ){
            spn2.setSelection(2);
        }
        if (spn1.getSelectedItemPosition() == 1){
            spn2.setSelection(1);
        }
    }
}
