package com.hornsey.effectivejava.chapter12;

import javax.xml.crypto.Data;
import java.io.Serializable;
import java.util.Date;

/**
 * @author huangtao
 * @date 2020/8/9
 */
public final class Period implements Serializable {
	private static final long serialVersionUID = 1L;
	private final Date start;
	private final Date end;

	public Period(Date start, Date end) {
		this.start = new Date(start.getTime());
		this.end = new Date(end.getTime());

		if (start.compareTo(end) > 0) {
			throw new IllegalArgumentException(start + " after " + end);
		}
	}

	public Date getStart() {
		return new Date(start.getTime());
	}

	public Date getEnd() {
		return new Date(end.getTime());
	}

	@Override
	public String toString() {
		return "Period(" + start + " - " + end + ')';
	}
}
