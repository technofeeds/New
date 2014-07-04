package com.example.test.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.view.View;
import android.widget.Toast;

import com.example.test.R;
import com.example.test.activity.MainFragmentActivity;
import com.example.test.util.LogUtils;

public class BaseContainerFragment extends Fragment {

    protected MainFragmentActivity mActivity;
    protected View mRootView;
    

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mActivity = (MainFragmentActivity) this.getActivity();
    }

	public void replaceFragment(Fragment fragment, boolean addToBackStack) {
		FragmentTransaction transaction = getChildFragmentManager().beginTransaction();
		if (addToBackStack) {
			transaction.addToBackStack(null);
		}
		transaction.replace(R.id.container_framelayout, fragment);
		transaction.commit();
		getChildFragmentManager().executePendingTransactions();
	}
	
	public boolean popFragment() {
		LogUtils.warnLog("control", "pop fragment: " + getChildFragmentManager().getBackStackEntryCount());
		boolean isPop = false;
		if (getChildFragmentManager().getBackStackEntryCount() > 0) {
			isPop = true;
			getChildFragmentManager().popBackStack();
			
		}
		return isPop;
	}


    protected void showDevMsg() {
        Toast.makeText(mActivity, "Coming Soon!!", Toast.LENGTH_SHORT).show();
    }

    protected void showDevMsg(String text) {
        Toast.makeText(mActivity, text, Toast.LENGTH_SHORT).show();
    }
}
