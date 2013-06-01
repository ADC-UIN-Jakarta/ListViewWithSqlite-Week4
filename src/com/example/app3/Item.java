package com.example.app3;

public class Item {

	private long id;
	private String name;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	// override method toString untuk menampilkan string di list view sesuai
	// dengan keinginan

	@Override
	public String toString() {

		String stringAppearInListView = "" + id + " : " + this.name;
		return stringAppearInListView;
	}
}
