package com.implementations.hash;

import com.implementations.TextTwist;

public class TextTwistHashMap extends HashMap implements TextTwist {

	@Override
	public void insertInDictionary(String input) {
		put(Math.abs(input.hashCode()), input);

	}

	@Override
	public boolean searchWord(String word) {

		return get(Math.abs(word.hashCode())) != null;
	}

}
