/*
 * Copyright (C) 2014 Mukesh Y authors
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.android.navigationdrawer;

import java.util.ArrayList;
import java.util.Arrays;

import android.content.Intent;
import android.content.res.Configuration;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v4.app.ActionBarDrawerToggle;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.util.Log;
import android.view.ActionProvider;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.SubMenu;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.actionbarsherlock.app.ActionBar;
import com.actionbarsherlock.app.SherlockActivity;
import com.actionbarsherlock.view.Menu;
import com.actionbarsherlock.view.MenuInflater;
import com.actionbarsherlock.view.MenuItem;
import com.android.Adapter.MenuDrawerListAdapter;
import com.android.Config.Config;

/**
 * @author Mukesh Y
 */
public class ListActivity extends SherlockActivity {

	String TAG = "ListActivity";
	private DrawerLayout mDrawerLayout;
	private ListView mDrawerList;
	private ActionBarDrawerToggle mDrawerToggle;
	private String[] menuItemTitles;
	ListView listView;
	private ArrayAdapter<String> listAdapter ; 

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_list);

		menuItemTitles = getResources().getStringArray(
				R.array.drawer_menu_itmes_array);
		mDrawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
		mDrawerList = (ListView) findViewById(R.id.left_drawer);
		listView = (ListView) findViewById(R.id.listView);
		
		// Create and populate a List of planet names.  
	    String[] planets = new String[] { "Mercury", "Venus", "Earth", "Mars",  
	                                      "Jupiter", "Saturn", "Uranus", "Neptune"};    

	    ArrayList<String> planetList = new ArrayList<String>();  
	    planetList.addAll( Arrays.asList(planets) );  
	      
	    // Create ArrayAdapter using the planet list.  
	    listAdapter = new ArrayAdapter<String>(this, R.layout.simplerow, planetList);  
	      
	    // Add more planets. If you passed a String[] instead of a List<String>   
	    // into the ArrayAdapter constructor, you must not add more items.   
	    // Otherwise an exception will occur.  
	    listAdapter.add( "Ceres" );  
	    listAdapter.add( "Pluto" );  
	    listAdapter.add( "Haumea" );  
	    listAdapter.add( "Makemake" );  
	    listAdapter.add( "Eris" );  
	      
	    // Set the ArrayAdapter as the ListView's adapter.  
	    listView.setAdapter( listAdapter ); 
		// set a custom shadow that overlays the main content when the drawer
		// opens
		mDrawerLayout.setDrawerShadow(R.drawable.drawer_shadow,
				GravityCompat.START);
		// set up the drawer's list view with items and click listener
		mDrawerList.setAdapter(new MenuDrawerListAdapter(this, menuItemTitles,
				Config.drawerMenuItemsIconIds));
		mDrawerList.setOnItemClickListener(new DrawerItemClickListener());

		// enable ActionBar app icon to behave as action to toggle nav drawer

		getSupportActionBar().setDisplayHomeAsUpEnabled(true);
		ActionBar ab = getSupportActionBar();
		ab.setBackgroundDrawable(getApplicationContext().getResources()
				.getDrawable(R.drawable.bg_titlebar_tile));
		ab.setLogo(getApplicationInfo().loadIcon(getPackageManager()));
		ab.setDisplayShowTitleEnabled(true);
		ab.setTitle("ListActivity");

		ab.setHomeButtonEnabled(true);
		mDrawerToggle = new ActionBarDrawerToggle(this, mDrawerLayout,
				R.drawable.ic_drawer, R.string.drawer_open,
				R.string.drawer_close);
		loadDrawer(mDrawerToggle, mDrawerLayout);
	}

	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		MenuInflater inflater = getSupportMenuInflater();
		inflater.inflate(R.menu.main, menu);

		return super.onCreateOptionsMenu(menu);
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		super.onOptionsItemSelected(item);
		if (mDrawerToggle.onOptionsItemSelected(getMenuItem(item))) {
			return true;
		}

		boolean drawerOpen = mDrawerLayout.isDrawerOpen(mDrawerList);
		if (drawerOpen) {
			Log.d(TAG, "" + drawerOpen);
			mDrawerLayout.closeDrawers();
		}
		switch (item.getItemId()) {

		}
		return true;

	}

	protected android.view.MenuItem getMenuItem(final MenuItem item) {
		return new android.view.MenuItem() {
			@Override
			public int getItemId() {
				return item.getItemId();
			}

			public boolean isEnabled() {
				return true;
			}

			@Override
			public boolean collapseActionView() {
				// TODO Auto-generated method stub
				return false;
			}

			@Override
			public boolean expandActionView() {
				// TODO Auto-generated method stub
				return false;
			}

			@Override
			public ActionProvider getActionProvider() {
				// TODO Auto-generated method stub
				return null;
			}

			@Override
			public View getActionView() {
				// TODO Auto-generated method stub
				return null;
			}

			@Override
			public char getAlphabeticShortcut() {
				// TODO Auto-generated method stub
				return 0;
			}

			@Override
			public int getGroupId() {
				// TODO Auto-generated method stub
				return 0;
			}

			@Override
			public Drawable getIcon() {
				// TODO Auto-generated method stub
				return null;
			}

			@Override
			public Intent getIntent() {
				// TODO Auto-generated method stub
				return null;
			}

			@Override
			public ContextMenuInfo getMenuInfo() {
				// TODO Auto-generated method stub
				return null;
			}

			@Override
			public char getNumericShortcut() {
				// TODO Auto-generated method stub
				return 0;
			}

			@Override
			public int getOrder() {
				// TODO Auto-generated method stub
				return 0;
			}

			@Override
			public SubMenu getSubMenu() {
				// TODO Auto-generated method stub
				return null;
			}

			@Override
			public CharSequence getTitle() {
				// TODO Auto-generated method stub
				return null;
			}

			@Override
			public CharSequence getTitleCondensed() {
				// TODO Auto-generated method stub
				return null;
			}

			@Override
			public boolean hasSubMenu() {
				// TODO Auto-generated method stub
				return false;
			}

			@Override
			public boolean isActionViewExpanded() {
				// TODO Auto-generated method stub
				return false;
			}

			@Override
			public boolean isCheckable() {
				// TODO Auto-generated method stub
				return false;
			}

			@Override
			public boolean isChecked() {
				// TODO Auto-generated method stub
				return false;
			}

			@Override
			public boolean isVisible() {
				// TODO Auto-generated method stub
				return false;
			}

			@Override
			public android.view.MenuItem setActionProvider(
					ActionProvider actionProvider) {
				// TODO Auto-generated method stub
				return null;
			}

			@Override
			public android.view.MenuItem setActionView(View view) {
				// TODO Auto-generated method stub
				return null;
			}

			@Override
			public android.view.MenuItem setActionView(int resId) {
				// TODO Auto-generated method stub
				return null;
			}

			@Override
			public android.view.MenuItem setAlphabeticShortcut(char alphaChar) {
				// TODO Auto-generated method stub
				return null;
			}

			@Override
			public android.view.MenuItem setCheckable(boolean checkable) {
				// TODO Auto-generated method stub
				return null;
			}

			@Override
			public android.view.MenuItem setChecked(boolean checked) {
				// TODO Auto-generated method stub
				return null;
			}

			@Override
			public android.view.MenuItem setEnabled(boolean enabled) {
				// TODO Auto-generated method stub
				return null;
			}

			@Override
			public android.view.MenuItem setIcon(Drawable icon) {
				// TODO Auto-generated method stub
				return null;
			}

			@Override
			public android.view.MenuItem setIcon(int iconRes) {
				// TODO Auto-generated method stub
				return null;
			}

			@Override
			public android.view.MenuItem setIntent(Intent intent) {
				// TODO Auto-generated method stub
				return null;
			}

			@Override
			public android.view.MenuItem setNumericShortcut(char numericChar) {
				// TODO Auto-generated method stub
				return null;
			}

			@Override
			public android.view.MenuItem setOnActionExpandListener(
					OnActionExpandListener listener) {
				// TODO Auto-generated method stub
				return null;
			}

			@Override
			public android.view.MenuItem setOnMenuItemClickListener(
					OnMenuItemClickListener menuItemClickListener) {
				// TODO Auto-generated method stub
				return null;
			}

			@Override
			public android.view.MenuItem setShortcut(char numericChar,
					char alphaChar) {
				// TODO Auto-generated method stub
				return null;
			}

			@Override
			public void setShowAsAction(int actionEnum) {
				// TODO Auto-generated method stub

			}

			@Override
			public android.view.MenuItem setShowAsActionFlags(int actionEnum) {
				// TODO Auto-generated method stub
				return null;
			}

			@Override
			public android.view.MenuItem setTitle(CharSequence title) {
				// TODO Auto-generated method stub
				return null;
			}

			@Override
			public android.view.MenuItem setTitle(int title) {
				// TODO Auto-generated method stub
				return null;
			}

			@Override
			public android.view.MenuItem setTitleCondensed(CharSequence title) {
				// TODO Auto-generated method stub
				return null;
			}

			@Override
			public android.view.MenuItem setVisible(boolean visible) {
				// TODO Auto-generated method stub
				return null;
			}
		};
	}

	/* The click listener for ListView in the navigation drawer */
	public class DrawerItemClickListener implements
			ListView.OnItemClickListener {
		@Override
		public void onItemClick(AdapterView<?> parent, View view, int position,
				long id) {

			switch (position) {
			case 0: {
				Intent list = new Intent(getApplicationContext(),
						ListActivity.class);
				startActivity(list);
				finish();
				break;
			}
			case 1: {
				Intent main = new Intent(getApplicationContext(),
						MainActivity.class);
				startActivity(main);
				finish();
				break;
			}
			case 2: {
				Intent list = new Intent(getApplicationContext(),
						ListActivity.class);
				startActivity(list);
				finish();
				break;
			}
			case 3: {

				break;
			}
			
			default:
				break;
			}
		}
	}

	/**
	 * When using the ActionBarDrawerToggle, you must call it during
	 * onPostCreate() and onConfigurationChanged()...
	 */

	@Override
	protected void onPostCreate(Bundle savedInstanceState) {
		super.onPostCreate(savedInstanceState);
		// Sync the toggle state after onRestoreInstanceState has occurred.
		mDrawerToggle.syncState();
	}

	@Override
	public void onConfigurationChanged(Configuration newConfig) {
		super.onConfigurationChanged(newConfig);
		// Pass any configuration change to the drawer toggles
		mDrawerToggle.onConfigurationChanged(newConfig);
	}

	public void loadDrawer(ActionBarDrawerToggle mDrawerToggle2,
			DrawerLayout mDrawerLayout2) {
		mDrawerToggle = mDrawerToggle2;
		mDrawerLayout = mDrawerLayout2;
		mDrawerLayout.setDrawerListener(mDrawerToggle);
	}
}
