package com.xwh.toolbardemo;

import java.util.ArrayList;

import com.xwh.toolbardemo.adapter.ViewPager_Adapter;
import com.xwh.toolbardemo.fragment.Fragment_Tab_1;
import com.xwh.toolbardemo.fragment.Fragment_Tab_2;
import com.xwh.toolbardemo.fragment.Fragment_Tab_3;
import com.xwh.toolbardemo.view.SlidingTabLayout;

import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.widget.Toolbar;
import android.os.Bundle;

public class MainActivity extends ActionBarActivity {

	private Toolbar toolbar;
	private SlidingTabLayout slidingTabLayout;
	private ViewPager viewPager;

	private ArrayList<Fragment> fragments;
	private ViewPager_Adapter viewPager_Adapter;

	private int screenX;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		screenX = caculateScreenX();
		findView();
	}

	// ��ȡ��Ļ���
	private int caculateScreenX() {
		return getResources().getDisplayMetrics().widthPixels;
	}

	// ��ʼ���ؼ�
	private void findView() {
		// ʵ�����ؼ�
		toolbar = (Toolbar) findViewById(R.id.demo_toolbar);
		slidingTabLayout = (SlidingTabLayout) findViewById(R.id.demo_tab);
		viewPager = (ViewPager) findViewById(R.id.demo_vp);
		// ����ViewPager
		fragments = new ArrayList<Fragment>();
		fragments.add(new Fragment_Tab_1());
		fragments.add(new Fragment_Tab_2());
		fragments.add(new Fragment_Tab_3());
		viewPager_Adapter = new ViewPager_Adapter(getSupportFragmentManager(),
				fragments);
		viewPager.setOffscreenPageLimit(fragments.size());
		viewPager.setAdapter(viewPager_Adapter);
		// ����SlidingTab
		slidingTabLayout.setViewPager(viewPager, screenX);
	}
}
