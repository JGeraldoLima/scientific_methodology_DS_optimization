package com.implementations.list;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;

import com.implementations.TextTwist;

public class TextTwistList implements TextTwist {

	private static List<String> values;

	public TextTwistList() throws FileNotFoundException {
		values = new ArrayList<String>();
	}

	@Override
	public void insertInDictionary(String data) {
		values.add(data);
	}

	@Override
	public boolean searchWord(String word) {
		return values.contains(word);
	}
}