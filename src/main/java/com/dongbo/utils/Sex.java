package com.dongbo.utils;

public enum Sex {

	MAM,WOWAM;
	
	@Override
	public String toString() {
		String str = "Ů";
		switch (this) {
		case MAM:
			str =  "��";
			break;

		default:
			break;
		}
		return str;
	};
}
