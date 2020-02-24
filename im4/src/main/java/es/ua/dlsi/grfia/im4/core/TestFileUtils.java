/*
 * Copyright (C) 2014 David Rizo Valero
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
package es.ua.dlsi.grfia.im4.core;

import java.io.File;
import java.io.IOException;
import java.net.URL;

/**
 * It reads files for test correctly in Maven
 * 
 * @author drizo
 */
public class TestFileUtils {
	static File TMP_FOLDER = null;

	public static File getFile(String filename) {
		TestFileUtils t = new TestFileUtils();
		return t.run(filename);
	}

	public static File getFile(String folder, String file) {
		TestFileUtils t = new TestFileUtils();
		return t.run(folder + "/" + file);
	}

	private File run(String filename) {
		URL url = getClass().getResource(filename);
		if (url == null) {
			throw new RuntimeException("Cannot find the filename '" + filename + "'");
		}
		File f = new File(url.getFile());
		return f;

	}

    public static File createTempFile(String s) {
		if (TMP_FOLDER == null) {
			TMP_FOLDER = new File("/tmp");
			if (!TMP_FOLDER.exists()) {
				try {
					File f = File.createTempFile("test", null);
					TMP_FOLDER = f.getParentFile();
				} catch (IOException e) {
					e.printStackTrace();
					throw new IM4RuntimeException("Cannot create a temporary file for tests");
				}

			}
		}
		return new File(TMP_FOLDER, s);
    }

    public static File createTempFolder(String name) {
        if (TMP_FOLDER == null) {
            TMP_FOLDER = new File("/tmp");
            if (!TMP_FOLDER.exists()) {
                try {
                    File f = File.createTempFile("test", null);
                    TMP_FOLDER = f.getParentFile();
                } catch (IOException e) {
                    e.printStackTrace();
                    throw new IM4RuntimeException("Cannot create a temporary file for tests");
                }

            }
        }
        File file = new File(TMP_FOLDER, name);
        file.mkdir();
        return file;
    }
}
