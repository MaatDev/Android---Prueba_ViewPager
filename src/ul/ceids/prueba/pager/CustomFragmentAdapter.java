package ul.ceids.prueba.pager;

import java.util.ArrayList;
import java.util.List;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

public class CustomFragmentAdapter extends FragmentPagerAdapter{

	public List<Fragment> fragments = null;
	
	public CustomFragmentAdapter(FragmentManager fm) {
		super(fm);
		this.fragments = new ArrayList<Fragment>();
	}

	public void addFragment(Fragment fragment){
		this.fragments.add(fragment);
	}	
	
	@Override
	public Fragment getItem(int position) {
		return fragments.get(position);
	}

	@Override
	public int getCount() {
		return fragments.size();
	}

}
