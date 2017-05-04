package de.htwgkonstanz.win.swqs.junitdemo;

import java.util.List;

public class MathHelpers {
	public static int ggT(List<Integer> values) {
		if (values.isEmpty()) {
			throw new IllegalArgumentException();
		}
		int value = values.get(0);
		for (int i = 1; i < values.size(); i++) {
			int a = values.get(i);
			int b = value;
			while (b != 0) {
				if (a > b)
					a = a - b;
				else
					b = b - a;
			}
			value = a;
		}
		return value;
	}
}
