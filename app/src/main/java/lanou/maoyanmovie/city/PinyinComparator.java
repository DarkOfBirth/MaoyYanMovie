package lanou.maoyanmovie.city;

import java.util.Comparator;

/**
 * 
 * @author xiaanming
 *
 */
public class PinyinComparator implements Comparator<CityBean.CtsBean> {

	public int compare(CityBean.CtsBean o1, CityBean.CtsBean o2) {

			return o1.getPy().compareTo(o2.getPy());

	}

}
