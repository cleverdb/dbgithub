package com.dongbo.utils;

public enum Sex {

	MAM,WOWAM;
	
	@Override
	public String toString() {
		String str = "Å®";
		switch (this) {
		case MAM:
			str =  "ÄÐ";
			break;

		default:
			break;
		}
		return str;
	};
}
