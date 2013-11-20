/*
 * Copyright 2006 Sun Microsystems, Inc.
 */

package ca.weblite.codename1.json;

import java.io.IOException;
import java.io.Writer;

/**
 * A simple StringBuilder-based implementation of StringWriter
 */
public class StringWriter extends Writer {
    
    final private StringBuilder buf;
    
    public StringWriter() {
        super();
        buf = new StringBuilder();
    }
    
    public StringWriter(int initialSize) {
        super();
        buf = new StringBuilder(initialSize);
    }
    
    public void write(char[] cbuf, int off, int len) throws IOException {
        buf.append(cbuf, off, len);
    }

    public void write(String str) throws IOException {
        buf.append(str);
    }

    public void write(String str, int off, int len) throws IOException {
        buf.append(str.substring(off, len));
    }

    public void flush() throws IOException {
    }

    public void close() throws IOException {
    }
}
