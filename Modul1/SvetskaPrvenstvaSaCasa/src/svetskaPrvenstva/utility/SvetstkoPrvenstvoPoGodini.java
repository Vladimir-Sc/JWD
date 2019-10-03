package svetskaPrvenstva.utility;

import java.util.Comparator;

import svetskaPrvenstva.model.SvetskoPrvenstvo;

public class SvetstkoPrvenstvoPoGodini implements Comparator<SvetskoPrvenstvo> {

	@Override
	public int compare(SvetskoPrvenstvo s1, SvetskoPrvenstvo s2) {
		if (s1.getGodina()>s2.getGodina())
			return 1;
		else if (s1.getGodina()==s2.getGodina())
			return 0;
		else
			return -1;
//		return s1.getGodina()-s2.getGodina();
	}

}
