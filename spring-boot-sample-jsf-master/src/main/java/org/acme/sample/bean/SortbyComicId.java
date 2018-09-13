package org.acme.sample.bean;

import java.util.Comparator;

import org.acme.sample.model.Comic;

public class SortbyComicId implements Comparator<Comic> {

	@Override
	public int compare(Comic a, Comic b) {
		return a.getIdComic()-b.getIdComic();
	}

}
