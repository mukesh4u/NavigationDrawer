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
package com.android.Adapter;

import java.util.ArrayList;
import java.util.Arrays;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.android.navigationdrawer.R;

public class MenuDrawerListAdapter extends ArrayAdapter<String>{

	private final Activity context;
	private final ArrayList<String> menuDrawerItemNameArray;
	private final ArrayList<Integer> menuItemsIconIds;
	
	public MenuDrawerListAdapter(Activity context, String[] mItemTitles, Integer[] menuItemsIconIds) {
		super(context,R.layout.list_item_menu_drawer, mItemTitles);
		this.context=context;
		
		 
		this.menuDrawerItemNameArray=new ArrayList<String>(Arrays.asList(mItemTitles));
		this.menuItemsIconIds=new ArrayList<Integer>(Arrays.asList(menuItemsIconIds));
		
		
	}

	static class ViewHolder {
		public ImageView drawerMenuItemIcon;
		public TextView  drawerMenuItemName;
	}
	
	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		View rowView = convertView;
		ViewHolder viewHolder = new ViewHolder();  // to reference the child views for later actions
		if (null == rowView) {
			LayoutInflater inflater = (LayoutInflater) this.context
					.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
			rowView = inflater.inflate(R.layout.list_item_menu_drawer, null);
			viewHolder.drawerMenuItemIcon=(ImageView)rowView.findViewById(R.id.menu_item_icon);
			viewHolder.drawerMenuItemName = (TextView) rowView.findViewById(R.id.menu_item_name);
			float  d=context.getResources().getDisplayMetrics().density;
			if(d==2.0 || d==3.0){
				viewHolder.drawerMenuItemName.getLayoutParams().height=70;
				viewHolder.drawerMenuItemIcon.getLayoutParams().width=70;
			}
			rowView.setTag(viewHolder);
		}
		else {
			// view already exists, get the holder instance from the view
			viewHolder = (ViewHolder) rowView.getTag();
		}
		viewHolder.drawerMenuItemIcon.setImageResource(menuItemsIconIds.get(position));
		viewHolder.drawerMenuItemName.setText(menuDrawerItemNameArray.get(position));
		
		return rowView;
	}
	
	@Override
	public int getCount() {
		return menuDrawerItemNameArray.size();
	}

	@Override
	public String getItem(int position) {
		return menuDrawerItemNameArray.get(position);
	}
}
