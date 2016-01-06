package cn.zj.sunda.water.bean;

import java.util.Comparator;

import cn.zj.sunda.water.bo.Menus;

public class ComparatorMenu implements Comparator<Menus> {

	public int compare(Menus o1, Menus o2) {
		
		String location1 = o1.getLocation();
		String location2 = o2.getLocation();
		float f1 = Float.parseFloat(location1);
		float f2 = Float.parseFloat(location2);
		int flag =0;
		if(f1>f2)
		{
			flag=1;
		}
		
		return flag;
	}

}
