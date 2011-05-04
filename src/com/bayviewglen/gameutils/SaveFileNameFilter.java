package com.bayviewglen.gameutils;

import java.io.File;
import java.io.FilenameFilter;

public class SaveFileNameFilter implements FilenameFilter{
	/* (non-Javadoc)
	 * @see java.io.FilenameFilter#accept(java.io.File, java.lang.String)
	 */
	public boolean accept(File dir, String name) {
		return (name.endsWith(".sav"));

	}
}
