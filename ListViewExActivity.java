package your.package2.namespace;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;


public class ListViewExActivity extends Activity implements OnItemClickListener  {
	String[] androidBooks = 
		{
			"Hello, Android - Ed Burnette",
			"Professional Android 2 App Dev - Reto Meier",
			"Unlocking Android - Frank Ableson",
			"Android App Development - Blake Meike",
			"Pro Android 2 - Dave MacLean",
			"Beginning Android 2 - Mark Murphy",
			
		};
	
	ListView listView;
	TextView tv1;
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        
        listView =(ListView) findViewById(R.id.listView1);
        tv1=(TextView) findViewById(R.id.textView1);
        
        ArrayAdapter<String> adapter = 
            	new ArrayAdapter<String> (this, 
            			android.R.layout.simple_list_item_1,androidBooks);
            //.simple_spinner_item
        listView.setAdapter(adapter);
            
        listView.setOnItemClickListener(ListViewExActivity.this);  
        
        
        
        /*
         * 
         listView.setOnItemClickListener(new OnItemClickListener() {
 
                  @Override
                  public void onItemClick(AdapterView<?> parent, View view,
                     int position, long id) {
                    
                   
                   int itemPosition     = position;
                   String  itemValue    = (String) listView.getItemAtPosition(position);

                    Toast.makeText(getApplicationContext(),itemValue , Toast.LENGTH_LONG).show();
                 
                  }
    
             }); 
         */
    }
    
	public void onItemClick(AdapterView<?> arg0, View arg1, int arg2, long arg3) {
		// TODO Auto-generated method stub
		
		//tv1.setText(((TextView) arg1).getText());
		tv1.setText(androidBooks[arg2]);
		
		//tv1.setText((String) listView.getItemAtPosition(arg2));
		
		//(Not Working)tv1.setText(arg0.getSelectedItem().toString());
		
	}
    
    
}