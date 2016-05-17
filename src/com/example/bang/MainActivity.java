package com.example.bang;
import com.android.R;
import android.app.Activity; 
import android.app.TabActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RadioGroup.OnCheckedChangeListener;
import android.widget.TabHost;

public class MainActivity extends TabActivity {

	private TabHost tabhost;
	private RadioGroup main_radiogroup;  
	private RadioButton tab_icon_schools, tab_icon_res, tab_icon_me;   
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {    
		super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
	        
        main_radiogroup = (RadioGroup) findViewById(R.id.main_radiogroup);
        
        tab_icon_schools = (RadioButton) findViewById(R.id.tab_icon_schools);
        tab_icon_res = (RadioButton) findViewById(R.id.tab_icon_res);
        tab_icon_me = (RadioButton) findViewById(R.id.tab_icon_me);
        
        tabhost = getTabHost();
        tabhost.addTab(tabhost.newTabSpec("tag1").setIndicator("0").setContent(new Intent(this,SchoolFindsActivity.class)));
        tabhost.addTab(tabhost.newTabSpec("tag2").setIndicator("1").setContent(new Intent(this,ResLibActivity.class)));
        tabhost.addTab(tabhost.newTabSpec("tag3").setIndicator("2").setContent(new Intent(this,MeActivity.class)));
         
        checkListener checkradio = new checkListener();
        main_radiogroup.setOnCheckedChangeListener(checkradio);

	}
    public class checkListener implements OnCheckedChangeListener{
    	@Override
    	public void onCheckedChanged(RadioGroup group, int checkedId) {
    		switch(checkedId){
    		case R.id.tab_icon_schools:
    			tabhost.setCurrentTab(0);
    			break;
    		case R.id.tab_icon_res:
    			tabhost.setCurrentTab(1);
    			break;
    		case R.id.tab_icon_me:
    			tabhost.setCurrentTab(2);
    			break;
    		}

    	}
    }
}
