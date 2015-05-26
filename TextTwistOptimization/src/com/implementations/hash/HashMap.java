package com.implementations.hash;

public class HashMap {

	private static int TABLE_SIZE = 128000;

	HashEntry[] table;

	HashMap() {

		table = new HashEntry[TABLE_SIZE];

		for (int i = 0; i < TABLE_SIZE; i++)

			table[i] = null;

	}

	public String get(int key) {

		int hash = (key % TABLE_SIZE);
		int i = 1;
		while (table[hash] != null && table[hash].getKey() != key
				&& i < TABLE_SIZE)

			hash = (hash + i++) % TABLE_SIZE;

		if (table[hash] == null)

			return null;

		else

			return table[hash].getValue();

	}

	public void put(int key, String value) {

		int hash = (key % TABLE_SIZE);
		int i = 1;
		while (table[hash] != null && table[hash].getKey() != key
				&& i < TABLE_SIZE)

			hash = (hash + i++) % TABLE_SIZE;
		if (i >= TABLE_SIZE) {
			doubleSize(key, value);
		}

		table[hash] = new HashEntry(key, value);

	}

	private void doubleSize(int key, String value) {
		HashEntry[] temptable = new HashEntry[TABLE_SIZE * 2];
		for (int i = 0; i < TABLE_SIZE; i++) {
			temptable[i] = table[i];
		}
		TABLE_SIZE = TABLE_SIZE * 2;
		table = temptable;
	}

}