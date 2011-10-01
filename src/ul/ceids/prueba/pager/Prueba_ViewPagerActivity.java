package ul.ceids.prueba.pager;

import java.lang.reflect.GenericDeclaration;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;

public class Prueba_ViewPagerActivity extends FragmentActivity
						{
    private ViewPager pager;
    private SwipeyTabs tabs;
    
    private CustomFragmentAdapter fragmentAdapter = null;
    private SwipeyTabsPagerAdapter swipeyPagerAdapter = null;
    
    private static String [] TITLE = new String[]{"Pager 1", "Pager 2", "Pager 3"};
    
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
     
        this.pager = (ViewPager) findViewById(R.id.pager);
        this.tabs = (SwipeyTabs) findViewById(R.id.swipeytabs);
        
        this.fragmentAdapter = new CustomFragmentAdapter(getSupportFragmentManager());
        this.swipeyPagerAdapter = new SwipeyTabsPagerAdapter(this, getSupportFragmentManager());
        
        this.fragmentAdapter.addFragment(new CustomFragment1());
        this.fragmentAdapter.addFragment(new CustomFragment2());
        this.fragmentAdapter.addFragment(new CustomFragment3());
        
        this.pager.setAdapter(this.fragmentAdapter);
        this.tabs.setAdapter(swipeyPagerAdapter);
        
        this.pager.setOnPageChangeListener(this.tabs);
        this.pager.setCurrentItem(0);
    }

	
	
	 private class SwipeyTabsPagerAdapter extends FragmentPagerAdapter implements
     SwipeyTabsAdapter {

		 	private final Context mContext;

		 	public SwipeyTabsPagerAdapter(Context context, FragmentManager fm) {
		 		super(fm);

		 		this.mContext = context;
		 	}

		 	@Override
		 	public Fragment getItem(int position) {
		 		return SwipeyTabFragment.newInstance(TITLE[position]);
		 	}

		 	@Override
		 	public int getCount() {
		 		return TITLE.length;
		 	}

		 	public TextView getTab(final int position, SwipeyTabs root) {
		 		TextView view = (TextView) LayoutInflater.from(mContext).inflate(
                     R.layout.swyper_page_item, root, false);
		 		view.setText(TITLE[position]);
		 		view.setOnClickListener(new OnClickListener() {
             public void onClick(View v) {
                     pager.setCurrentItem(position);
             }
		 });
     
		return view;
	}

	 }
}